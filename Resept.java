// Ikke mulig å opprette instanser av Resept-klassen (abstract).
// Hvert objekt skal ha unik id i stigende rekkefølge.
// Instansvariabel idNr holder styr på hvor mange objekter som er opprettet av klassen Resept,
// og reseptId settes utifra den. 
public abstract class Resept {

    public Legemiddel legemiddel;
    public Lege utskrivendeLege;
    public int pasientId;
    public int reit;
    public int reseptId;
    public static int idNr = 0;

    // Konstruktør
    public Resept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;
        reseptId = idNr;
        idNr++;
    }

    public int hentId() {return reseptId;}

    public Legemiddel hentLegemiddel() {return legemiddel;}

    public Lege hentLege() {return utskrivendeLege;}

    public int hentPasientId() {return pasientId;}

    public int hentReit() {return reit;}

    // Gir false om resepten allerede er oppbrukt. True om den ikke er det.
    // Om resepten ikke er oppbrukt brukes den én gang (reit-1). 
    public boolean bruk() {
        if (reit == 0) {return false;}
        else {
            reit--;
            return true;}
    }

    // Overrides i subklassene.
    abstract public String farge();

    // Overrides i subklassene.
    abstract public int prisAaBetale();

    // Overrider toString med info, overrides også i subklassene.
    @Override
    public String toString() {
        String streng = "Legemiddel: " + legemiddel.hentNavn() + "\n" + "Lege: " + utskrivendeLege.hentNavn() + "\n" + "PasientId: " + pasientId + "\n" + "Reit: " + reit + "\n" + "ReseptId: " + reseptId;
        return streng;
    }

}