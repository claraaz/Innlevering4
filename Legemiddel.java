// Ikke mulig å opprette instanser av Legemiddel-klassen (abstract).
// Hvert objekt skal ha unik id i stigende rekkefølge.
// Instansvariabel idNr holder styr på hvor mange objekter som er opprettet av klassen Legemiddel,
// og id settes utifra den. 
public abstract class Legemiddel {

    public final String navn;
    public int pris;
    public final double virkestoff; // i mg.
    public final int id;
    public static int idNr = 0;

    // Konstruktør
    public Legemiddel(String navn, int pris, double virkestoff) {
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        id = idNr;
        idNr++;
    }

    public int hentId() {return id;}

    // Returnerer prisen (int)
    public int hentPris() {return pris;}

    // Tar inn en parameter (int) og oppdaterer prisen til den
    public void settNyPris(int nyPris) {pris = nyPris;}

    // Overrider toString med info, overrides også i subklassene.
    @Override
    public String toString() {
        String streng = "Legemiddel: " + navn + "\n" + "Pris: " + pris + "kr" + "\n" + "Virkestoff i mg: " + virkestoff + "\n" + "Id: " + id;
        return streng;
    }

    // hjelpemetode til toString i Resept-klassen.
    public String hentNavn() {return navn;}
}