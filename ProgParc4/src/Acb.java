public interface Acb<E extends Comparable<E>> {
    public E arrel() throws ArbreException;

    //Cal llensar una excepció si es demana l'arrel d'un arbre buit
    public Acb<E> fillEsquerre() throws ArbreException;

    //Si no te fill esquerre retorna un arbre buit
    public Acb<E> fillDret() throws ArbreException;

    //Si no te fill dret retorna un arbre buit
    public boolean abBuit();

    //Ens diu si l'arbre es buit
    public void buidar();

    //Buida l'arbre
    public void inserir(E e) throws ArbreException;

    //Llensa una excepcio si l'element que s'insereix esta repetit
    public void esborrar(E e) throws ArbreException;

    //Llansa una excepcio si l'element no hi es
    public boolean membre(E e);
//True si l'element existeix a l'arbre
}