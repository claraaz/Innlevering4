import java.util.ArrayList;

public class Pasient {
    
    private String navn, foedselsnr;
    public final int id;
    public static int idNr = 0;
    ArrayList<Resept> resepter = new ArrayList<>();

    public Pasient(String n, String fnr){
        navn = n;
        foedselsnr = fnr;
        id = idNr;
        idNr++;
    }

    public void leggTilResept(Resept r){
        resepter.add(r);
    }
}