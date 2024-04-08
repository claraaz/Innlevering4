class Testprogram {
    public static void main(String[] args) {
        IndeksertListe<String> liste = new IndeksertListe<>();

        liste.leggTil("A");
        liste.leggTil("B");
        liste.leggTil("C");
        liste.fjern();
        liste.sett(1,"D");

        System.out.println(liste);
    }
}