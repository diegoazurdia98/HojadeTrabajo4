

public class calculadora implements iCalculadora {

	//Suma 
	@Override
	public double sumar(double a, double b) {
		return (a + b);
	}

	//Resta
	@Override
	public double restar(double a, double b) {
		return (b - a);
	}

	//Division
	@Override
	public double dividir(double a, double b) {
		return (a/b);
	}

	//Multiplicacion 
	@Override
	public double multiplicar(double a, double b) {
		return (a*b);
	}

}