package ej1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Echo {

    public static List<String> comando = new ArrayList<>();

    public static void main(String[] args) {
        comando = Arrays.asList("echo", "hola", "mundo");
        ejecutarComando(comando);
    }

    public static void ejecutarComando(List<String> comando) {
        try {
            ProcessBuilder pb = new ProcessBuilder(comando);
            pb.inheritIO();
            Process proceso = pb.start();
            int result = proceso.waitFor();
            if (result == 0) {
                System.out.println("El comando se ejecutó correctamente.");
            } else {
                System.out.println("El comando falló con código: " + result);
            }
        } catch (Exception ex) {
            System.err.println("Error al ejecutar el comando: " + ex.getMessage());
        }
    }
}

