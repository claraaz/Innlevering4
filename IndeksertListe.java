// Parameter pos følger tellemåten til indeks, indeks 0 har pos(isjon) 0. 
class IndeksertListe<E> extends Lenkeliste<E> {

    // Legger til på gitt posisjon.
    public void leggTil (int pos, E data){
        Node ny = new Node(data);

        // Den gitte posisjonen er ugyldig:
        if (pos > stoerrelse() || pos < 0) {throw new UgyldigListeindeks(pos);}

        // Listen er tom:
        if (stoerrelse() == 0) {
            foerste = siste = ny;
            stoerrelse++;
            return;
        }

        // Det finnes et objekt med samme data fra før:
        Node peker = foerste;
        while (peker != null && !peker.data.equals(data)) {
            peker = peker.neste;
        }

        // Den peker på et objekt med samme data:
        if (peker!= null) {return;}

        peker = foerste;
        // Legger til først i listen:
        if (pos == 0){
            foerste.forrige = ny;
            ny.neste = foerste;
            foerste = ny;
            stoerrelse++;
            return;
        } 

        // Legger til sist i listen, etter siste objekt:
        if (pos == stoerrelse()) {
            siste.neste = ny;
            ny.forrige = siste;
            siste = ny;
            stoerrelse++;
            return;
        } 

        // Legger til midt i listen:
        else {
            for (int i=0; i<pos; i++) {
                peker = peker.neste;
            }     

            peker.forrige.neste = ny;
            ny.forrige = peker.forrige;
            peker.forrige = ny;
            ny.neste = peker;
            stoerrelse++;
            
            return;
        }
    }

    // Erstatter objektet i gitt posisjon med parameter som er gitt.
    // Istedenfor å bytte ut hele noden, oppdaterer jeg data til noden som er der.
    public void sett (int pos, E data) {
        Node peker = foerste;

        if (pos >= 0 && pos < stoerrelse()) {
            for (int i = 0; i < pos; i++) {
                peker = peker.neste;
            }
            peker.data = data;

        } else {throw new UgyldigListeindeks(pos);}
    }

    // Henter objeketet på gitt posisjon.
    public E hent (int pos) {
        Node peker = foerste;

        if (pos >= 0 && pos < stoerrelse()) {
            for (int i = 0; i < pos; i++) {
                peker = peker.neste;
            }
            return peker.data;

        } else {throw new UgyldigListeindeks(pos);}
    }

    // Fjerner fra gitt posisjon.
    public E fjern (int pos) {
        E retur = null;
        
        // Den gitte posisjonen er ugyldig eller listen er tom:
        if (pos>=stoerrelse() || pos<0 || stoerrelse() == 0) {throw new UgyldigListeindeks(pos);}

        Node peker = foerste;
        // Det er ett element i listen:
        if (stoerrelse() == 1) {
            retur = peker.data;
            foerste = siste = null;
            stoerrelse--;
            return retur;
        }
        // Det er mer enn ett element:
        // Fjerner det første elementet:
        if (pos == 0) {
            retur = foerste.data;
            foerste.neste.forrige = null;
            foerste = foerste.neste;
            stoerrelse--;
            return retur;
        }

        // Fjerner det siste elementet:
        if (pos == stoerrelse()-1) {
            retur = siste.data;
            siste.forrige.neste = null;
            siste = siste.forrige;
            stoerrelse--;
            return retur;
        }

        // Fjerner fra midt i listen:
        else {
            for (int i=0; i<pos; i++) {
                peker = peker.neste;
            }

            retur = peker.data;
            peker.forrige.neste = peker.neste;
            peker.neste.forrige = peker.forrige;
            return retur;
        }
    }
}