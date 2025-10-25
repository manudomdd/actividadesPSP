package ej12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;

public class Ips {
	
	public static void main (String[] args) {
		mostrarIps(); 
	}
	
	public static void mostrarIps() {
	    try {
	    	System.out.println("🛰️ Consultando IP Pública..."); 
	        Instant inicio1 = Instant.now();
	        ProcessBuilder pb1 = new ProcessBuilder("bash", "-c", "curl https://api.ipify.org?format=json");
	        Process p1 = pb1.start();
	        BufferedReader reader1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
	        String line1;
	        while ((line1 = reader1.readLine()) != null) {
	            System.out.println("🌐 Respuesta API: " + line1);
	        }
	        int codSalida1 = p1.waitFor();
	        long pid1 = p1.pid(); 
	        Duration duracion1 = Duration.between(inicio1, Instant.now());
	        System.out.println("PID del proceso: " + pid1); 
	        System.out.println("Tiempo de duracion (IP pública): " + duracion1.toMillis() + " ms.");
	        System.out.println("Codigo de salida: " + codSalida1); 
	        System.out.println("✅ Proceso finalizado correctamente."); 
	        System.out.println(); 
	        	
	    	System.out.println("🛰️ Consultando IP Privada..."); 
	        Instant inicio2 = Instant.now();
	        ProcessBuilder pb2 = new ProcessBuilder("bash", "-c", "hostname -I");
	        Process p2 = pb2.start();
	        BufferedReader reader2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
	        String line2;
	        while ((line2 = reader2.readLine()) != null) {
	            System.out.println("🌐 IP Local: " + line2);
	        }
	        int codSalida2 = p2.waitFor();
	        long pid2 = p2.pid(); 
	        Duration duracion2 = Duration.between(inicio2, Instant.now());
	        System.out.println("PID del proceso: " + pid2); 
	        System.out.println("Tiempo de duración (IP privada): " + duracion2.toMillis() + " ms.");
	        System.out.println("Codigo de salida: " + codSalida2); 
	        System.out.println("✅ Proceso finalizado correctamente."); 
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
 }
