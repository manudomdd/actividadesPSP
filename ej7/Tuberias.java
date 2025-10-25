package ej7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Tuberias {
	
	public static void main (String[] args) throws IOException, InterruptedException {
		pipePrueba(); 
	}
	
	public static 
	void pipePrueba() throws IOException, InterruptedException {
		Process p1 = new ProcessBuilder("bash", "-lc", "echo 'hola mundo'").start();
		Process p2 = new ProcessBuilder("bash", "-lc", "wc -w").start(); 
		
		try (InputStream in = p1.getInputStream(); OutputStream out = p2.getOutputStream();) {
			byte[] buffer = new byte[1024]; 
			int bytesRead; 
			while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);             
            }
			
			out.close();
		}
		
		try (InputStream result = p2.getInputStream()) {
            byte[] outputBuffer = new byte[1024];
            int length = result.read(outputBuffer);
            if (length != -1) {
                String output = new String(outputBuffer, 0, length);
                System.out.println("Resultado: " + output.trim());
            }
        }


        p1.waitFor();
        p2.waitFor();		
	}
}
