// Subklasse av Resept, men har ikke noe mer egen info, har egne subklasser MilResept og PResept.
public class HvitResept extends Resept {

    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    // Returnerer reseptens farge, hvit eller blaa.
    @Override
    public String farge() { return "Hvit";}

    // Returnerer prisen pasienten skal betale
    @Override
    public int prisAaBetale() {return legemiddel.hentPris();}

    // Overrider toString() fra Resept.
    @Override
    public String toString() {
        String streng = super.toString() + "\n" + "Farge: " + farge() + "\n" + "Pris: " + prisAaBetale() + "kr";
        return streng;
    }
}