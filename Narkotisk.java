public class Narkotisk extends Legemiddel {
    
    public final int styrke;

    // Tar inn (narkotisk) styrke som parameter i tillegg til paramtrene til Legemiddel
    public Narkotisk(String navn, int pris, double virkestoff, int styrke) {
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    // Overrider toString() fra Legemiddel. 
    @Override
    public String toString() {
        String streng = super.toString() + "\n" + "Narkotisk styrke: " + styrke;
        return streng;
    }

}