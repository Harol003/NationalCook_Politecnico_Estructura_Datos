/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nationalcooklistatipada;

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

public class NationalCookListaTipada {
    public static void main(String[] args) {
        // Crear y configurar el JFrame principal
        JFrame frame = new JFrame("NationalCookListaTipada | Politecnico Internacional");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Configurar el diseño del panel principal
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        // Crear una lista de objetos Restaurante
        ArrayList<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante("Andrés Carne de Res"));
        restaurantes.add(new Restaurante("Leo Cocina y Cava"));
        restaurantes.add(new Restaurante("Harry Sasson"));
        restaurantes.add(new Restaurante("Criterion"));
        restaurantes.add(new Restaurante("El Cielo"));

        // Crear un JTextArea para mostrar la lista de restaurantes
        JTextArea restaurantesTextArea = new JTextArea();
        restaurantesTextArea.setEditable(false);

        // Agregar la lista de restaurantes al JTextArea
        for (int i = 0; i < restaurantes.size(); i++) {
            restaurantesTextArea.append((i + 1) + ". " + restaurantes.get(i).getNombre() + "\n");
        }

        // Botón para mostrar mensaje de agradecimiento y cerrar la aplicación
        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Gracias por explorar los mejores restaurantes de Colombia. ¡Buen provecho! | Harol.Torres@pi.edu.co");
            System.exit(0);
        });

        // Agregar componentes al panel principal
        mainPanel.add(new JLabel("Los Mejores Restaurantes de Colombia:"));
        mainPanel.add(new JScrollPane(restaurantesTextArea));
        mainPanel.add(btnSalir);

        // Agregar el panel principal al JFrame
        frame.add(mainPanel);

        // Hacer visible el JFrame
        frame.setVisible(true);
    }
}

// Clase Restaurante para representar un restaurante
class Restaurante {
    private String nombre;

    public Restaurante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
