public class Jugador {
    private enum Posicio{
        Base,
        Escolta,
        Aler,
        AlaPivot,
        Pivot
    }
    Posicio posicio;
    int puntuacio;
    public Jugador (int posicio, int puntuacio){
        if (posicio>=0 && posicio<=4){
            this.posicio = Posicio.values()[posicio];
        }
        this.puntuacio = puntuacio;
    }
    public int compareTO (Jugador jugador){
        int comparacio = this.posicio.compareTo(jugador.posicio);
        if (comparacio==0){
            return Integer.compare(this.puntuacio,jugador.puntuacio);
        }
        return comparacio;
    }

    public int getPosicio() {return posicio.ordinal();}
    public int getPuntuacio() {return puntuacio;}
    public String toString(){return posicio.toString() + " " + puntuacio;}

}
