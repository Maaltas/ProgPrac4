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
    Comparable<E> c;
    NodeA arrel;
    Queue <E> cua;
    Acb<E> arbre;
    public AcbEnll(){}
    public E arrel() throws ArbreException {
        return null;
    }

    public Acb<E> fillEsquerre() throws ArbreException {
        if (arrel != null){
            Acb v = new AcbEnll();
            ((AcbEnll)v).arrel = arrel.esq;
            return v;
        }
        throw new ArbreException("L'arbre es buit");
    }

    public Acb<E> fillDret() throws ArbreException {
        if (arrel != null){
            Acb v = new AcbEnll();
            ((AcbEnll)v).arrel = arrel.dreta;
            return v;
        }
        throw new ArbreException("L'arbre es buit");
    }

    public boolean abBuit() {
        return arrel == null;
    }

    public void buidar() {
        arrel = null;
    }

    public void inserir(E e) throws ArbreException {

    }

    public void esborrar(E e) throws ArbreException {

    }

    public boolean membre(E e) {return cua.contains(e);}


    public void iniRecurregut(boolean sentit) {

    }

    public boolean finalRecurregut() {
        return false;
    }

    public E segRecurregut() throws ArbreException {
        return null;
    }
}
/*
offer(E e): Agrega un elemento al final de la cola.
poll(): Recupera y elimina el elemento al principio de la cola.
peek(): Recupera el elemento al principio de la cola sin eliminarlo.
isEmpty(): Verifica si la cola está vacía.
 */
