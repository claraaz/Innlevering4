// I en stabel skal det nye objekt alltid legges til først, 
// og objektet som ble lagt til sist (først i listen), fjernes først.
class Stabel<E> extends Lenkeliste<E> {

    // har endret fra "E x" til " E data" da jeg synes det gir mer forståelig kode.
    // Legger til fremst i listen.
    @Override
    public void leggTil(E data) {
        Node ny = new Node(data);

        // Listen er tom:
        if (stoerrelse() == 0) {
            foerste = siste = ny;
            stoerrelse++;
            return;
        }

        Node peker = foerste;

        // Går gjennom listen og hvis den finner et element med samme data går den ut av metoden:
        while (peker != null) {
            if (peker.data.equals(data)) {
                return;
            }
            peker = peker.neste;
        }

        // Listen har ett eller flere element:
        if (stoerrelse() > 0) {
            foerste.forrige = ny;
            ny.neste = foerste;
            foerste = ny;
            stoerrelse++;
        }
    }
}