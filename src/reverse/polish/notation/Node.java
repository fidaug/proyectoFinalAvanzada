package reverse.polish.notation;

/**
 * Clse Nodo Esta clase almacenara las operaciones registradas por el usuario
 * para posteriormente ser guardadas en una Estructura Dinamica
 *
 * @author Augusto
 */
public class Node {

    private String operacion;
    private Node next;
    private String resultado;

    /**
     *
     * @param operacion Recibe como parametro los numeros que el usurio ingresa
     * a operar y se
     */
    public Node(String operacion) {
        this.operacion = operacion;
        next = null;
    }

    public Node(String operacion, String resultado) {
        this.operacion = operacion;
        this.resultado = resultado;
        next = null;
    }

    /**
     *
     * @return operacion al ser llamado devuelve el valor que puede tener
     * almacenado la variable operacion
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     *
     * @param operacion parametro que a travez del metodo setter ayuda a
     * modificar el valor de la variable
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    /**
     *
     * @return next retorna el valor que posee la variable next
     */
    public Node getNext() {
        return next;
    }

    /**
     *
     * @param next se envia como parametro un elemento de tipo nodo para
     * modificar el valor de next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
