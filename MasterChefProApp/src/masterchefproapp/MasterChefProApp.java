/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package masterchefproapp;

/**
 *
 * @author Harol
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MasterChefProApp {
    public static void main(String[] args) {
        // Crear un usuario con credenciales predefinidas
        Usuario usuario = new Usuario("politecnico", "estructura");

        // Mostrar un mensaje de bienvenida
        System.out.println("Politecnico Internacional | MasterchefProApp");
        System.out.println("Aplicacion que muestra los ingredientes de un postre tipico de Bogota.");
        
        // Solicitar nombre de usuario y contraseña al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese Usuario: ");
        String inputUsuario = scanner.nextLine();
        System.out.print("Ingrese Contraseña: ");
        String inputContraseña = scanner.nextLine();

        // Validar las credenciales del usuario
        if (usuario.validarCredenciales(inputUsuario, inputContraseña)) {
            // Usuario y contraseña válidos, crear y mostrar la información de la receta
            Receta receta = new Receta("Receta Arroz con Leche", "Un postre tipico de Bogota");
            receta.agregarIngrediente(new Ingrediente("Arroz", 100.0));
            receta.agregarIngrediente(new Ingrediente("Panela", 200.0));
            receta.agregarIngrediente(new Ingrediente("Leche", 50.0));

            // Mostrar los ingredientes de la receta
            System.out.println("Ingredientes de la receta:");
            for (Ingrediente ingrediente : receta.getIngredientes()) {
                System.out.println(ingrediente.getNombre() + ": " + ingrediente.getCantidad() + " gramos");
            }
            System.out.println("Desarrollado por: Harol Torres - Harol.Torres@pi.edu.co");
        } else {
            // Credenciales incorrectas
            System.out.println("Credenciales incorrectas. No puedes acceder a la receta. Utiliza para usuario: politecnico y para la contraseña: estructura.");
        }
    }
}

class Usuario {
    private String nombre;
    private String contraseña;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public boolean validarCredenciales(String nombre, String contraseña) {
        // Validar las credenciales del usuario
        return this.nombre.equals(nombre) && this.contraseña.equals(contraseña);
    }
}

class Receta {
    private String nombre;
    private String descripción;
    private List<Ingrediente> ingredientes;

    public Receta(String nombre, String descripción) {
        this.nombre = nombre;
        this.descripción = descripción;
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        // Agregar un ingrediente a la lista de ingredientes
        ingredientes.add(ingrediente);
    }

    public List<Ingrediente> getIngredientes() {
        // Obtener la lista de ingredientes
        return ingredientes;
    }
}

class Ingrediente {
    private String nombre;
    private double cantidad;

    public Ingrediente(String nombre, double cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        // Obtener el nombre del ingrediente
        return nombre;
    }

    public double getCantidad() {
        // Obtener la cantidad del ingrediente
        return cantidad;
    }
}
