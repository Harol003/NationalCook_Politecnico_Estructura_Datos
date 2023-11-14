/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastercheffpolilistgenerica;

/**
 *
 * @author Harol
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Modelo: Clase Participante que representa un elemento de la lista genérica
class Participante {
    private final String nombre;

    public Participante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

// Controlador: Clase principal de la aplicación
public class MasterCheffPoliListGenerica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Participante> participantes = new LinkedList<>();

        // Inicializar la lista con participantes de MasterChef 2023
        participantes.add(new Participante("Adrian Parada"));
        participantes.add(new Participante("Alvaro Bayona"));
        participantes.add(new Participante("Biasso Segura"));
        participantes.add(new Participante("Carolina Acevedo"));
        participantes.add(new Participante("La Cata con Botas"));
        participantes.add(new Participante("Daniela Tapia"));
        participantes.add(new Participante("Diego Saenz"));
        participantes.add(new Participante("El Negrito W"));
        System.out.println("POLITECNICO INTERNACIONAL|Estrutura de Datos");
        System.out.println("Bienvenido a MasterCheffPoliListGenerica");
        System.out.println("Aplicacion MasterCheff que utiliza componentes de una Lista Generica | Insercion - Eliminacion - Acceso - Busqueda - Longitud. Para ingresar utiliza POLI + Estructura. ");
        System.out.println(" ");
        String usuario, contrasena;

        // Vista: Solicitar usuario y contraseña
        do {
            System.out.print("Usuario: ");
            usuario = scanner.nextLine();
            System.out.print("Passwd: ");
            contrasena = scanner.nextLine();
        } while (!usuario.equals("POLI") || !contrasena.equals("Estructura"));

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Consultar participantes");
            System.out.println("2. Eliminar participante");
            System.out.println("3. Actualizar participante");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Vista: Consultar participantes
                    System.out.println("Participantes de MasterChef 2023:");
                    for (Participante participante : participantes) {
                        System.out.println(participante);
                    }
                    break;
                case 2:
                    // Vista: Eliminar participante
                    System.out.print("Ingrese el nombre del participante a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    participantes.removeIf(participante -> participante.getNombre().equalsIgnoreCase(nombreEliminar));
                    break;
                case 3:
                    // Vista: Actualizar participante
                    System.out.print("Ingrese el nombre del participante a actualizar: ");
                    String nombreViejo = scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre del participante: ");
                    String nombreNuevo = scanner.nextLine();
                    for (Participante participante : participantes) {
                        if (participante.getNombre().equalsIgnoreCase(nombreViejo)) {
                            participante = new Participante(nombreNuevo);
                            break;
                        }
                    }
                    break;
                case 4:
                    // Vista: Salir
                    System.out.println("Gracias por usar MasterCheffPoliListGenerica.");
                    System.out.println("Desarrollado Por Harol H. Torres - Harol.Torres@pi.edu.co");
                    System.exit(0);
                default:
                    System.out.println("Opción no valida. Intentalo de nuevo.");
            }
        }
    }
}
