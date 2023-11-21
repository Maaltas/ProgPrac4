import java.util.Queue;

public class AcbEnll<E extends Comparable<E>> implements Acb<E>, Cloneable {
    private class NodeA {
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
    Queue<E> cua;
    Acb<E> arbre;

    public AcbEnll() {}

    public E arrel() throws ArbreException {
        return null;
    }

    public Acb<E> fillEsquerre() throws ArbreException {
        if (arrel != null) {
            Acb v = new AcbEnll();
            ((AcbEnll) v).arrel = arrel.esq;
            return v;
        }
        throw new ArbreException("L'arbre es buit");
    }

    public Acb<E> fillDret() throws ArbreException {
        if (arrel != null) {
            Acb v = new AcbEnll();
            ((AcbEnll) v).arrel = arrel.dreta;
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
        if (arrel == null) {
            arrel = new NodeA((Jugador) e);
        } else {
            NodeA node = arrel;
            while (node != null) {
                if (node.contigut.compareTo((Jugador) e) < 0) {
                    if (node.esq == null) {
                        node.esq = new NodeA((Jugador) e);
                        return;
                    }
                    node = node.esq;
                } else {
                    if (node.dreta == null) {
                        node.dreta = new NodeA((Jugador) e);
                        return;
                    }
                    node = node.dreta;
                }
            }
        }
    }

    public void esborrar(E e) throws ArbreException {
        if (arrel == null) {
            throw new ArbreException("L'arbre es buit");
        } else {
            NodeA node = arrel;
            while (node != null) {
                if (node.contigut.compareTo((Jugador) e) < 0) {
                    if (node.esq == null) {
                        throw new ArbreException("L'element no hi es");
                    }
                    node = node.esq;
                } else {
                    if (node.dreta == null) {
                        throw new ArbreException("L'element no hi es");
                    }
                    node = node.dreta;
                }
            }
        }
    }

    public boolean membre(E e) {return cua.contains(e);}


    public void iniRecurregut(boolean sentit) {
        // TOT AIXÒ HO HA FET EL COPILOT, NO SÉ QUINA INTENCIÓ TENIA PERO SEGUR Q BONA
        if (sentit) {
            cua = new Queue<E>() {
                @Override
                public boolean add(E e) {
                    return false;
                }

                @Override
                public boolean offer(E e) {
                    return false;
                }

                @Override
                public E remove() {
                    return null;
                }

                @Override
                public E poll() {
                    return null;
                }

                @Override
                public E element() {
                    return null;
                }

                @Override
                public E peek() {
                    return null;
                }

                @Override
                public int size() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    return false;
                }

                @Override
                public Iterator<E> iterator() {
                    return null;
                }

                @Override
                public Object[] toArray() {
                    return new Object[0];
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    return null;
                }

                @Override
                public boolean remove(Object o) {
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends E> c) {
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    return false;
                }

                @Override
                public boolean retainAll
                        (Collection<?> c) {
                    return false;
                }
            }
        }
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
