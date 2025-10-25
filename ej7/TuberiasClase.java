package ej7;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TuberiasClase {
	
	public static void main (String[] args) throws InterruptedException {
		pipePrueba(); 
	}
	
	public static void pipePrueba() throws InterruptedException {
		try {
			File tmp = File.createTempFile("pipe", ".txt"); 
			ProcessBuilder p1 = new ProcessBuilder("bash", "-lc", "echo 'hola mundo'"); 
			p1.redirectOutput(tmp); 
			Process proceso1 = p1.start(); 
			int codigo1 = proceso1.waitFor(); 
			
			ProcessBuilder p2 = new ProcessBuilder("bash", "-lc", "wc -w");
			p2.redirectInput(tmp); 
			Process proceso2 = p2.start(); 
			String salida = new String(proceso2.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
			proceso2.waitFor(); 
			
			System.out.println("Numero de palabras: " + salida); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
