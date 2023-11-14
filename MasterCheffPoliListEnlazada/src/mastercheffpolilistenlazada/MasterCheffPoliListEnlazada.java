/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastercheffpolilistenlazada;

/**
 *
 * @author Harol
 */
import java.util.Scanner;

// Modelo: Clase Nodo que representa un elemento de la lista enlazada
class Nodo {
    String valor;
    Nodo siguiente;

    public Nodo(String valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

// Modelo: Clase ListaEnlazada que gestiona la lista de temporadas
class ListaEnlazada {
    private Nodo inicio; // Puntero al primer nodo de la lista

    // Método para insertar un nuevo valor al principio de la lista
    public void insertar(String valor) {
        Nodo nuevoNodo = new Nodo(valor); // Crear un nuevo nodo con el valor
        nuevoNodo.siguiente = inicio; // El nuevo nodo apunta al antiguo primer nodo
        inicio = nuevoNodo; // El nuevo nodo se convierte en el primer nodo
    }

    // Método para eliminar un valor específico de la lista
    public boolean eliminar(String valor) {
        Nodo actual = inicio;
        Nodo anterior = null;

        while (actual != null && !actual.valor.equals(valor)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            if (anterior == null) {
                inicio = actual.siguiente; // Si es el primer nodo, actualizar inicio
            } else {
                anterior.siguiente = actual.siguiente; // Si no es el primero, actualizar el enlace del nodo anterior
            }
            return true; // Valor eliminado con éxito
        }

        return false; // Valor no encontrado en la lista
    }

    // Método para actualizar un valor específico de la lista
    public boolean actualizar(String valorViejo, String valorNuevo) {
        Nodo actual = inicio;

        while (actual != null) {
            if (actual.valor.equals(valorViejo)) {
                actual.valor = valorNuevo; // Reemplazar el valor viejo con el nuevo
                return true; // Valor actualizado con éxito
            }
            actual = actual.siguiente;
        }

        return false; // Valor no encontrado en la lista
    }

    // Método para consultar y obtener una representación de la lista como una cadena
    public String consultar() {
        StringBuilder result = new StringBuilder();
        Nodo actual = inicio;

        while (actual != null) {
            result.append(actual.valor).append(" - "); // Concatenar valores con un separador
            actual = actual.siguiente;
        }

        return result.toString();
    }
}

// Controlador: Clase principal de la aplicación
public class MasterCheffPoliListEnlazada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEnlazada temporadas = new ListaEnlazada();
        temporadas.insertar("T2018");
        temporadas.insertar("T2019");
        temporadas.insertar("T2021");
        temporadas.insertar("T2022");
        temporadas.insertar("T2023");
        System.out.println("POLITECNICO INTERNACIONAL|Estrutura de Datos");
        System.out.println("Bienvenido a MasterCheffPoliListEnlazada");
        System.out.println("Aplicacion MasterCheff que utiliza componentes de una Lista Enlazada | Insercion - Eliminacion - Acceso - Busqueda - Longitud. Para ingresar utiliza POLI + Estructura. ");
        System.out.println(" ");
        String usuario, contrasena;

        do {
            System.out.print("Usuario: ");
            usuario = scanner.nextLine();
            System.out.print("Passwd: ");
            contrasena = scanner.nextLine();
        } while (!usuario.equals("POLI") || !contrasena.equals("Estructura"));

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Consultar temporadas MasterCheff Colombia");
            System.out.println("2. Agregar temporada MasterCheff Colombia");
            System.out.println("3. Eliminar temporada MasterCheff Colombia");
            System.out.println("4. Actualizar temporada MasterCheff Colombia");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    // Vista: Consultar temporadas
                    System.out.println("Temporadas de MasterChef: " + temporadas.consultar());
                    break;
                case 2:
                    // Vista: Agregar temporada
                    System.out.print("Ingrese la nueva temporada: ");
                    String nuevaTemporada = scanner.nextLine();
                    temporadas.insertar(nuevaTemporada);
                    System.out.println("Temporada agregada con exito.");
                    break;
                case 3:
                    // Vista: Eliminar temporada
                    System.out.print("Ingrese la temporada a eliminar: ");
                    String temporadaEliminar = scanner.nextLine();
                    if (temporadas.eliminar(temporadaEliminar)) {
                        System.out.println("Temporada eliminada con exito.");
                    } else {
                        System.out.println("Temporada no encontrada.");
                    }
                    break;
                case 4:
                    // Vista: Actualizar temporada
                    System.out.print("Ingrese la temporada a actualizar: ");
                    String temporadaVieja = scanner.nextLine();
                    System.out.print("Ingrese la nueva temporada: ");
                    String temporadaNueva = scanner.nextLine();
                    if (temporadas.actualizar(temporadaVieja, temporadaNueva)) {
                        System.out.println("Temporada actualizada con exito.");
                    } else {
                        System.out.println("Temporada no encontrada.");
                    }
                    break;
                case 5:
                    // Vista: Salir
                    System.out.println("Gracias por usar MasterCheffPoliListEnlazada.");
                    System.out.println("Desarrollado Por Harol H. Torres - Harol.Torres@pi.edu.co");
                    System.exit(0);
                default:
                    System.out.println("Opción no valida. Intentalo de nuevo.");
            }
        }
    }
}

