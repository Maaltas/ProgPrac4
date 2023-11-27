import java.util.Scanner;

public class Main {
    public static <E extends Comparable<E>> void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcio;
        AcbEnll<E> arbre = new AcbEnll<>();
        AcbEnll<E> clone = new AcbEnll<>();
        Comparable <E> c;
        do {
            System.out.println("Opcions:");
            System.out.println("1.- Inserir jugador");
            System.out.println("2.- Eliminar jugador");
            System.out.println("3.- Visualitzar un dels dos arbres");
            System.out.println("4.- Clonar");
            System.out.println("5.- Acabar");
            System.out.println("Tria una Opcio [1,5]");
            opcio = scanner.nextInt();
            switch (opcio) {
                case 1:
                case 2:
                    int posicio = 0;
                    do {
                        System.out.println("Indica la posició del jugador:");
                        System.out.println("1.- Base");
                        System.out.println("2.- Escolta");
                        System.out.println("3.- Aler");
                        System.out.println("4.- AlaPivot");
                        System.out.println("5.- Pivot");
                        System.out.println("Tria una Opcio [1,5]");
                        posicio = scanner.nextInt();
                    } while (posicio < 1 || posicio > 5);
                    int puntuacio = 0;
                    do {
                        System.out.println("Indica la seva puntuació [0, 1000]");
                        puntuacio = scanner.nextInt();
                    } while (puntuacio < 0 || puntuacio > 1000);
                    if (opcio==1){
                        arbre.inserir((E) new Jugador(posicio, puntuacio));
                    } else {
                        arbre.esborrar((E) new Jugador(posicio, puntuacio));
                    }
                    break;
                case 3:
                    int ordre;
                    do {
                        System.out.println("Tria en quin ordre vols mostrar:");
                        System.out.println("1.- Actual");
                        System.out.println("2.- Clonat");
                        System.out.println("Tria l'ordre [1,2]");
                        ordre = scanner.nextInt();
                    } while (ordre < 1 || ordre > 2);
                    boolean esClonat = (ordre == 2);
                    ordre = 0;
                    do{
                        System.out.println("Indica en quin ordre vols mostrar els jugadors:");
                        System.out.println("1.- Ascendent");
                        System.out.println("2.- Descendent");
                        System.out.println("Tria l'ordre [1,2]");
                        ordre = scanner.nextInt();
                    } while (ordre < 1 || ordre > 2);
                    boolean bol = ordre == 2;
                    if (esClonat) clone.iniRecorregut(bol);
                    else arbre.iniRecorregut(bol);
                    break;
                case 4:
                    clone = (AcbEnll<E>) (arbre).clone();
                    clone.iniRecorregut(true);
                    break;
                case 5:
                    System.out.println("Adeu!");
                    break;
                default:
                    System.out.println("Valor introduit incorrecte introdueix un valor dins del interval");
                    break;
            }
        } while (opcio!=5);
        scanner.close();
    }
}