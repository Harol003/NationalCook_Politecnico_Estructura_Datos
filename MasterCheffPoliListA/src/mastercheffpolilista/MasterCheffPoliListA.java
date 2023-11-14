/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastercheffpolilista;

/**
 *
 * @author Harol
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Modelo: contiene la lógica de la aplicación y los datos.
class MasterCheffPoliListAModel {
    private List<String> participantes; // Lista abstracta para almacenar los datos de los participantes

    public MasterCheffPoliListAModel() {
        participantes = new ArrayList<>();
    }

    // Método para insertar un participante en la lista
    public void insertarParticipante(String nombre) {
        participantes.add(nombre);
    }

    // Método para eliminar un participante de la lista
    public void eliminarParticipante(String nombre) {
        participantes.remove(nombre);
    }

    // Método para acceder a los datos de los participantes
    public List<String> accederDatos() {
        return participantes;
    }

    // Método para buscar un participante en la lista
    public boolean buscarParticipante(String nombre) {
        return participantes.contains(nombre);
    }

    // Método para obtener la longitud de la lista
    public int obtenerLongitud() {
        return participantes.size();
    }
}

// Vista: maneja la interfaz de usuario y presenta información al usuario.
class MasterCheffPoliListAView {
    public void mostrarMensajeBienvenida() {
        System.out.println("POLITECNICO INTERNACIONAL|Estrutura de Datos");
        System.out.println(" ");
        System.out.println("Bienvenido a MasterCheffPoliListA");
        System.out.println("Aplicacion MasterCheff que utiliza componentes de una Lista Abstracta | Insercion - Eliminacion - Acceso - Busqueda - Longitud.");
    }

    public void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Insercion");
        System.out.println("2. Eliminacion");
        System.out.println("3. Acceso");
        System.out.println("4. Busqueda");
        System.out.println("5. Longitud");
        System.out.println("6. Creditos");
        System.out.println("7. Salir");
    }

    public void mostrarMensajeDespedida() {
        System.out.println("Gracias por usar MasterCheffPoliListA. Politecnico Internacional");
    }
}

// Controlador: gestiona la interacción entre el modelo y la vista.
class MasterCheffPoliListAController {
    private MasterCheffPoliListAModel model;
    private MasterCheffPoliListAView view;

    public MasterCheffPoliListAController(MasterCheffPoliListAModel model, MasterCheffPoliListAView view) {
        this.model = model;
        this.view = view;
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        view.mostrarMensajeBienvenida();

        while (true) {
            view.mostrarMenu();
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del participante a insertar: ");
                    String nombreInsercion = scanner.nextLine();
                    model.insertarParticipante(nombreInsercion);
                    System.out.println("Participante insertado con exito.");
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del participante a eliminar: ");
                    String nombreEliminacion = scanner.nextLine();
                    model.eliminarParticipante(nombreEliminacion);
                    System.out.println("Participante eliminado con exito.");
                    break;
                case 3:
                    List<String> datos = model.accederDatos();
                    System.out.println("Datos de los participantes: " + datos);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del participante a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    boolean encontrado = model.buscarParticipante(nombreBusqueda);
                    if (encontrado) {
                        System.out.println("El participante ha sido encontrado.");
                    } else {
                        System.out.println("El participante no ha sido encontrado.");
                    }
                    break;
                case 5:
                    int longitud = model.obtenerLongitud();
                    System.out.println("Longitud de la lista de participantes: " + longitud);
                    break;
                case 6:
                    System.out.println("Desarrollado Por Harol H. Torres - Harol.Torres@pi.edu.co");
                    break;
                case 7:
                    view.mostrarMensajeDespedida();
                    return;
                default:
                    System.out.println("Opcion no valida. Intentalo de nuevo.");
            }
        }
    }
}

public class MasterCheffPoliListA {
    public static void main(String[] args) {
        MasterCheffPoliListAModel model = new MasterCheffPoliListAModel();
        MasterCheffPoliListAView view = new MasterCheffPoliListAView();
        MasterCheffPoliListAController controller = new MasterCheffPoliListAController(model, view);

        controller.ejecutar();
    }
}
