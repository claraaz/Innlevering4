public class TestResept {

    // Jeg har kopiert denne fra testCelle fra Oblig1. 
    public static void sjekk(String hva, boolean test) {
        if (! test) {
            System.out.println("Sjekken '" + hva + "' feilet!");
            System.exit(1);
        }
    }

    public static boolean testReseptPris(Resept resept, int forventetPris) {
        return resept.prisAaBetale() == forventetPris;
    }

    public static boolean testReseptFarge(Resept resept, String forventetFarge) {
        return resept.farge() == forventetFarge;
    }

    public static void main(String[] args) {
        Narkotisk valium = new Narkotisk("Valium", 250, 10.5, 7);
        Vanedannende nesespray = new Vanedannende("Nesespray", 150, 5.5, 4);
        Vanlig paracet = new Vanlig("Paracet", 50, 10.0);

        Lege lege = new Lege("Kari Nordmann");

        HvitResept hvitResept = new HvitResept(nesespray, lege, 1, 1);
        MilResept milResept = new MilResept(nesespray, lege, 2);
        PResept pResept = new PResept(paracet, lege, 3, 3);
        BlaaResept blaaResept = new BlaaResept(valium, lege, 4, 3); 

        // Test HvitResept:
        sjekk("testReseptPris() HvitResept", testReseptPris(hvitResept, 150));
        sjekk("testReseptFarge() HvitResept", testReseptFarge(hvitResept, "Hvit"));

        // Test MilResept:
        sjekk("testReseptPris() MilResept", testReseptPris(milResept, 0));
        sjekk("testReseptFarge() MilResept", testReseptFarge(milResept, "Hvit"));

        // Test PResept:
        sjekk("testReseptPris() PResept", testReseptPris(pResept, 0));
        sjekk("testReseptFarge() PResept", testReseptFarge(pResept, "Hvit"));

        // Test BlaaResept:
        sjekk("testReseptPris() BlaaResept", testReseptPris(blaaResept, 63));
        sjekk("testReseptFarge() BlaaResept", testReseptFarge(blaaResept, "Blaa"));

    }
}