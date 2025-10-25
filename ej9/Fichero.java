package ej9;

import java.io.File;

public class Fichero {
	
	public static void main (String[] args) {
		redirigirErrores(); 
	}
	
	public static void redirigirErrores() {
		ProcessBuilder pb = new ProcessBuilder("cat", "/etc/passwd"); 
		pb.redirectOutput(new File ("salida.txt")); 
		pb.redirectError(new File("error.txt")); 
		
		try {
			Process p = pb.start(); 
			p.waitFor(); 
		} catch (Exception ex) {
			ex.printStackTrace(); 
		}
	}

}
