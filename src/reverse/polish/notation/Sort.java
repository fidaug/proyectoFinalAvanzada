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
            double resultadoActual = Double.parseDouble(aux.getResultado());
            Node auxMatch = aux.getNext();
            Node nodeMax = aux;
            for (int j = i+1; j < size; j++) {
                if (auxMatch == null) {
                    break;
                }
                double resultMatch = Double.parseDouble(auxMatch.getResultado());
                if (resultadoActual > resultMatch) {
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
       String temp = "";
        int n = db.getSize();
        
        Node aux = db.getHead();
        for (int i = 0; i <= n-1; i++) {
            temp = aux.getResultado(); 
            Node siguiente = aux.getNext();
            Node mayor = aux;
            for (int j = 1; j < n ; j++) {
                if (siguiente == null) {
                  break;
                }
                String verificador = siguiente.getResultado();
                if (temp.compareTo(verificador)< 0) {
                    mayor = siguiente;
                }
                 siguiente = siguiente.getNext();           
            }
            Node temp2 = aux;
            aux.setResultado(mayor.getResultado()); 
            mayor.setResultado(temp2.getResultado());
             
            aux = aux.getNext();
        }
             print(db);
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
