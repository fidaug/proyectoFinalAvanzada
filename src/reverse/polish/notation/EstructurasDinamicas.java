
package reverse.polish.notation;

/**
 *Interface EstructurasDinamicas
 * Esta interfaz implementa comportamiento genral que se utilizara en las 2 
 * estructuras dinamicas a utilizar.
 * 
 * @author Augusto
 * 
 */
public interface EstructurasDinamicas {
    /**
     * @return boolean
     * Si la lista no tiene datos retornara true, de lo contrario sera false
     */
    boolean isEmpty();
    /**
     * @return int 
     * Retorna el valor total que posee la estructura dinamica
     */
    int size ();
    /**
    * @param expresion
    * Recibe como parametro una expresion de tipo string la cual se debe 
    * convertir a una estructura dinamica a trabajar
    */   
    void add (String expresion);                                           
    
    void adddb(String expresion, String resultado);
    /**
     * 
     * Funcion que se encargara de imprimir el contenido de las estructuras
     */
    void  print();
}
