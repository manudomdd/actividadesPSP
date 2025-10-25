package ej2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Captura {
	
	public static void main (String[] args) {
		procesoCaptura(); 
	} 
	
	public static void procesoCaptura() {
		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "-l"); 
			Process proceso = pb.start(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream())); 
			String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            int codigo = proceso.waitFor(); 
            
            if (codigo == 0) {
            	System.out.println("El comando es correcto."); 
            } else {
            	System.err.print("El comando no es correcto.");
            }
		} catch (Exception ex) {
			System.err.print(ex.getMessage());
		}		
	}
}
