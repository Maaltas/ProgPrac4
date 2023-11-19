import java.util.Queue;

public class AcbEnll <E extends Comparable<E>> implements Acb<E>, Cloneable{
    private class NodeA{
        Jugador contigut;
        NodeA esq, dreta;
        NodeA() {this(null);}
        NodeA(Jugador jugador) {this(jugador, null, null);}
        NodeA(Jugador jugador, NodeA node, NodeA node1) {
            this.contigut = jugador;
            this.esq = node;
            this.dreta = node1;
        }
    }
    NodeA arrel;
    Queue <E> cua;
    Acb<E> arbre;
    public AcbEnll(){

    }
    public E arrel() throws ArbreException {
        return null;
    }

    @Override
    public Acb<E> fillEsquerre() {
        return null;
    }

    @Override
    public Acb<E> fillDret() {
        return null;
    }

    @Override
    public boolean abBuit() {
        return false;
    }

    @Override
    public void buidar() {

    }

    @Override
    public void inserir(E e) throws ArbreException {

    }

    @Override
    public void esborrar(E e) throws ArbreException {

    }

    @Override
    public boolean membre(E e) {
        return false;
    }
}
