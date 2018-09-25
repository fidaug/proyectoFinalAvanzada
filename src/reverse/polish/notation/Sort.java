package reverse.polish.notation;

/**
 *
 * @author Augusto
 */
public class Sort {

    public void sortAsedente(List db) {
        int size = db.getSize();

        Node aux = db.getHead();
        for (int i = 0; i < size; i++) {
            String resultadoActual = aux.getResultado();
            Node auxMatch = aux.getNext();
            Node nodeMax = aux;
            for (int j = 0; j < size; j++) {
                if (auxMatch == null) {
                    break;
                }
                String resultMatch = auxMatch.getResultado();
                System.out.println(auxMatch.getResultado());
                if (resultadoActual.compareTo(resultMatch) > 0) {
                    nodeMax = auxMatch;
                }
                auxMatch = auxMatch.getNext();
            }
            Node temp = aux;
            temp.setResultado(aux.getResultado());
            aux.setResultado(nodeMax.getResultado());
            nodeMax.setResultado(temp.getResultado());

            aux = aux.getNext();
        }

        print(db);
    }

    public void sortDescendete(List db) {
        int size = db.getSize();
                 String resultadoActual = aux.getResultado();

        Node aux = db.getHead();
        for (int i = 0; i < size; i++) {
            
        }

    }

    public void print(List db) {
        Node temp = db.getHead();
        System.out.println("");
        for (int i = 0; temp != null; i++) {
            System.out.println(temp.getOperacion() + " " + temp.getResultado());
            temp = temp.getNext();
        }
        System.out.println("");
        System.out.println("");
    }
}
