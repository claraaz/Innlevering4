import java.util.Iterator;

// implementeres av klassen Lenkeliste
interface Liste<E> extends Iterable<E> {
    int stoerrelse();
    void leggTil(E data);
    E hent();
    E fjern();

    public Iterator<E> iterator();

 
}