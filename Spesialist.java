// Subklasse av Lege, implementerer inteface Godkjenningsfritak.
// Godkjenningsfritak gir Spesialist godkjenningsfritak til å skrive ut resept på narkotiske legemidler.
public class Spesialist extends Lege implements Godkjenningsfritak {

    public String kontrollkode;

    public Spesialist(String navn, String kontrollkode) {
        super(navn);
        this.kontrollkode = kontrollkode;
    }

    @Override
    public String hentKontrollkode() {return kontrollkode;}

    // invariant1 --> kun i skrivBlaaResept kan Narkotisk legemiddel sendes med som parameter

    @Override
    public HvitResept skrivHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) {
            HvitResept ny = new HvitResept(legemiddel, this, pasient, reit);
            utskrevneResepter.leggTil(0, ny);
            return ny;
    }

    @Override
    public MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient) {
        MilResept ny = new MilResept(legemiddel, this, pasient);
        utskrevneResepter.leggTil(0, ny);
        return ny;
    }

    @Override
    public PResept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) {
        PResept ny = new PResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(0, ny);
        return ny;
    }

    @Override
    public BlaaResept skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit){
        BlaaResept ny = new BlaaResept(legemiddel, this, pasient, reit);
        utskrevneResepter.leggTil(0,ny);
        return ny;
    }

    // Overrider toString() for å skrive ut mer info.
    @Override
    public String toString() {
        return super.toString() + "\n" + "Kontrollkode: " + kontrollkode;
    }
}