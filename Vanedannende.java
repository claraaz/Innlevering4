public class Vanedannende extends Legemiddel {

    public final int styrke;

    // Tar inn (vanedannende) styrke som parameter i tillegg til parametrene til Legemiddel.
    public Vanedannende(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    // Overrider toString() fra Legemiddel. 
    @Override
    public String toString() {
        String streng = super.toString() + "\n" + "Vanedannende styrke: " + styrke;
        return streng;
    }
}