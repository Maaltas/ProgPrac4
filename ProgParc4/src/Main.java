import Keyboard.*;

public class Main {
    public static void main(String[] args) {
        int opcio;
        do {
            System.out.println("Opcions:");
            System.out.println("1.- Inserir jugador");
            System.out.println("2.- Eliminar jugador");
            System.out.println("3.- Visualitzar un dels dos arbres");
            System.out.println("4.- Clonar");
            System.out.println("5.- Acabar");
            opcio = Keyboard.readInt();
            switch (opcio) {
                case 1:
                    int posicio;
                    do {
                        System.out.println("Indica la posició del jugador que vols inserir:");
                        System.out.println("1.- Base");
                        System.out.println("2.- Escolta");
                        System.out.println("3.- Aler");
                        System.out.println("4.- AlaPivot");
                        System.out.println("5.- Pivot");
                        posicio = Keyboard.readInt();
                    } while (posicio < 1 || posicio > 5);
                    int puntuacio;
                    do {
                        System.out.println("Indica la seva puntuació [0, 1000]");
                        puntuacio = Keyboard.readInt();
                    } while (puntuacio < 0 || puntuacio > 1000);
                    // s'hauria de inserir però no sé com :p
                case 2:
                case 3:
                    int ordre;
                    do {
                        System.out.println("Tria en quin ordre vols mostrar:");
                        System.out.println("1.- Actual");
                        System.out.println("2.- Clonat");
                        ordre = Keyboard.readInt();
                    } while (ordre < 1 || ordre > 2);
                    // arbre.mostrar() ???
                case 4:
                    // arbre.clonar() ???
                case 5:
                    System.out.println("Adeu!");
                    break;
            }
        } while (opcio < 1 || opcio > 5);
    }
}