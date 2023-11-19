public interface Acb <E extends Comparable<E>>{
    public E arrel() throws ArbreException;
    public Acb <E> fillEsquerre() throws ArbreException;
    public Acb <E> fillDret() throws ArbreException;
    public boolean abBuit();
    public void buidar();
    public void inserir(E e) throws ArbreException;
    public void esborrar(E e) throws ArbreException;
    public boolean membre(E e);
    public void iniRecurregut(boolean sentit);
    public boolean finalRecurregut();
    public E segRecurregut() throws ArbreException;
}
