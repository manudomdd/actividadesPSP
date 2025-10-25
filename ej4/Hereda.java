package ej4;

import java.io.IOException;

public class Hereda {
	
	public static void main (String[] args) {
		heredarComando(); 
	} 
	
	public static void heredarComando() {
		ProcessBuilder pb = new ProcessBuilder("top", "-b", "-n1");
        pb.inheritIO(); 

        try {
            Process proceso = pb.start();
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}
}
