package reverse.polish.notation;

/**
 *
 * @author Augusto Esta clase crea una estructura dinamica de tipo lista a
 * travez de la implementacion de la firma metodos creados en la interface
 * EstructuasDinamicas
 */
public class List implements EstructurasDinamicas {

    private Node head;
    private Node tail;
    private int size;

    public List() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     *
     * @return head 
     * indica si la cabeza de lista esta vacía
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     *
     * @return Size 
     * Retorna por medio de la variable size el tamaño actual delista
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @param expresion Atravez del parametro expresion se reciben los valores
     * String separados y se almacenanran en un Nodo
     */
    @Override
    public void add(String expresion) {
        Node node = new Node(expresion);
        node.setOperacion(expresion);
        if (isEmpty()) {
            tail = node;
            tail.setNext(null);
            head = tail;
        } else {
            Node temp = head;
            for (int i = 0; i < (size - 1); i++) {
                temp = temp.getNext();
            }
            temp.setNext(node);
            tail = temp.getNext();
            node.setNext(null);
        }
        size++;
    }
    
    @Override
    public void adddb(String expresion, String resultado) {
        Node node = new Node(expresion,resultado);
        node.setOperacion(expresion);
        node.setResultado(resultado);
        if (isEmpty()) {
            tail = node;
            tail.setNext(null);
            head = tail;
        } else {
            Node temp = head;
            for (int i = 0; i < (size - 1); i++) {
                temp = temp.getNext();
            }
            temp.setNext(node);
            tail = temp.getNext();
            node.setNext(null);
        }
        size++;
    }

    /**
     * Imprime los valores que la lista contiene
     */
    @Override
    public void print() {
        Node temp = head;
        for (int i = 0; temp != null; i++) {
            System.out.print(temp.getOperacion());
            temp = temp.getNext();
        }
        System.out.println("");
    }

    /**
     *
     * @return head
     * al ser llamado mostrara el valor que contenga la cabeza de la lista
     */
    public Node getHead() {
        return head;
    }
    
    /**
     *
     * @return head
     * al ser llamado mostrara el valor que contenga la cola de la lista
     */
    public Node getTail() {
        return tail;
    }
    
    /**
     *
     * @return head
     * al ser llamado mostrara el tamaño que tenga la lista
     */
    public int getSize() {
        return size;
    }

}
