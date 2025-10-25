package ej6;

import java.io.IOException;

public class Variables {
	
	public static void main (String[] args) {
		variable(); 		
	}
	
	public static void variable() {
		ProcessBuilder pb = new ProcessBuilder("bash", "-lc", "printenv MI_VAR");
		pb.environment().put("MI_VAR", "UD1");
		pb.inheritIO(); 
		try {
			Process proceso = pb.start(); 
			proceso.waitFor(); 
		} catch (IOException | InterruptedException ex) {
			ex.getStackTrace(); 
		}
	}
}
