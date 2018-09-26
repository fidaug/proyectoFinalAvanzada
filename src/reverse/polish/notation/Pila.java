package reverse.polish.notation;

/**
 *
 * @author Augusto
 */
public abstract class Pila implements EstructurasDinamicas {

    private Node top;
    private int size;

    public Pila() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return size;
    }

    public void push(String expresion) {
        Node node = new Node(expresion);
        node.setOperacion(expresion);
        if (isEmpty()) {
            top = node;
            top.setNext(null);
        } else {
            node.setNext(top);
            top = node;
        }
        size++;
    }

    public void pop() {
        top = top.getNext();
        size--;
    }

    @Override
    public void print() {
        Node temp = top;
        for (int i = 0; temp != null; i++) {
            System.out.println(temp.getOperacion());
            temp = temp.getNext();
        }
    }

    @Override
    public void add(String expresion) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adddb(String expresion, String resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Node getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }
    
    public void setTop(Node top) {
        this.top = top;
    }    
    
}
