package com.fernandopaniagua.formateo;

public class AppString {

	public static void main(String[] args) {
		String cadena = "El lenguaje de programación";
		
		String lenguajeJava = "Java";
		String versionJava = "1.8";
		int anyoJava = 2014;
		
		String lenguajePython = "Python";
		String versionPython = "3.11";
		int anyoPython = 2022;
		
		String lenguajeC = "C";
		String versionC = "1";
		int anyoC = 1972;
				
		//Cadenas de caracteres
		//1. Opción 'simple'
		String java = cadena + " " + lenguajeJava + " " + versionJava + " " + anyoJava;
		String python = cadena + " " + lenguajePython + " " + versionPython + " " + anyoPython;
		String c = cadena + " " + lenguajeC + " " + versionC + " " + anyoC;
		System.out.println(java);
		System.out.println(python);
		System.out.println(c);
		//printf
		System.out.printf("%s %s, versión %s, es del año %d\n", cadena, lenguajeJava, versionJava, anyoJava);
		System.out.printf("%s %s, versión %s, es del año %d\n", cadena, lenguajePython, versionPython, anyoPython);
		System.out.printf("%s %s, versión %s, es del año %d\n", cadena, lenguajeC, versionC, anyoC);
		//String.format 
		String cadenaJava = String.format("%s %s, versión %s, es del año %d", cadena, lenguajeJava, versionJava, anyoJava);
		String cadenaPython = String.format("%s %s, versión %s, es del año %d", cadena, lenguajePython, versionPython, anyoPython);
		String cadenaC = String.format("%s %s, versión %s, es del año %d", cadena, lenguajeC, versionC, anyoC);
		System.out.println(cadenaJava);
		System.out.println(cadenaPython);
		System.out.println(cadenaC);
		//String.format con un objeto que tiene sobreescrito el método toString	
		Persona kevin = new Persona(180,"Kevin");
		System.out.println(String.format("El nombre del jugador es %s", kevin));
		
		//String.format ajustando los anchos
		String coolCabecera=String.format("%15s %8s %8s", "LENGUAJE", "VERSIÓN", "AÑO");
		String coolJava=String.format("%15s %8s %8d", lenguajeJava, versionJava, anyoJava);
		String coolPython=String.format("%15s %8s %8d", lenguajePython, versionPython, anyoPython);
		String coolC=String.format("%15s %8s %8d", lenguajeC, versionC, anyoC);
		System.out.println(coolCabecera);
		System.out.println("=================================");
		System.out.println(coolJava);
		System.out.println(coolPython);
		System.out.println(coolC);
		
		writeToPrinter(coolCabecera,coolJava,coolPython,coolC);
		
		//Format con argumentos posicionales siendo 1$ variable1 y 2$ variable2
		String variable1 = "Zapato";
		String variable2 = "Mochila";
		String textoConFormato = String.format("%1$s es lo mismo que %1$s y una %2$s no es un %1$s", variable1, variable2);
		System.out.println(textoConFormato);
	}
	
	private static void writeToPrinter(String... lineas) {
		for (String linea : lineas) {
			System.out.println("Escribiendo en la impresora..." + linea);
			
		}
	}
}

class Persona {
	int altura;
	String nombre;
	public Persona(int altura, String nombre) {
		this.altura=altura;
		this.nombre=nombre;
	}
	@Override
	public String toString() {
		return String.format("%s#%d", nombre, altura);
	}
}
