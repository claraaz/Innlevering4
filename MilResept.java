// Subklasse av HvitResept, har ingen egne instansvariabler. 
// Reit settes alltid til 3.
// prisAaBetale() returnerer alltid 0.
// Har ingen egen toString() da den ikke inneholder mer info enn det som er i Resept-klassen.
public class MilResept extends HvitResept {

    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient) {
        super(legemiddel, utskrivendeLege, pasient, 3);
    }

    @Override
    public String farge() {return "Hvit";}

    // Overrider prisAaBetale for å legge til rabatt.
    @Override
    public int prisAaBetale() {return 0;}
}