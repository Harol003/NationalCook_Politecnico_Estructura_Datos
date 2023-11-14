/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nationalcookgui;

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
import java.util.HashMap;
import java.util.Map;

public class NationalCookGUI {
    private JFrame frame;
    private Map<String, String> platosTipicos;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NationalCookGUI::new);
    }

    public NationalCookGUI() {
        platosTipicos = new HashMap<>();
        inicializar();
    }

    private void inicializar() {
        frame = new JFrame("NationalCook | Politecnico Internacional");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Pantalla de bienvenida
        mostrarPantallaBienvenida();
    }

    private void mostrarPantallaBienvenida() {
        JPanel panelBienvenida = new JPanel(new BorderLayout());
        panelBienvenida.setBackground(new Color(255, 218, 185)); // Tono: PeachPuff

        JLabel etiquetaTitulo = new JLabel("Bienvenido a NationalCook");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        etiquetaTitulo.setHorizontalAlignment(JLabel.CENTER);
        panelBienvenida.add(etiquetaTitulo, BorderLayout.NORTH);

        JButton botonInicioSesion = new JButton("Iniciar Sesión");
        panelBienvenida.add(botonInicioSesion, BorderLayout.SOUTH);

        botonInicioSesion.addActionListener(e -> {
            if (autenticarUsuario()) {
                frame.getContentPane().removeAll();
                frame.repaint();
                mostrarAplicacionPrincipal();
            } else {
                JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.getContentPane().add(panelBienvenida);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private boolean autenticarUsuario() {
        String usuario = JOptionPane.showInputDialog(frame, "Ingrese su nombre de usuario:");
        String contraseña = JOptionPane.showInputDialog(frame, "Ingrese su contraseña:");
        return "National".equals(usuario) && "Cook".equals(contraseña);
    }

    private void mostrarAplicacionPrincipal() {
        platosTipicos.put("Ajiaco", "Plato típico de la región Andina de Colombia");
        platosTipicos.put("Changua", "Plato típico de la región Andina de Colombia");
        platosTipicos.put("Arroz Bogotano", "Plato típico de la región Andina de Colombia");

        frame = new JFrame("NationalCook - Aplicación Principal");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(255, 250, 205)); // Tono: LemonChiffon

        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("Menú");

        configurarItemMenu(menu, "Consulta de Platos Típicos", this::consultarPlatosTipicos);
        configurarItemMenu(menu, "Modificación de Platos Típicos", this::modificarPlatosTipicos);
        configurarItemMenu(menu, "Ingredientes del Plato Changua", this::mostrarIngredientesChangua);
        configurarItemMenu(menu, "Salir de la Aplicación", () -> {
            JOptionPane.showMessageDialog(frame, "¡Gracias por usar NationalCook! | Harol.Torres@pi.edu.co");
            System.exit(0);
        });

        barraMenu.add(menu);
        frame.setJMenuBar(barraMenu);
        frame.setVisible(true);
    }

    private void configurarItemMenu(JMenu menu, String nombreItem, Runnable accion) {
        JMenuItem itemMenu = new JMenuItem(nombreItem);
        itemMenu.addActionListener(e -> accion.run());
        menu.add(itemMenu);
    }

    private void consultarPlatosTipicos() {
        StringBuilder mensaje = new StringBuilder("Platos típicos de la región Andina de Colombia:\n");
        platosTipicos.forEach((plato, descripcion) -> mensaje.append(plato).append(": ").append(descripcion).append("\n"));
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private void modificarPlatosTipicos() {
        Object[] platosArray = platosTipicos.keySet().toArray();
        Object seleccion = JOptionPane.showInputDialog(null, "Platos disponibles para modificar:", "Modificar Platos",
                JOptionPane.QUESTION_MESSAGE, null, platosArray, platosArray[0]);

        if (seleccion != null) {
            String nombrePlato = seleccion.toString();
            String nuevaDescripcion = JOptionPane.showInputDialog(null, "Ingrese la nueva descripción para " + nombrePlato + ":");
            if (nuevaDescripcion != null) {
                platosTipicos.put(nombrePlato, nuevaDescripcion);
                JOptionPane.showMessageDialog(null, "Plato modificado con éxito.");
            }
        }
    }

    private void mostrarIngredientesChangua() {
        String[] ingredientes = {"Leche", "Huevo", "Calado", "Queso", "Cilantro"};
        JOptionPane.showMessageDialog(null, "Ingredientes para el plato típico Changua:\n" + String.join("\n", ingredientes));
    }
}
