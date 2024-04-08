public class Lege {

    public String navn;

    public Lege(String navn) {
        this.navn = navn;
    }

    public String hentNavn() {return navn;}

    // Overrider toString() for å skrive ut info.
    @Override
    public String toString() {
        return "Lege: " + navn;
    }
}