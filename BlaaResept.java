import java.lang.Math;

// Subklasse av Resept, har ingen egne instansvariabler.
// prisAaBetale er alltid 0.25% av prisen, rundes opp til heltall. 
public class BlaaResept extends Resept {

    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit) {
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override
    public String farge() {return "Blaa";}

    // Overrider prisAaBetale() for å legge til rabatt (75%).
    @Override
    public int prisAaBetale() {return (int) Math.round(legemiddel.hentPris()*0.25);}

    // Overrider toString() for å legge til mer info.
    @Override
    public String toString() {
        String streng = super.toString() + "\n" + "Farge: " + farge() + "\n" + "Pris: " + prisAaBetale() + "kr";
        return streng;
    }
}