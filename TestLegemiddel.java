public class TestLegemiddel {

    // Jeg har kopiert denne fra testCelle fra Oblig1. 
     public static void sjekk(String hva, boolean test) {
        if (! test) {
            System.out.println("Sjekken '" + hva + "' feilet!");
            System.exit(1);
        }
    }
    
    public static boolean testLegemiddelId(Legemiddel legemiddel, int forventetLegemiddelId) {
        return legemiddel.id == forventetLegemiddelId;
    }

    public static boolean testLegemiddelNavn(Legemiddel legemiddel, String forventetNavn) {
        return legemiddel.navn == forventetNavn;
    }

    public static boolean testLegemiddelPris(Legemiddel legemiddel, int forventetPris) {
        return legemiddel.pris == forventetPris;
    }

    public static boolean testLegemiddelVirkestoff(Legemiddel legemiddel, double forventetVirkestoff) {
        return legemiddel.virkestoff == forventetVirkestoff;
    }

    public static boolean testNarkotiskStyrke(Narkotisk narkotisk, int styrke) {
        return narkotisk.styrke == styrke;
    }

    public static boolean testVanedannendeStyrke(Vanedannende vanedannende, int styrke) {
        return vanedannende.styrke == styrke;
    }

    public static void main(String[] args) {

        Narkotisk valium = new Narkotisk("Valium", 250, 10.5, 7);
        Vanedannende nesespray = new Vanedannende("Nesespray", 150, 5.5, 4);
        Vanlig paracet = new Vanlig("Paracet", 50, 10.0);

        // Test på narkotisk legemiddel:
        sjekk("testLegemiddelId() Narkotisk", testLegemiddelId(valium,0));
        sjekk("testLegemiddelNavn() Narkotisk", testLegemiddelNavn(valium, "Valium"));
        sjekk("testLegemiddelPris() Narkotisk", testLegemiddelPris(valium, 250));
        sjekk("testLegemiddelVirkestoff() Narkotisk", testLegemiddelVirkestoff(valium, 10.5));
        sjekk("testNarkotiskStyrke() Narkotisk", testNarkotiskStyrke(valium, 7));

        // Test på Vanedannende legemiddel:
        sjekk("testLegemiddelId() Vanedannende", testLegemiddelId(nesespray,1));
        sjekk("testLegemiddelNavn() Vanedannende", testLegemiddelNavn(nesespray, "Nesespray"));
        sjekk("testLegemiddelPris() Vanedannende", testLegemiddelPris(nesespray, 150));
        sjekk("testLegemiddelVirkestoff() Vanedannende", testLegemiddelVirkestoff(nesespray, 5.5));
        sjekk("testVanedannendeStyrke() Vanedannende", testVanedannendeStyrke(nesespray, 4));

        // Test Vanlig legemiddel:
        sjekk("testLegemiddelId() Vanlig", testLegemiddelId(paracet,2));
        sjekk("testLegemiddelNavn() Vanlig", testLegemiddelNavn(paracet, "Paracet"));
        sjekk("testLegemiddelPris() Vanlig", testLegemiddelPris(paracet, 50));
        sjekk("testLegemiddelVirkestoff() Vanlig", testLegemiddelVirkestoff(paracet, 10.0));
    }
}