package ej3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CapturaErrores {
	
	public static void main (String[] args) {
		capturaError(); 
	} 
	
	public static void capturaError() {
		try {
			ProcessBuilder pb = new ProcessBuilder("ls", "/ruta/que/no/existe"); 
			Process proceso = pb.start(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getErrorStream())); 
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
