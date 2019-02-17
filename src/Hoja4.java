
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.regex.*;


//Declaracion de la clase. 
public class Hoja4 {

    /**
     * M√©todo
     * @param charachters
     * @return
     */
	//Revisa si son validos los valores que contiene el archivo .txt, que sean numeros y no letras asi como los simbolos.
    public static boolean isValid(String[] charachters) {
        int amountOfInt = 0;
        int amountOfSymbols = 0;
        if (charachters[0].matches("[0-9]") && charachters[1].matches("[0-9]")) {
            for (String oneLetter : charachters)
                if (oneLetter.matches("[0-9]")) {
                    amountOfInt ++;
                } else if(oneLetter.matches("[+/*-]")) {
                amountOfSymbols ++;
                }
                else {
                    return false;
                }
            if (amountOfInt - 1 == amountOfSymbols){
                return true;
            }
        }
        return false;
    }

    //Si es numero revisa que este en el rango de 1-9
    public static boolean isNumber(String charachter){
        if (charachter.matches("[1-9]")){
            return true;
        }
        //Revisa que el simbolo coincida al de suma, resta, multiplicacion y division.
        else if (charachter.matches("[+/*-]")){
            return false;
        }
        return false;
    }
    
    //Lee el documento. 
    public static String[] extractText(String fileName){
        StringBuilder contentBuilder = new StringBuilder();
        try{
            Stream<String> lines = Files.lines(
                    Paths.get(fileName),
                    StandardCharsets.UTF_8);
            lines.forEach(s ->contentBuilder.append(s));
        }catch (IOException exception){
            System.out.println("Error");
        }
        String calculation = contentBuilder.toString();
        String[] onlySymbols = calculation.split(" ");
        return onlySymbols;
    }

    public static void main (String[] args){
    	Scanner t = new Scanner(System.in);
    	
    	//Inicia el Factory y otros elementos.
    	Factory factory = new Factory();
    	SoyUnico singleton = new SoyUnico();
       iCalculadora myCalculator = null;
       myCalculator = singleton.getSingletonInstance(myCalculator);
       boolean wantsToContinue = true;
       int op;
       iPila myStack = null;
        
       System.out.println("øQue tipo de pila desea utilizar?'\n1. ArrayList\n2. Vector\n3. Lista");
       op = t.nextInt();
       //utiliza el factory para implementar iPila
       if(op == 1 || op == 2 || op == 3) 
       {
       myStack = factory.getImplementStack(op);
       }
       /*
       else if(op == 3) 
       {
    	   System.out.println("øQue tipo de lista desea utilizar?\n 1. Simplemente encadenadas \n2. Doblemente encadenadas \n3. Lista circular");
           op = t.nextInt();
           if(op == 1 || op == 2 || op == 3) 
           {
        	   myStack = factory.getImplementStack(op);
           }
       }
       */
       else 
    	   System.out.println("Su opciÛn no es v·lida.");
        

        while (wantsToContinue && myStack != null){
        	//Se muestran las opciones. 
            System.out.println("Ingrese 1 para ingresar un archivo o 2 para salir");
            
            String answerContinue = t.nextLine();
            
            if (answerContinue.equals("1")){
                
                //Se pide el archivo. 
                System.out.println("Ingrese el nombre del archivo con la operacion que desea realizar:");
                System.out.println("No olvide colocar .txt al final del nombre del archivo");
                String mapPath = t.nextLine();
                String[] text = extractText(mapPath);

                if (isValid(text)){
                    for (String oneCharacter: text){
                        if (isNumber(oneCharacter)) {
                            myStack.push(oneCharacter);
                        }else {
                            if (myStack.size() > 1 ) {
                            	//Cuando se suma.
                                switch (oneCharacter) {
                                    case "+":
                                        double resultSum = myCalculator.sumar(Double.parseDouble((String) myStack.pop()), Double.parseDouble((String) myStack.pop()));
                                        myStack.push(String.valueOf(resultSum));
                                        break;
                                      //Cuando se resta.
                                    case "-":
                                        double resultMinus = myCalculator.restar(Double.parseDouble((String) myStack.pop()), Double.parseDouble((String) myStack.pop()));
                                        myStack.push(String.valueOf(resultMinus));
                                        break;
                                      //Cuando se multiplica.
                                    case "*":
                                        double resultMultiplication = myCalculator.multiplicar(Double.parseDouble((String) myStack.pop()), Double.parseDouble((String) myStack.pop()));
                                        myStack.push(String.valueOf(resultMultiplication));
                                        break;
                                      //Cuando se divide.
                                    case "/":
                                        double resultDivision = myCalculator.dividir(Double.parseDouble((String) myStack.pop()), Double.parseDouble((String) myStack.pop()));
                                        myStack.push(String.valueOf(resultDivision));
                                        break;
                                }
                                //En caso que el archivo no se pueda procesar o no tenga datos suficientes. 
                            }else {
                            	System.out.println("El archivo que subi√≥ no se puede procesar completamente");
                                System.out.println("No hay suficientes n√∫meros para seguir calculando");
                            }
                        }
                    }
                    //Muestra el resultado final.
                    System.out.println("Resultado final");
                    System.out.println(myStack.pop());
                    while (!myStack.empty()){
                        myStack.pop();
                    }
                }
                //Al ingresar un archivo no valido.
                else {
                    System.out.println("Se ingreso un archivo no valido .");
                }
                //Salir.
            }else if (answerContinue.equals("2")){
                wantsToContinue = false;
                //Cuando se ingresa una opcion no valida 
            }else{
                System.out.println("Ingreso no v√°lido, favor intentar nuevamente");
            }
        }

    }
}
