/*
 * Código basado en el de Ricardo moya, 21 dic 2015
 * Estraido de: "https://jarroba.com/patron-singleton-en-java-con-ejemplos/"
 * */
public class SoyUnico 
{
	    public iCalculadora getSingletonInstance(iCalculadora clc) {
	        if (clc == null){
	            clc = new calculadora();
	            return clc;
	        }
	        else{
	            System.out.println("No se puede crear el objeto, este ya existe.");
	        }
	        
	        return null;
	    }
	    
}
