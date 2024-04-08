import java.util.Iterator;

// I en lenkeliste legges nye objekter til sist i listen,
// og de som ble lagt til først, fjeres først (først i listen)

// Jeg har i alle listene uten prioritetskø tatt høyde for at man ikke skal kunne legge til elementer med lik data. 
// Det var noe vi gjorde i plenumstimen, og jeg missforstod og tenkte det var god praksis. 
// Ettersom alle testen kjører fint, har jeg latt det være i koden. I prioritetskø viser jeg at jeg kan å 
// implementere metodene hvor like elementer legges til.

abstract class Lenkeliste<E> implements Liste<E>{
    
    public int stoerrelse = 0;
    public Node foerste = null, siste = null;

    protected class Node {
        public E data = null;
        public Node neste = null, forrige = null;

        public Node(E data) {
            this.data = data;
        }
    }

    @Override
    public Iterator<E> iterator(){
        return new LenkelisteIterator();
    }

    private class LenkelisteIterator implements Iterator<E>{

        Node peker = foerste;

        @Override
        public boolean hasNext(){
            return peker != null;
        }

        @Override 
        public E next(){
            E data = peker.data;
            peker = peker.neste;
            return data;
        }
    }
    
    public int stoerrelse() {return stoerrelse;}

    // Har endret fra "E x" til " E data" da jeg synes det gir mer forståelig kode.
    // Legger til sist i listen.
    public void leggTil(E data) {
        Node ny = new Node(data);

        // Hvis listen er tom:
        if (stoerrelse() == 0) {
            foerste = siste = ny;
            stoerrelse++;
            return; 
        }

        Node peker = foerste;

        // Så lenge peker ikke er er null og objektet den peker på ikke har samme data, 
        // så går den videre til neste objekt i den lenkede listen.
        while (peker != null && !peker.data.equals(data)) {
            peker = peker.neste;
        }

        // Peker har kommet til slutten av listen
        // Legger til på slutten av listen:
        if (peker == null) {
            siste.neste = ny;
            ny.forrige = siste;
            siste = ny;
            stoerrelse++;
            return;
        }

        // Peker er ikke null og peker på en node som inneholder samme data som parameter i metoden.
        // Finnes ikke to noder med lik data, så den nye noden legges ikke til.
    }

    // Returnerer dataen til det første objektet i listen, kan være null om listen er tom.
    public E hent() {return foerste.data;}

    // Fjerner første objekt i listen
    public E fjern() {
        E retur = null;
        
        // Listen er tom:
        if (stoerrelse() == 0) {throw new UgyldigListeindeks(stoerrelse);}

        // Vi har ett objekt i listen:
        if (stoerrelse() == 1) {
            retur = foerste.data; // tar vare på data fra noden vi skal fjerne så vi kan returenere den
            foerste = siste = null;
            stoerrelse--;
            return retur;
        }

        // Har mer enn ett objekt i listen:
        Node peker = foerste;
        if (stoerrelse() > 1) {
            retur = foerste.data; // tar vare på data fra noden vi skal fjerne så vi kan returenere den
            foerste = peker.neste;
            peker.neste.forrige = null;
            peker = peker.neste;
            stoerrelse--;
            return retur;
        }
        return retur;
    }

    // Skriver ut data til alle objektene i den lenkede listen på en oversiktlig måte
    @Override
    public String toString() {
        String streng = "";
        Node peker = foerste;

        while (peker != null) {
            streng += peker.data.toString() + "\n";
            peker = peker.neste;
        }
        return streng;
    }
}