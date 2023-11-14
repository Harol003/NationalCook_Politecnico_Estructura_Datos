/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nationalcooklistaabstracta;

/**
 *
 * @author Harol
 * 
 * Estructura de Datos
 * Politecnico Internacional
 * Profesor | Harol Hernan Torres Neuta
 * Email: Harol.Torres@pi.edu.co
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NationalCookListaAbstracta {
    public static void main(String[] args) {
        // Crear y configurar el JFrame principal
        JFrame frame = new JFrame("NationalCookListaAbstracta | Politecnico Internacional ");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Configurar el diseño del panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Crear una lista de objetos Restaurante utilizando una interfaz abstracta
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new RestauranteNormal("Andrés Carne de Res", "Fusión", 4.5));
        restaurantes.add(new RestauranteGourmet("Leo Cocina y Cava", "Gourmet", 4.8));
        restaurantes.add(new RestauranteNormal("Harry Sasson", "Internacional", 4.2));
        restaurantes.add(new RestauranteGourmet("Criterion", "Contemporánea", 4.7));
        restaurantes.add(new RestauranteNormal("El Cielo", "Molecular", 4.6));

        // Crear un JTextArea para mostrar la lista de restaurantes
        JTextArea restaurantesTextArea = new JTextArea();
        restaurantesTextArea.setEditable(false);

        // Agregar la lista de restaurantes al JTextArea
        for (int i = 0; i < restaurantes.size(); i++) {
            restaurantesTextArea.append((i + 1) + ". " + restaurantes.get(i) + "\n");
        }

        // Botón para mostrar mensaje de agradecimiento y cerrar la aplicación
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Gracias por explorar los mejores restaurantes de Colombia. ¡Buen provecho! | harol.torres@pi.edu.co");
            System.exit(0);
        });

        // Agregar componentes al panel principal
        mainPanel.add(new JLabel("Los Mejores Restaurantes de Colombia:"), BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(restaurantesTextArea), BorderLayout.CENTER);
        mainPanel.add(btnSalir, BorderLayout.SOUTH);

        // Agregar el panel principal al JFrame
        frame.add(mainPanel);

        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}

// Interfaz abstracta para representar un restaurante
interface Restaurante {
    String getNombre();

    String getTipoCocina();

    double getCalificacion();
}

// Clase que implementa la interfaz para un restaurante normal
class RestauranteNormal implements Restaurante {
    private String nombre;
    private String tipoCocina;
    private double calificacion;

    public RestauranteNormal(String nombre, String tipoCocina, double calificacion) {
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.calificacion = calificacion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getTipoCocina() {
        return tipoCocina;
    }

    @Override
    public double getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        return nombre + " - " + tipoCocina + " (Calificación: " + calificacion + ")";
    }
}

// Clase que implementa la interfaz para un restaurante gourmet
class RestauranteGourmet implements Restaurante {
    private String nombre;
    private String tipoCocina;
    private double calificacion;

    public RestauranteGourmet(String nombre, String tipoCocina, double calificacion) {
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.calificacion = calificacion;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getTipoCocina() {
        return tipoCocina;
    }

    @Override
    public double getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        return nombre + " - " + tipoCocina + " (Calificación: " + calificacion + ")";
    }
}
