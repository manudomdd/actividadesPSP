package ej8;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Sleep {
	
	public static void main (String[] args) throws IOException, InterruptedException {
		matarProceso(); 
	} 
	
	public static void matarProceso() throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("sleep", "10"); 
		Process p = pb.start();
		boolean time = p.waitFor(2, TimeUnit.SECONDS); 
		
		if (!time) {
			p.destroy();
			System.out.println("Proceso destruido."); 
		} else {
			System.out.println("Proceso terminado a tiempo."); 
		}		
	}
}
