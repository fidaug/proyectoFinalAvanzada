package reverse.polish.notation;

import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Augusto
 */
public class File {
    
    String expresion = "";
    String resultado = "";
    String imprimir;
    
        private static final String FILENAME = "C:\\Users\\Augusto\\Documents\\Avanzada.txt";
    
    public void exportar(String expresion, String resultado){
        this.expresion = expresion;
        this.resultado = resultado;
        imprimir = "Operacion: "+expresion+" "+resultado+"\n";
    





           try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {

            String content = imprimir;

            bw.write(content);

            // no need to close it.
            //bw.close();
            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
