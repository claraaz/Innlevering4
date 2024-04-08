// Hovedprogrammet lager ett objekt av hver klasse og skriver ut toString() til alle objektene. 
public class Hovedprogram {

    public static void main(String[] args) {
        Narkotisk valium = new Narkotisk("Valium", 250, 10.5, 7);
        Vanedannende nesespray = new Vanedannende("Nesespray", 150, 5.5, 4);
        Vanlig paracet = new Vanlig("Paracet", 50, 10.0);

        Lege lege = new Lege("Kari Nordmann");
        Spesialist spesialist = new Spesialist("Ola Jenssen", "1212");

        HvitResept hvitResept = new HvitResept(nesespray, lege, 1, 1);
        MilResept milResept = new MilResept(nesespray, spesialist, 2);
        PResept pResept = new PResept(paracet, lege, 3, 3);
        BlaaResept blaaResept = new BlaaResept(valium, spesialist, 4, 3);  

        System.out.println(); 
        System.out.println(valium);
        System.out.println();  
        System.out.println(nesespray);
        System.out.println(); 
        System.out.println(paracet);  
        
        System.out.println(); 
        System.out.println(lege);
        System.out.println(); 
        System.out.println(spesialist);

        System.out.println();
        System.out.println("Test HvitResept:"); 
        System.out.println(hvitResept); 
        System.out.println(); 
        System.out.println("Test MilResept:");
        System.out.println(milResept);
        System.out.println(); 
        System.out.println("Test PResept:");
        System.out.println(pResept);
        System.out.println(); 
        System.out.println("Test BlaaResept:");
        System.out.println(blaaResept);     
    }
}