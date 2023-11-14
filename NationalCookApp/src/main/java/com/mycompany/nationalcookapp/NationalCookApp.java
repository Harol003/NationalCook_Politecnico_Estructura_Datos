/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nationalcookapp;

/**
 *
 * @author Harol
 */
// Importación de clases de Swing para la interfaz gráfica
import javax.swing.*;
// Importación de clases de AWT para componentes básicos de la interfaz gráfica
import java.awt.*;
// Importación de clases de AWT para gestionar eventos de acción
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Importación de la interfaz Map y la clase HashMap del paquete java.util
import java.util.HashMap;
import java.util.Map;
public class NationalCookApp {
    // Modelo: Mapa para almacenar platos típicos y sus descripciones
    private static Map<String, String> platosTipicos = new HashMap<>();

    public static void main(String[] args) {
        // Vista: Configuración de la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("NationalCook");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

            // Controlador: Autenticación de usuario mediante cuadro de diálogo
            String usuario = JOptionPane.showInputDialog(frame, "Ingrese su nombre de usuario:");
            String contraseña = JOptionPane.showInputDialog(frame, "Ingrese su contraseña:");

            // Verifica las credenciales del usuario
            if ("National".equals(usuario) && "Cook".equals(contraseña)) {
                // Inicialización de platos típicos
                platosTipicos.put("Ajiaco", "Plato típico de la región Andina de Colombia");
                platosTipicos.put("Changua", "Plato típico de la región Andina de Colombia");
                platosTipicos.put("Arroz Bogotano", "Plato típico de la región Andina de Colombia");

                // Controlador: Configuración de la GUI y manejo de eventos
                configureGUI(frame);
            } else {
                // Mensaje de error si las credenciales son incorrectas
                JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos. Cierre la aplicación.");
            }
        });
    }

    // Controlador: Configuración de la GUI y manejo de eventos
    private static void configureGUI(JFrame frame) {
        // Vista: Menú de opciones
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menú");
        JMenuItem consultaItem = new JMenuItem("Consulta de Platos Típicos");
        JMenuItem modificacionItem = new JMenuItem("Modificación de Platos Típicos");
        JMenuItem ingredientesItem = new JMenuItem("Ingredientes del Plato Changua");
        JMenuItem salirItem = new JMenuItem("Salir de la Aplicación");

        // Controlador: Asociación de eventos a las opciones del menú
        consultaItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarPlatosTipicos();
            }
        });

        modificacionItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarPlatosTipicos();
            }
        });

        ingredientesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarIngredientesChangua();
            }
        });

        salirItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vista: Mensaje de despedida
                JOptionPane.showMessageDialog(frame, "¡Gracias por usar NationalCook! Desarrollador por: Harol Torres - Harol.Torres@poli.edu.co");
                // Vista: Cierre de la aplicación
                System.exit(0);
            }
        });

        // Vista: Agregar elementos al menú
        menu.add(consultaItem);
        menu.add(modificacionItem);
        menu.add(ingredientesItem);
        menu.add(salirItem);
        menuBar.add(menu);

        // Vista: Configuración de la GUI principal
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    // Controlador: Función para mostrar los platos típicos
    private static void consultarPlatosTipicos() {
        // Vista: Cuadro de diálogo para mostrar los platos típicos
        StringBuilder message = new StringBuilder("Platos típicos de la región Andina de Colombia:\n");
        for (String plato : platosTipicos.keySet()) {
            message.append(plato).append(": ").append(platosTipicos.get(plato)).append("\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    // Controlador: Función para modificar los platos típicos
    private static void modificarPlatosTipicos() {
        // Vista: Cuadro de diálogo para mostrar los platos disponibles para modificar
        Object[] platosArray = platosTipicos.keySet().toArray();
        Object seleccion = JOptionPane.showInputDialog(null, "Platos disponibles para modificar:", "Modificar Platos",
                JOptionPane.QUESTION_MESSAGE, null, platosArray, platosArray[0]);

        if (seleccion != null) {
            String nombrePlato = seleccion.toString();

            // Vista: Cuadro de diálogo para ingresar la nueva descripción
            String nuevaDescripcion = JOptionPane.showInputDialog(null, "Ingrese la nueva descripción para " + nombrePlato + ":");
            if (nuevaDescripcion != null) {
                // Controlador: Modificación del plato en el modelo
                platosTipicos.put(nombrePlato, nuevaDescripcion);
                JOptionPane.showMessageDialog(null, "Plato modificado con éxito.");
            }
        }
    }

    // Controlador: Función para mostrar los ingredientes de Changua
    private static void mostrarIngredientesChangua() {
        // Vista: Cuadro de diálogo para mostrar los ingredientes de Changua
        String[] ingredientes = {"Leche", "Huevo", "Calado", "Queso", "Cilantro"};
        JOptionPane.showMessageDialog(null, "Ingredientes para el plato típico Changua:\n" + String.join("\n", ingredientes));
    }
}
