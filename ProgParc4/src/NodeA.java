public class NodeA {
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
