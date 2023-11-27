import java.util.LinkedList;
import java.util.Queue;
import java.lang.Cloneable;

public class AcbEnll<E extends Comparable<E>> implements Acb<E>, Cloneable {
    private class NodeA implements Cloneable{
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
        private int contarNodes(NodeA node) {
            if (node == null) {
                return 0;
            } else {
                return 1 + contarNodes(node.esq) + contarNodes(node.dreta);
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
        private NodeA eliminar(NodeA node, E e) {
            if (node == null) {
                return null;
            }
            if (node.contigut.equals(e)) {
                if (node.esq == null && node.dreta == null) {
                    return null;
                }
                else if (node.esq == null) {
                    return node.dreta;
                } else if (node.dreta == null) {
                    return node.esq;
                } else {
                    NodeA ultimNode = buscarUltimNode(arrel);
                    node.contigut = ultimNode.contigut;
                    eliminar(ultimNode, ultimNode.contigut);
                    return node;
                }
            }
            node.esq = eliminar(node.esq, e);
            node.dreta = eliminar(node.dreta, e);
            return node;
        }
        private NodeA buscarUltimNode(NodeA node) {
            if (node == null) {
                return null;
            }
            NodeA ultimNodeEsq = buscarUltimNode(node.esq);
            NodeA ultimNodeDreta = buscarUltimNode(node.dreta);

            if (ultimNodeEsq == null && ultimNodeDreta == null) {
                return node;
            }
            if (ultimNodeEsq != null) {
                return ultimNodeEsq;
            } else {
                return ultimNodeDreta;
            }
        }

        public Object clone () throws CloneNotSupportedException {
            NodeA clon = (NodeA) super.clone();

            if(this.esq != null){
                clon.esq = (NodeA) clon.esq.clone();
            }
            if(this.dreta != null){
                clon.dreta = (NodeA) clon.dreta.clone();
            }
            return clon;
        }

    }
    NodeA arrel;
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
    public boolean abBuit() {return arrel == null;}
    public void buidar() {arrel = null;}
    public void inserir(E e) throws ArbreException {
        if (arrel == null) {
            arrel = new NodeA(e);
        } else {
            arrel.inserirRecursiu(arrel,e);
        }
    }
    public void esborrar(E e) throws ArbreException {System.out.println("S'ha eliminat el: " + arrel.eliminar(arrel,e).contigut.toString());}
    public boolean membre(E e) {return cua.contains(e);}
    public void iniRecorregut(boolean sentit) {
        if (cua!=null)cua.clear();
        inOrdreAscendent = sentit;
        if (arrel != null) inOrdre(arrel);
        else System.out.println("L'arbre es buit");
        while (!cua.isEmpty()){
            System.out.println(cua.poll().toString());
        }
    }
    public boolean finalRecorregut() {
        if (arrel==null) return true;
        return cua.isEmpty();
    }
    public E segRecorregut() throws ArbreException {
        if (finalRecorregut()) {
            throw new ArbreException("No s'ha inicialitzat el recorregut o ja s'ha arribat al final.");
        }
        return cua.poll();
    }
    public int cardinalitat() {
        return arrel.contarNodes(arrel);
    }
    public Object clone(){
        AcbEnll<E> clon = null;
        try{
            clon = (AcbEnll<E>) super.clone();
            clon.cua = new LinkedList<>();
            if(clon.arrel != null){
                clon.arrel = (NodeA) clon.arrel.clone();
            }

        }catch(Exception e){
            System.out.println("EXCEPCIÓ: " + e.getMessage());
        }
        return clon;
    }
    private void inOrdre(NodeA node) {
        if (node==null){
            return;
        } else {
            if (inOrdreAscendent){
                if(node.contigut!=null) cua.add(node.contigut);
                if(node.esq!=null)inOrdre(node.esq);
                if(node.dreta!=null)inOrdre(node.dreta);
            } else {
                if(node.esq!=null) inOrdre(node.esq);
                if (node.dreta!=null) inOrdre(node.dreta);
                if (node.contigut!=null) cua.add(node.contigut);
            }
        }
    }

}
