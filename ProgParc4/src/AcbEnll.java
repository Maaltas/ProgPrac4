import java.util.LinkedList;
import java.util.Queue;

public class AcbEnll<E extends Comparable<E>> implements Acb<E>, Cloneable {
    private class NodeA {
        E contigut;
        NodeA esq, dreta;

        NodeA(E jugador) {
            this(jugador, null, null);
        }

        NodeA(E jugador, NodeA esq, NodeA dreta) {
            this.contigut = jugador;
            this.esq = esq;
            this.dreta = dreta;
        }
    }


    private NodeA arrel;
    private Queue<E> cua;
    private boolean inOrdreAscendent;

    public AcbEnll() {
        arrel = null;
        cua = new LinkedList<>();
        inOrdreAscendent = true;
    }


    public E arrel() throws ArbreException {
        if (arrel != null) {
            return arrel.contigut;
        }
        throw new ArbreException("L'arbre es buit");
    }

    public Acb<E> fillEsquerre() throws ArbreException {
        if (arrel != null) {
            AcbEnll<E> subarbre = new AcbEnll<>();
            subarbre.arrel = arrel.esq;
            return subarbre;
        }
        throw new ArbreException("L'arbre es buit");
    }

    public Acb<E> fillDret() throws ArbreException {
        if (arrel != null) {
            AcbEnll<E> subarbre = new AcbEnll<>();
            subarbre.arrel = arrel.dreta;
            return subarbre;
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
            arrel = new NodeA(e);
        } else {
            inserirRecursiu(arrel, e);
        }
    }

    private void inserirRecursiu(NodeA node, E e) {
        if (node.contigut.compareTo(e) < 0) {
            if (node.esq == null) {
                node.esq = new NodeA(e);
            } else {
                inserirRecursiu(node.esq, e);
            }
        } else {
            if (node.dreta == null) {
                node.dreta = new NodeA(e);
            } else {
                inserirRecursiu(node.dreta, e);
            }
        }
    }

    public void esborrar(E e) throws ArbreException {
        arrel = esborrarRecursiu(arrel, e);
    }

    private NodeA esborrarRecursiu(NodeA node, E e) {
        if (node == null) {
            System.out.println("L'element no hi es");
        }

        assert node != null;
        int comparacio = node.contigut.compareTo(e);
        if (comparacio < 0) {
            node.esq = esborrarRecursiu(node.esq, e);
        } else if (comparacio > 0) {
            node.dreta = esborrarRecursiu(node.dreta, e);
        } else {
            if (node.esq == null) {
                return node.dreta;
            } else if (node.dreta == null) {
                return node.esq;
            }

            node.contigut = trobarMinim(node.dreta);
            node.dreta = esborrarRecursiu(node.dreta, node.contigut);
        }
        return node;
    }

    private E trobarMinim(NodeA node) {
        while (node.esq != null) {
            node = node.esq;
        }
        return node.contigut;
    }


    public boolean membre(E e) {
        return cua.contains(e);
    }

    public void iniRecorregut(boolean sentit) throws ArbreException {
        cua.clear();
        inOrdreAscendent = sentit;
        if (arrel != null) {
            inOrdre(arrel);
        } else {
            throw new ArbreException("L'arbre es buit, no es pot iniciar el recorregut.");
        }
    }


    private void inOrdre(NodeA node) {
        if (node != null) {
            if (inOrdreAscendent) {
                inOrdre(node.esq);
                cua.offer(node.contigut);
                inOrdre(node.dreta);
            } else {
                inOrdre(node.dreta);
                cua.offer(node.contigut);
                inOrdre(node.esq);
            }
        }
    }


    public boolean finalRecorregut() {
        return cua.isEmpty();
    }

    public E segRecorregut() throws ArbreException {
        if (cua.isEmpty()) {
            throw new ArbreException("No s'ha inicialitzat el recorregut o ja s'ha arribat al final.");
        }
        return cua.poll();
    }
}

/*
offer(E e): Agrega un elemento al final de la cola.
poll(): Recupera y elimina el elemento al principio de la cola.
peek(): Recupera el elemento al principio de la cola sin eliminarlo.
isEmpty(): Verifica si la cola está vacía.
 */
