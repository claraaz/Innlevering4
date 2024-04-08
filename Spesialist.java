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

    // Overrider toString() for å skrive ut mer info.
    @Override
    public String toString() {
        return super.toString() + "\n" + "Kontrollkode: " + kontrollkode;
    }
}