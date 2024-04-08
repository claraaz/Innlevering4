// Subklasse av HvitResept, har ingen egen instansvariabler.
// prisAaBetale() trekker fra 108kr fra prisen, kan totalt ikke bli mindre enn 0.
// Har ingen egen toString() da den ikke inneholder mer info enn det som er i Resept-klassen.
public class PResept extends HvitResept {

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public String farge() {return "Hvit";}

    // Overrider prisAaBetale for å legge til rabatt. Prisen kan ikke bli under 0. 
    @Override
    public int prisAaBetale() {
        if (legemiddel.hentPris() < 108) return 0;
        return legemiddel.hentPris() - 108;
    }
}