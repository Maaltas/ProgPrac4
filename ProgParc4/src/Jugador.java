public class Jugador implements Comparable<Jugador>{
    public enum Posicio {  // A l'enunciat indica que és públic crec
        Base,
        Escolta,
        Aler,
        AlaPivot,
        Pivot
    }

    Posicio posicio;
    int puntuacio;

    public Jugador(int posicio, int puntuacio) {
        if (posicio >= 0 && posicio <= 4) {
            this.posicio = Posicio.values()[posicio-1];
        }
        this.puntuacio = puntuacio;
    }

    public int compareTo(Jugador jugador) {
        int comparacionPosicion = Integer.compare(this.posicio.ordinal(), jugador.posicio.ordinal());
        if (comparacionPosicion == 0) {
            return Integer.compare(this.puntuacio, jugador.puntuacio);
        }
        return comparacionPosicion;
    }
    public String toString() {return posicio.toString() + " " + puntuacio;}

}
