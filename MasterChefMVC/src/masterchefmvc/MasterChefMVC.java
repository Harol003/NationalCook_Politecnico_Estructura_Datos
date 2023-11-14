/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package masterchefmvc;

/**
 *
 * @author Harol
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ModeloMasterChef {
    private String ganador;

    public String obtenerGanador() {
        return ganador;
    }

    public void establecerGanador(String ganador) {
        this.ganador = ganador;
    }
}

class VistaMasterChef {
    private JFrame frame;
    private ModeloMasterChef modelo;         // Referencia al modelo (Model)
    private JLabel etiquetaGanador;           // Etiqueta para mostrar el nombre del ganador
    private JButton botonAnunciarGanador;     // Botón para anunciar al ganador
    private JButton botonCreditos;            // Botón para mostrar los créditos
    private JButton botonSalir;               // Botón para salir de la aplicación

    public VistaMasterChef(ModeloMasterChef modelo) {
        this.modelo = modelo;  // Establece la relación entre la vista y el modelo

        // Crear la ventana principal
        frame = new JFrame("| Politecnico Internacional | MasterChef Colombia |");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear componentes de la interfaz de usuario
        etiquetaGanador = new JLabel("Ganador Temporada 2023: ");
        botonAnunciarGanador = new JButton("Resultado");
        botonCreditos = new JButton("Creditos");
        botonSalir = new JButton("Salir");

        // Definir colores pastel para los botones
        botonAnunciarGanador.setBackground(new Color(255, 217, 179));  // Color melocotón
        botonCreditos.setBackground(new Color(173, 216, 230));         // Color azul claro
        botonSalir.setBackground(new Color(255, 192, 203));           // Color rosa claro

        // Ajustar el tamaño de los botones (mismo ancho)
        int buttonWidth = 150;
        int buttonHeight = 30;
        botonAnunciarGanador.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        botonCreditos.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        botonSalir.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        // Agregar componentes a la ventana
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(20));  // Espaciado vertical
        panel.add(etiquetaGanador);
        panel.add(Box.createVerticalStrut(20));  // Espaciado vertical
        panel.add(botonAnunciarGanador);
        panel.add(Box.createVerticalStrut(10));  // Espaciado vertical
        panel.add(botonCreditos);
        panel.add(Box.createVerticalStrut(10));  // Espaciado vertical
        panel.add(botonSalir);

        frame.add(panel);

        // Ajustar el tamaño de la ventana a 700x300
        frame.setSize(700, 300);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);

        // Configurar el botón "Anunciar Ganador" para manejar eventos
        botonAnunciarGanador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarGanador();
            }
        });

        // Configurar el botón "Créditos" para manejar eventos
        botonCreditos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarCreditos();
            }
        });

        // Configurar el botón "Salir" para manejar eventos
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Salir de la aplicación
            }
        });

        frame.setVisible(true);
    }

    public void mostrarGanador() {
        String ganador = modelo.obtenerGanador();  // Obtiene el ganador del modelo
        etiquetaGanador.setText("EL Ganador de la Temporada 2023 es " + ganador);
    }

    public void mostrarCreditos() {
        JOptionPane.showMessageDialog(frame,
                "Desarrollado por Harol H. Torres\nEmail: Harol.Torres@pi.edu.co",
                "Créditos",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

class ControladorMasterChef {
    private ModeloMasterChef modelo;  // Referencia al modelo (Model)
    private VistaMasterChef vista;    // Referencia a la vista (View)

    public ControladorMasterChef(ModeloMasterChef modelo, VistaMasterChef vista) {
        this.modelo = modelo;  // Establece la relación entre el controlador y el modelo
        this.vista = vista;    // Establece la relación entre el controlador y la vista
    }

    public void iniciar() {
        // Aquí se indica el ganador para la temporada 2023, así no estuviéramos de acuerdo.
        modelo.establecerGanador("Carolina Acevedo Rojas, de profesión actriz.");  // Establece el ganador en el modelo
    }
}

public class MasterChefMVC {
    public static void main(String[] args) {
        ModeloMasterChef modelo = new ModeloMasterChef();
        VistaMasterChef vista = new VistaMasterChef(modelo);     // Crea la vista con el modelo
        ControladorMasterChef controlador = new ControladorMasterChef(modelo, vista);  // Crea el controlador con el modelo y la vista

        // Iniciar la aplicación
        controlador.iniciar();  // Inicia la aplicación a través del controlador
    }
}
