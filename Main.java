package desafio06;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		Calculadora calculadora = new Calculadora();	
		
		double operando_a = solicitarOperando("Ingrese un número a: ", teclado);
		
		double operando_b = solicitarOperando("Ingrese un número b: ", teclado);
		
		String operacion = solicitarOperacion(teclado);		
		
		imprimirResultado (operando_a, operando_b, operacion, calculadora);
		
		teclado.close();
		
	}
	
	public static double solicitarOperando(String mensaje, Scanner teclado) {
	
		boolean numeroValido=false;
		double operando=0;
		
		while (!numeroValido) {
			
		    System.out.println(mensaje);
		    
		    if (teclado.hasNextDouble()) {
		        operando = teclado.nextDouble();
		        numeroValido = true;
		    } else {
		        System.out.println("Error: Ingrese un número válido.");
		        teclado.next();
		    }
		    
		}
		
		teclado.nextLine();
		return operando;
	}
	
	public static String solicitarOperacion(Scanner teclado) {

		String operacion="";		
		
		while (!operacionValida(operacion)) {			
			System.out.println("Ingrese la operación que desea realizar [+, -, *, /, %]: ");
			operacion = teclado.nextLine();			
		}
		
		teclado.close();
		return operacion;
	}
	
	public static boolean operacionValida(String operacion) {
		
	    return operacion.length() == 1 && operacion.matches("[+\\-*/%]");
	    
	}
	
	public static void imprimirResultado(double operando_a, double operando_b, String operacion, Calculadora calculadora) {
		
		double resultado=0;
		
		switch (operacion) {
	        case "+":
	            resultado = calculadora.sumar(operando_a, operando_b);
	            System.out.format("%.2f + %.2f = %.2f%n", operando_a, operando_b, resultado);
	            break;
	        case "-":
	            resultado = calculadora.restar(operando_a, operando_b);
	            System.out.format("%.2f - %.2f = %.2f%n", operando_a, operando_b, resultado);
	            break;
	        case "*":
	            resultado = calculadora.multiplicar(operando_a, operando_b);
	            System.out.format("%.2f * %.2f = %.2f%n", operando_a, operando_b, resultado);
	            break;
	        case "/":
	            try {
	                resultado = calculadora.dividir(operando_a, operando_b);
	                System.out.format("%.2f / %.2f = %.2f%n", operando_a, operando_b, resultado);
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	            break;
	        case "%":
	        	try {
	        		resultado = calculadora.calcularResto(operando_a, operando_b);
	        		System.out.format("%.2f %% %.2f = %.2f%n", operando_a, operando_b, resultado);
	        	} catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            }
	            break;
		}	
		
	}
	
	
}
