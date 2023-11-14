/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nationalcookrapp;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NationalCookRApp {
    public static void main(String[] args) {
        // Crear y configurar el JFrame principal
        JFrame frame = new JFrame("NationalCookR | Politecnico Internacional");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel de inicio de sesión
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JTextField userField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Ingresar");

        loginPanel.add(new JLabel("Usuario:"));
        loginPanel.add(userField);
        loginPanel.add(new JLabel("Contraseña:"));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(loginButton);

        frame.add(loginPanel);

        // Evento de clic para el botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());

                // Verificar credenciales
                if (username.equals("National") && password.equals("Cook")) {
                    // Mostrar el menú principal si las credenciales son correctas
                    showMainMenu(frame);
                } else {
                    JOptionPane.showMessageDialog(frame, "Credenciales incorrectas", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    // Método para mostrar el menú principal
    private static void showMainMenu(JFrame frame) {
        frame.getContentPane().removeAll(); // Limpiar el contenido anterior

        // Configurar el nuevo diseño del menú principal
        JPanel menuPanel = new JPanel(new GridLayout(4, 1));
        JButton btnPlatosFuertes = new JButton("Receta de Platos Fuertes");
        JButton btnPostres = new JButton("Receta de Postres");
        JButton btnHelados = new JButton("Recetas de Helados");
        JButton btnSalir = new JButton("Salir");

        menuPanel.add(btnPlatosFuertes);
        menuPanel.add(btnPostres);
        menuPanel.add(btnHelados);
        menuPanel.add(btnSalir);

        // Eventos de clic para los botones del menú principal
        btnPlatosFuertes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar la tabla de platos fuertes
                JOptionPane.showMessageDialog(frame, "Mostrar tabla de platos fuertes de la región Andina");
            }
        });

        btnPostres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar el listado de postres
                JOptionPane.showMessageDialog(frame, "Mostrar listado de postres de Colombia");
            }
        });

        btnHelados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar el párrafo de cómo hacer helado
                JOptionPane.showMessageDialog(frame, "Instrucciones para hacer helado: ...");
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar mensaje de despedida y cerrar la aplicación
                JOptionPane.showMessageDialog(frame, "Gracias por su visita\nDesarrollado por Harol H. Torres - harol.torres@pi.edu.co");
                System.exit(0);
            }
        });

        frame.add(menuPanel);
        frame.revalidate(); // Actualizar el contenido del JFrame
    }
}
