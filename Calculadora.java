package desafio06;

public class Calculadora {
	
	public double sumar(double operando_a, double operando_b) {
		return operando_a + operando_b;
	}
	
	public double restar(double operando_a, double operando_b) {
		return operando_a - operando_b;
	}
	
	public double multiplicar(double operando_a, double operando_b) {
		return operando_a * operando_b;
	}
	
	public double dividir(double operando_a, double operando_b) {
		if (operando_b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser 0.");
        }
        return operando_a / operando_b;
	}
	
	public double calcularResto(double operando_a, double operando_b) {
		if (operando_b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser 0. No se puede calcular el resto de la división.");
        }
        return operando_a % operando_b;	}

}
