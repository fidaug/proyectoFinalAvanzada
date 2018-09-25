
import java.util.Scanner;
import java.util.StringTokenizer;
import reverse.polish.notation.List;
import reverse.polish.notation.Node;
import reverse.polish.notation.Pila;
import reverse.polish.notation.Sort;

/**
 * Clase ReversePolishNotatio En esta clase se detalla como Main del proyecto y
 * es onde se solicitan las operaciones en notacion polaca inversa que operara
 *
 * @author Augusto
 */
public class ReversePolishNotation {

    String expresion;
    List db = new List();

    protected String operacionAritmetica() {
        Scanner read = new Scanner(System.in);
        System.out.println("Ingrese la expresion a operar: ");
        expresion = read.nextLine();
        return expresion;
    }

    /**
     *
     * @param expresion Envia la expresión ingresada por el usuario para serar
     * los String por medio de tokenizer
     */
    protected List identificadorValores(String expresion) {
        List temporal = new List();
        String temp = expresion;
        StringTokenizer tokens = new StringTokenizer(temp);
        while (tokens.hasMoreTokens()) {
            temporal.add(tokens.nextToken());
        }
        return temporal;
    }

    protected List validacionExpresion(List temporal) {
        int contadorOperandos = 0;
        int contadorOperadores = 0;
        Node aux = temporal.getHead();
        for (int i = 0; i < temporal.getSize(); i++) {
            if (isNumeric(aux.getOperacion())) {
                contadorOperandos++;
            } else {
                switch (aux.getOperacion()) {
                    case "PLUS":
                        contadorOperadores++;
                        break;
                    case "LESS":
                        contadorOperadores++;
                        break;
                    case "TIMES":
                        contadorOperadores++;
                        break;
                    case "DIV":
                        contadorOperadores++;
                        break;
                    default:
                        System.out.println("El dato ingresado {"
                                + aux.getOperacion() + "} no es un operando u "
                                + "operador valido");
                        System.out.println("Porfavor intentelo de nuevo.");
                        operacionAritmetica();
                        break;
                }
            }
            aux = aux.getNext();
        }
        if (contadorOperandos == 0) {
            System.out.println("La expresion no contiene "
                    + "numeros a operar");
            operacionAritmetica();
        } else if (contadorOperandos < 2) {
            throw new UnsupportedOperationException("La expresion contiene 1 "
                    + "numero a operar de ingresar como minimo 2");
        } else if (contadorOperadores == 0) {
            throw new UnsupportedOperationException("La expresion no contiene "
                    + "operadores esta compuesta unicamente de numeros, para ser "
                    + "valida debe tener al menos 1 operador");
        }
        return temporal;
    }

    protected boolean isNumeric(String value) {
        try {
            double d = Double.parseDouble(value);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    protected Pila calculoRPN(List temporal) {
        Pila rpn = new Pila() {
        };
        double calculo = 0.0;
        double numero = 0.0;
        double respuesta = 0.0;
        String operador = " ";
        String operando = " ";
        Node aux = temporal.getHead();
        for (int i = 0; i < temporal.getSize(); i++) {
            if (isNumeric(aux.getOperacion())) {
                rpn.push(aux.getOperacion());
            } else {
                Node value = rpn.getTop();
                operador = aux.getOperacion();
                for (int j = 0; j < 1; j++) {
                    operando = value.getOperacion();
                    numero = Double.parseDouble(operando);
                    rpn.pop();
                    value = value.getNext();
                    operando = value.getOperacion();
                    calculo = Double.parseDouble(operando);
                    rpn.pop();
                    switch (operador) {
                        case "PLUS":
                            respuesta = calculo + numero;
                            break;
                        case "LESS":
                            respuesta = numero - calculo;
                            break;
                        case "TIMES":
                            respuesta = calculo * numero;
                            break;
                        case "DIV":
                            respuesta = calculo / numero;
                            break;
                    }
                }
                String s = String.valueOf(respuesta);
                rpn.push(s);
            }
            aux = aux.getNext();
        }
        System.out.println("El resultado de la operacion es: "+respuesta);
        return rpn;
    }

    protected List dataBase(List temporal, Pila rpn) {
        String expresion = "";
        String temp = " ";
        String resultado = "";
        Node aux = temporal.getHead();
        for (int i = 0; i < temporal.size(); i++) {
            temp = aux.getOperacion();
            expresion = expresion + " " + temp + " ";
            aux = aux.getNext();
        }
        Node tempHead = rpn.getTop();
        for (int j = 0; tempHead != null; j++) {
            resultado = tempHead.getOperacion();
            tempHead = tempHead.getNext();
        }
        db.adddb(expresion, resultado);
        return db;
    }

    protected void ascendente(List db) {
        Sort az = new Sort();    
        az.sortAsedente(db);
    }
    
     protected void descendete(List db) {
        Sort az = new Sort();    
        az.sortDescendete(db);
    }

    protected void MainMenu() {
        Scanner reader = new Scanner(System.in);
        int op = 0;
        String expresion = "";
        List temporal = null;
        Pila rpn = null;
        do {
            System.out.println(" ***********MENU PRINCIPAL*********** ");
            System.out.println(" ************************************ ");
            System.out.println(" *    Calculadora artimetica RPN    * ");
            System.out.println(" ************************************ ");
            System.out.println(" ");
            System.out.println("Ingrese un numero para elegir la opcion:");
            System.out.println("1. Ingresar una expresion RPN ");
            System.out.println("2. Verificar las expresiones ingresadas"
                    + "en orden ascendete  ");
            System.out.println("3. Verificar las expresiones ingresadas "
                    + "en orden descendete");
            System.out.println("4. Salir");
            op = reader.nextInt();
        } while (op < 0 && op > 5);

        switch (op) {
            case 1:
                expresion = operacionAritmetica();
                temporal = identificadorValores(expresion);
                temporal = validacionExpresion(temporal);
                rpn = calculoRPN(temporal);
                dataBase(temporal, rpn);              
                break;
            case 2:
                ascendente(db);
                break;
            case 3:
                descendete(db);
                break;
        }
        MainMenu();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ReversePolishNotation run = new ReversePolishNotation();
        run.MainMenu();

    }

}
