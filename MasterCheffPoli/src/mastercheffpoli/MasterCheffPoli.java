/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastercheffpoli;

/**
 *
 * @author Harol
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Modelo: contiene la lógica de la aplicación y los datos.
class MasterCheffPoliModel {
    // Recetas de postres
    private List<String> recetas;

    // Participantes del programa
    private List<String> participantes;

    public MasterCheffPoliModel() {
        recetas = new ArrayList<>();
        recetas.add("Arroz con Leche");
        recetas.add("Arequipe Casero");

        participantes = new ArrayList<>();
        participantes.add("Carolina Acevedo");
        participantes.add("Zulma Rey");
        participantes.add("Natalia Sanint");
        participantes.add("Nela Gonzalez");
        participantes.add("Daniela Tapia");
        participantes.add("Diego Saenz");
    }

    public List<String> getRecetas() {
        return recetas;
    }

    public List<String> getParticipantes() {
        return participantes;
    }
}

// Vista: maneja la interfaz de usuario y presenta información al usuario.
class MasterCheffPoliView {
    public void mostrarMensajeBienvenida() {
        System.out.println("Bienvenido a MasterCheffPoli");
    }

    public void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1. Consultar Recetas");
        System.out.println("2. Informacion Participantes");
        System.out.println("3. Creditos");
        System.out.println("4. Salir");
    }

    public void mostrarRecetas(List<String> recetas) {
        System.out.println("Recetas de Postres:");
        for (String receta : recetas) {
            System.out.println(receta);
        }
    }

    public void mostrarParticipantes(List<String> participantes) {
        System.out.println("Participantes:");
        for (String participante : participantes) {
            System.out.println(participante);
        }
    }

    public void mostrarCreditos() {
        System.out.println("Desarrollado Por Harol H. Torres - Harol.Torres@pi.edu.co");
    }

    public void mostrarMensajeDespedida() {
        System.out.println("Gracias por usar MasterCheffPoli. Politecnico Internacional ");
    }
}

// Controlador: gestiona la interacción entre el modelo y la vista.
class MasterCheffPoliController {
    private MasterCheffPoliModel model;
    private MasterCheffPoliView view;

    public MasterCheffPoliController(MasterCheffPoliModel model, MasterCheffPoliView view) {
        this.model = model;
        this.view = view;
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        // Autenticación de usuario
        System.out.println("POLITECNICO INTERNACIONAL|Estrutura de Datos");
        System.out.println(" ");
        System.out.println("Aplicacion MasterCheff para visualizar un listado de Recetas de Postres, Participantes del Programa y Creditos de Desarrollo. Para ingresar utiliza POLI + Estructura.");
        System.out.println(" ");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Passwd: ");
        String contrasena = scanner.nextLine();

        if (usuario.equals("POLI") && contrasena.equals("Estructura")) {
            view.mostrarMensajeBienvenida();

            while (true) {
                view.mostrarMenu();
                System.out.print("Selecciona una opcion: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        view.mostrarRecetas(model.getRecetas());
                        break;
                    case 2:
                        view.mostrarParticipantes(model.getParticipantes());
                        break;
                    case 3:
                        view.mostrarCreditos();
                        break;
                    case 4:
                        view.mostrarMensajeDespedida();
                        return;
                    default:
                        System.out.println("Opcion no valida. Intentalo de nuevo.");
                }
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos. La aplicacion se cerrara.");
        }
    }
}

public class MasterCheffPoli {
    public static void main(String[] args) {
        MasterCheffPoliModel model = new MasterCheffPoliModel();
        MasterCheffPoliView view = new MasterCheffPoliView();
        MasterCheffPoliController controller = new MasterCheffPoliController(model, view);

        controller.ejecutar();
    }
}
