/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nationalcook;

/**
 *
 * @author Harol
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NationalCook {
    // Mapa para almacenar platos típicos y sus descripciones
    private static Map<String, String> platosTipicos = new HashMap<>();

    public static void main(String[] args) {
        // Configuración del lector de entrada
        Scanner scanner = new Scanner(System.in);

        // Autenticación de usuario
        System.out.println("Politecnico Internacional | National Cook");
        System.out.println("Aplicacion que da una muestra de la gastronomia colombiana, en ella encontrara informacion importante.");
        System.out.println("Para ingresar utilize como usuario National y para la contraseña utilize Cook");
        System.out.println("!Bienvenido¡");
        System.out.println("Ingrese su nombre de usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contraseña = scanner.nextLine();

        // Verifica las credenciales del usuario
        if ("National".equals(usuario) && "Cook".equals(contraseña)) {
            System.out.println("¡Bienvenido a NationalCook! Explora la deliciosa gastronomía de la región Andina de Colombia.");

            // Inicialización de platos típicos
            platosTipicos.put("Ajiaco", "Plato típico de la región Andina de Colombia");
            platosTipicos.put("Changua", "Plato típico de la región Andina de Colombia");
            platosTipicos.put("Arroz Bogotano", "Plato típico de la región Andina de Colombia");

            int opcion;
            do {
                // Menú de opciones
                System.out.println("\nMenú:");
                System.out.println("1. Consulta de Platos Típicos");
                System.out.println("2. Modificación de Platos Típicos");
                System.out.println("3. Ingredientes del Plato Changua");
                System.out.println("4. Salir de la Aplicación");

                // Solicita la opción al usuario
                System.out.println("\nIngrese el número de la opción deseada:");
                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    opcion = 0;
                }

                // Manejo de la opción seleccionada
                switch (opcion) {
                    case 1:
                        consultarPlatosTipicos();
                        break;
                    case 2:
                        modificarPlatosTipicos();
                        break;
                    case 3:
                        mostrarIngredientesChangua();
                        break;
                    case 4:
                        System.out.println("¡Gracias por usar NationalCook! Desarrollador por: Harol Torres - Harol.Torres@poli.edu.co");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 4.");
                        break;
                }
            } while (opcion != 4);
        } else {
            // Mensaje de error si las credenciales son incorrectas
            System.out.println("Usuario o contraseña incorrectos. Para ingresar utilize en el usuario National y en la contraseña Cook.");
        }
    }

    private static void consultarPlatosTipicos() {
        // Muestra los platos típicos almacenados en el mapa
        System.out.println("Platos típicos de la región Andina de Colombia:");
        for (String plato : platosTipicos.keySet()) {
            System.out.println(plato + ": " + platosTipicos.get(plato));
        }
    }

    private static void modificarPlatosTipicos() {
        // Lector de entrada para modificar platos
        Scanner scanner = new Scanner(System.in);

        // Muestra los platos disponibles para modificar
        System.out.println("Platos disponibles para modificar:");
        for (String plato : platosTipicos.keySet()) {
            System.out.println(plato);
        }

        // Solicita al usuario el nombre del plato a modificar
        System.out.println("Ingrese el nombre del plato que desea modificar:");
        String nombrePlato = scanner.nextLine();

        // Verifica si el plato existe y realiza la modificación
        if (platosTipicos.containsKey(nombrePlato)) {
            System.out.println("Ingrese la nueva descripción para " + nombrePlato + ":");
            String nuevaDescripcion = scanner.nextLine();
            platosTipicos.put(nombrePlato, nuevaDescripcion);
            System.out.println("Plato modificado con éxito.");
        } else {
            // Mensaje de error si el plato no existe
            System.out.println("El plato ingresado no existe.");
        }
    }

    private static void mostrarIngredientesChangua() {
        // Muestra los ingredientes del plato típico Changua
        System.out.println("Ingredientes para el plato típico Changua:");
        System.out.println("- Leche");
        System.out.println("- Huevo");
        System.out.println("- Calado");
        System.out.println("- Queso");
        System.out.println("- Cilantro");
    }
}
