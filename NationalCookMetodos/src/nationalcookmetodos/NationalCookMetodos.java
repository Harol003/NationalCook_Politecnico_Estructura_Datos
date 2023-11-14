/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nationalcookmetodos;

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

public class NationalCookMetodos {
    public static void main(String[] args) {
        // Crear y configurar el JFrame principal
        JFrame frame = new JFrame("NationalCookMetodos | Politecnico Internacional");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Configurar el diseño del panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Crear una lista de objetos Restaurante
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("Andrés Carne de Res", "Fusión", 4.5));
        restaurantes.add(new Restaurante("Leo Cocina y Cava", "Gourmet", 4.8));
        restaurantes.add(new Restaurante("Harry Sasson", "Internacional", 4.2));
        restaurantes.add(new Restaurante("Criterion", "Contemporánea", 4.7));
        restaurantes.add(new Restaurante("El Cielo", "Molecular", 4.6));

        // Crear un JTextArea para mostrar la lista de restaurantes
        JTextArea restaurantesTextArea = new JTextArea();
        restaurantesTextArea.setEditable(false);

        // Utilizar métodos de iteración para mostrar los restaurantes
        int index = 1;
        for (Restaurante restaurante : restaurantes) {
            restaurantesTextArea.append(index + ". " + restaurante + "\n");
            index++;
        }

        // Botón para mostrar mensaje de agradecimiento y cerrar la aplicación
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Gracias por explorar los mejores restaurantes de Colombia. ¡Buen provecho! - Harol.Torres@pi.edu.co");
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

// Clase Restaurante para representar un restaurante
class Restaurante {
    private String nombre;
    private String tipoCocina;
    private double calificacion;

    public Restaurante(String nombre, String tipoCocina, double calificacion) {
        this.nombre = nombre;
        this.tipoCocina = tipoCocina;
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return nombre + " - " + tipoCocina + " (Calificación: " + calificacion + ")";
    }
}
