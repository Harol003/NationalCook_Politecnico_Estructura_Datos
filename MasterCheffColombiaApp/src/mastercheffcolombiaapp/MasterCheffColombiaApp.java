/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mastercheffcolombiaapp;

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

public class MasterCheffColombiaApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("MasterCheff Colombia | Politecnico Internacional");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Crear un botón para mostrar un mensaje
            JButton botonMensaje = new JButton("¡Bienvenido a MasterCheff Colombia!");
            botonMensaje.addActionListener(e -> JOptionPane.showMessageDialog(frame, "¡Preparados para cocinar! -  Harol.Torres@pi.edu.co"));

            // Agregar el botón al panel principal
            JPanel panel = new JPanel();
            panel.add(botonMensaje);

            // Agregar el panel al frame
            frame.add(panel);

            // Mostrar la ventana
            frame.setVisible(true);
        });
    }
}

