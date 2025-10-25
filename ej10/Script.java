package ej10;

import java.io.File;
import java.io.IOException;

public class Script {
	
	public static void main (String[] args) throws InterruptedException {
		lanzarScript(); 
	}
	
	public static void lanzarScript() throws InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("bash","-lc","./script.sh Manu").directory(new File ("/home/manu/git_proyectos/actividadesPSP/src/ej10/"));
		pb.inheritIO(); 
		try {
			Process p = pb.start(); 
			int codigo = p.waitFor(); 
			if (codigo == 0) {
				System.out.println("Proceso finalizado con éxito con código: " + codigo);
			} else {
				System.out.println("Codigo de error: " + codigo); 
			}
		} catch (IOException e) {
			e.printStackTrace(); 
		}	
	}
}
