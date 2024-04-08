// En sortert prioritetskø, fra størst til minst.
// Objekter legges til selv om de har lik data.
// Metodene hent() og fjern() skal hente/fjerne det minste elementet, 
// det er det første elementet, så det er likt som i superklassen Lenkeliste.
// A.compareTo(B) gir et positivt heltall om A er større enn B.
class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E> {

    // Legges til i rekkefølge fra minst til størst.
    @Override 
    public void leggTil(E data) {
        Node ny = new Node(data);
        
        // Listen er tom:
        if (stoerrelse() == 0) {
            foerste = siste = ny;
            stoerrelse++;
            return;
        }

        Node peker = foerste;
        // Vil at peker skal stoppe før den peker på null (utenfor listen), 
        // gjør det ved å sjekke om peker sin neste er null og går da ikke videre.
        // Om peker sin neste ikke er null, sjekker den om peker er mindre enn ny (node).
        // While løkken sjekker første del av &&-setningen først, om den er false, sjekker den ikke andre del.
        while (peker.neste != null && peker.data.compareTo(ny.data) < 0) {
            peker = peker.neste;
        }
        
        // Objektet skal legges først i listen, er minst:
        // Sjekker om objektet peker stopper på er større enn objektet vi skal legge til.
        if (peker == foerste && peker.data.compareTo(ny.data) > 0) {
            foerste.forrige = ny;
            ny.neste = foerste;
            foerste = ny;
            stoerrelse++;
            return;
        }

        // Objektet skal inn sist i listen, er størst:
        // Sjekker om objektet peker stopper på er mindre enn objektet vi skal legge til.
        else if (peker == siste && peker.data.compareTo(ny.data) < 0) {
            siste.neste = ny;
            ny.forrige = siste;
            siste = ny;
            stoerrelse++;
            return;
        }

        // Objektet skal inn midt i listen:
        else {
            peker.forrige.neste = ny;
            ny.forrige = peker.forrige;
            ny.neste = peker;
            peker.forrige = ny;
            return;
        }
    }
}