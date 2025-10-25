package ej5;

import java.io.File;
import java.io.IOException;

public class CambiarDirectorio {
	
	public static void main (String[] args) {
		changeDirectory(); 
	}
	
	public static void changeDirectory(){
		ProcessBuilder pb = new ProcessBuilder("pwd"); 
		pb.directory(new File("/tmp"));  
		pb.inheritIO();
		try {		
			Process proceso = pb.start(); 
			proceso.waitFor(); 			
		} catch (IOException | InterruptedException ex) {
			ex.printStackTrace(); 
		}	
	}
}
