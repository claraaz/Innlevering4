public class Lege implements Comparable<Lege>{

    public String navn;
    public IndeksertListe<Resept> utskrevneResepter;

    // invariant1 --> navn sendes alltid inn som en string som starter med "Dr. " etterfulgt av etternavnet til legen
    // invariant2 --> ingen leger har identisk etternavn
    public Lege(String navn) {
        this.navn = navn;
        utskrevneResepter = new IndeksertListe<>();
    }

    public String hentNavn() {return navn;}

    public IndeksertListe<Resept> hentUtskrevneResepter() {
        return utskrevneResepter;
    }

    // invariant3 --> nye resepter legges alltid til på posisjon 0 (først) i legens utskrevneResepter.
    // invariant4 --> antar at legemiddel av typen Vanlig og Vanedannende kan skrives ut på alle resept, men narkotiske legemiddel kun kan skrives ut på BlaaResept og av en Spesialist

    public HvitResept skrivHvitResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk ) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            HvitResept ny = new HvitResept(legemiddel, this, pasient, reit);
            utskrevneResepter.leggTil(0, ny); // 
            return ny;
        }
    }
    public MilResept skrivMilResept (Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk ) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            MilResept ny = new MilResept(legemiddel, this, pasient);
            utskrevneResepter.leggTil(0, ny);
            return ny;
        }
    }
    public PResept skrivPResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk ) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            PResept ny = new PResept(legemiddel, this, pasient, reit);
            utskrevneResepter.leggTil(0, ny);
            return ny;
        }
    }

    public BlaaResept skrivBlaaResept (Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
        if (legemiddel instanceof Narkotisk ) {
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            BlaaResept ny = new BlaaResept(legemiddel, this, pasient, reit);
            utskrevneResepter.leggTil(0,ny);
            return ny;
        }
    }

    // Overrider toString() for å skrive ut info.
    @Override
    public String toString() {
        return navn;
    }

    // returnerer et heltall, positivt heltall --> this først, negativt heltall --> parameter-lege først, 0 --> samme lege
    @Override
    public int compareTo(Lege lege) {
        return this.hentNavn().compareTo(lege.hentNavn());
    }
}