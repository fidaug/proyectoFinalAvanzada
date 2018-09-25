package reverse.polish.notation;

/**
 *
 * @author Augusto
 */
public class test {

    public static void main(String[] args) {
        List newList = new List() {}; 
        Sort az = new Sort();
        
        newList.adddb("2 2 PLUS", "4");
        newList.adddb("2 2 DIV", "2");


        
        az.sortAsedente(newList);
        

    }

}
