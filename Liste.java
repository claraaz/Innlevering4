// implementeres av klassen Lenkeliste
interface Liste<E> {
    int stoerrelse();
    void leggTil(E data);
    E hent();
    E fjern();
}