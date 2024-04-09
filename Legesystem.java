import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Legesystem {

    public static void main(String[] args) {
        IndeksertListe<Pasient> pasienter = new IndeksertListe<>();
        IndeksertListe<Legemiddel> legemidler = new IndeksertListe<>();
        Prioritetskoe<Lege> leger = new Prioritetskoe<>();
        IndeksertListe<Resept> resepter = new IndeksertListe<>();

        try {
            lesFraFil("fildata.txt", pasienter, legemidler, leger, resepter);
        }
        catch (FileNotFoundException e){
            System.out.println("Fant ikke filen.");
        }


    }

    // invariant1 --> filnavn sendes inn på formatet "filnavn.txt"
    // invariant2 --> teller == 1: pasienter, teller == 2: legemidler, teller == 3: leger, teller == 4: resepter

    public static void lesFraFil(String filnavn, IndeksertListe<Pasient> pasienter, IndeksertListe<Legemiddel> legemidler, Prioritetskoe<Lege> leger,IndeksertListe<Resept> resepter) throws FileNotFoundException {

        Scanner fil = new Scanner(new File(filnavn));
        int teller = 0;

        while (fil.hasNextLine()) {
            String linje = fil.nextLine();
            if (linje.charAt(0) == '#') {
                teller++;
            } else {
                String[] biter = linje.split(",");

                // --- Pasienter --- 
                // har navn (string) og fødselsnummer (int)
                if (teller == 1) {
                    Pasient ny = new Pasient(biter[0], biter[1]);
                    pasienter.leggTil(ny.hentId(),ny);
                }

                // --- Legemidler ---
                // har navn, type, pris(int), virkestoff(int), [styrke](int)
                else if (teller == 2){
                    String navn = biter[0];
                    String type = biter[1];
                    int pris = Integer.parseInt(biter[2]);
                    double virkestoff = Double.parseDouble(biter[3]);

                    if (type.equals("narkotisk")) {
                        int styrke = Integer.parseInt(biter[4]);
                        Narkotisk ny = new Narkotisk(navn, pris, virkestoff, styrke);
                        legemidler.leggTil(ny.hentId(),ny);
                    }
                    if (type.equals("vanedannende")) {
                        int styrke = Integer.parseInt(biter[4]);
                        Vanedannende ny = new Vanedannende(navn, pris, virkestoff, styrke);
                        legemidler.leggTil(ny.hentId(),ny);
                    }

                    // invariant3 --> er legemiddelet ikke narkotisk eller vanedannende, er legemiddelet vanlig
                    else {
                        Vanlig ny = new Vanlig(navn, pris, virkestoff);
                        legemidler.leggTil(ny.hentId(),ny);
                    }
                }


                // --- Leger ---
                // har navn (String) og kontrollID (0 om vanlig lege)
                else if (teller == 3) {
                    if (biter[1].equals("0")) {
                        Lege ny = new Lege(biter[0]);
                        leger.leggTil(ny);
                    } 
                    else {
                        Spesialist ny = new Spesialist(biter[0], biter[1]);
                        leger.leggTil(ny);
                    }
                }

                // --- Resepter ---
                // har legemiddelNummer, legenavn, pasientID, type, [reit](int)
                // (Legemiddel legemiddel, Lege lege, Pasient pasient, [int reit])
                else if (teller == 4) {
                    Legemiddel legemiddel = legemidler.hent(Integer.parseInt(biter[0]));
                }


            }

        }

        fil.close();
    }
}
