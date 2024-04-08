public class Vanlig extends Legemiddel {

    // har samme konstruktør som superklassen Legemiddel.  
    public Vanlig(String navn, int pris, double virkestoff) {
        super(navn, pris, virkestoff);
    }
    
    // har ingen egen toString() da klassen Vanlig ikke inneholder mer info enn Legemiddel-klassen.
}