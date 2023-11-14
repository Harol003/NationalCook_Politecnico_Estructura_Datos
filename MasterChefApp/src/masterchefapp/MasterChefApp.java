/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package masterchefapp;

/**
 *
 * @author Harol
 */


/** VERSION1
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterChefApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
}

class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginView() {
        setTitle("Iniciar Sesión");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Usuario:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Iniciar Sesión");

        add(usernameLabel); // Agrega etiqueta de usuario al diseño
        add(usernameField); // Agrega campo de texto de usuario al diseño
        add(passwordLabel); // Agrega etiqueta de contraseña al diseño
        add(passwordField); // Agrega campo de contraseña al diseño
        add(new JLabel("")); // Espacio en blanco para alinear
        add(loginButton); // Agrega el botón de inicio de sesión al diseño

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                if (verifyCredentials(username, new String(password))) {
                    dispose(); // Cierra la ventana de inicio de sesión
                    MainView mainView = new MainView();
                    mainView.setVisible(true); // Muestra la vista principal
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean verifyCredentials(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }
}

class MainView extends JFrame {
    public MainView() {
        setTitle("MasterChef");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en la pantalla

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Recetas Colombianas", new RecetasPanel());
        tabbedPane.addTab("Mejores Restaurantes de Colombia", new RestaurantesPanel());
        tabbedPane.addTab("Información MasterChef Colombia", new InformacionPanel());
        tabbedPane.addTab("Créditos", new CreditosPanel());

        add(tabbedPane); // Agrega el panel de pestañas al diseño
    }
}

class RecetasPanel extends JPanel {
    public RecetasPanel() {
        setLayout(new FlowLayout());

        JButton recetasButton = new JButton("Recetas Colombianas");
        add(recetasButton); // Agrega el botón de recetas al diseño

        recetasButton.addActionListener(e -> {
            String[] recetas = {"Ajiaco", "Bandeja Paisa", "Sancocho", "Arepas", "Empanadas"};
            JOptionPane.showMessageDialog(this, String.join("\n", recetas), "Recetas Colombianas", JOptionPane.PLAIN_MESSAGE);
        });

        JButton salirButton = new JButton("Salir");
        add(salirButton); // Agrega el botón de salida al diseño

        salirButton.addActionListener(e -> System.exit(0)); // Cierra la aplicación al hacer clic en Salir
    }
}

class RestaurantesPanel extends JPanel {
    public RestaurantesPanel() {
        setLayout(new BorderLayout());

        String[] columnNames = {"Nombre", "Dirección", "Teléfono", "Sitio Web"};
        Object[][] data = {
            {"Restaurante 1", "Dirección 1", "123-456-7890", "www.restaurante1.com"},
            {"Restaurante 2", "Dirección 2", "987-654-3210", "www.restaurante2.com"},
            {"Restaurante 3", "Dirección 3", "555-555-5555", "www.restaurante3.com"},
            {"Restaurante 4", "Dirección 4", "111-222-3333", "www.restaurante4.com"},
            {"Restaurante 5", "Dirección 5", "999-888-7777", "www.restaurante5.com"}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER); // Agrega la tabla al centro del diseño

        JButton salirButton = new JButton("Salir");
        add(salirButton, BorderLayout.SOUTH); // Agrega el botón de salida en la parte inferior

        salirButton.addActionListener(e -> System.exit(0)); // Cierra la aplicación al hacer clic en Salir
    }
}

class InformacionPanel extends JPanel {
    public InformacionPanel() {
        setLayout(new BorderLayout());

        JTextArea infoTextArea = new JTextArea("MasterChef Colombia es un popular programa de televisión que " +
                "destaca la cocina colombiana. El programa presenta a chefs talentosos compitiendo por el título " +
                "de MasterChef. El jurado está compuesto por chefs expertos que evalúan las habilidades culinarias " +
                "de los concursantes.");
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setLineWrap(true);
        infoTextArea.setCaretPosition(0);
        infoTextArea.setOpaque(false);
        infoTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        add(scrollPane, BorderLayout.CENTER); // Agrega el área de texto al centro del diseño

        JButton salirButton = new JButton("Salir");
        add(salirButton, BorderLayout.SOUTH); // Agrega el botón de salida en la parte inferior

        salirButton.addActionListener(e -> System.exit(0)); // Cierra la aplicación al hacer clic en Salir
    }
}

class CreditosPanel extends JPanel {
    public CreditosPanel() {
        setLayout(new GridLayout(4, 1));

        JLabel creditsLabel = new JLabel("Créditos");
        add(creditsLabel); // Agrega la etiqueta de créditos al diseño

        JLabel infoLabel = new JLabel("Harol Hernan Torres | Politecnico Internacional | Harol.Torres@pi.edu.co | 2023");
        add(infoLabel); // Agrega la información de créditos al diseño

        JButton salirButton = new JButton("Salir");
        add(salirButton); // Agrega el botón de salida al diseño

        salirButton.addActionListener(e -> System.exit(0)); // Cierra la aplicación al hacer clic en Salir
    }
}
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterChefApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
}

class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginView() {
        setTitle("Mastercheff | Politecnico Internacional | Programacion II");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Usuario:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Ingresar");

        // Cambios en el botón de Iniciar Sesión
        loginButton.setBackground(new Color(172, 209, 233)); // Fondo color pastel
        loginButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y tamaño

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel(""));
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                if (verifyCredentials(username, new String(password))) {
                    dispose();
                    MainView mainView = new MainView();
                    mainView.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Credenciales incorrectas, prueba con admin y password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean verifyCredentials(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }
}

class MainView extends JFrame {
    public MainView() {
        setTitle("MasterChef");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Comida Colombiana", new RecetasPanel());
        tabbedPane.addTab("Mejores Restaurantes de Colombia", new RestaurantesPanel());
        tabbedPane.addTab("Información MasterChef Colombia", new InformacionPanel());
        tabbedPane.addTab("Créditos", new CreditosPanel());

        add(tabbedPane);
    }
}

class RecetasPanel extends JPanel {
    public RecetasPanel() {
        setLayout(new FlowLayout());

        JButton recetasButton = new JButton("Ver Listado");
        add(recetasButton);

        // Cambios en el botón de Recetas Colombianas
        recetasButton.setBackground(new Color(255, 228, 196)); // Fondo color pastel
        recetasButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y tamaño

        recetasButton.addActionListener(e -> {
            String[] recetas = {"Ajiaco", "Bandeja Paisa", "Sancocho", "Arepas", "Empanadas"};
            JOptionPane.showMessageDialog(this, String.join("\n", recetas), "Recetas Colombianas", JOptionPane.PLAIN_MESSAGE);
        });

        JButton salirButton = new JButton("Salir");
        add(salirButton);

        // Cambios en el botón de Salir
        salirButton.setBackground(new Color(255, 192, 203)); // Fondo color pastel
        salirButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y tamaño

        salirButton.addActionListener(e -> System.exit(0));
    }
}

class RestaurantesPanel extends JPanel {
    public RestaurantesPanel() {
        setLayout(new BorderLayout());

        String[] columnNames = {"Nombre", "Dirección", "Teléfono", "Sitio Web"};
        Object[][] data = {
            {"Aromas Colombianos", "Carrera 4 # 7-62, Bogotá", "(601) 4567890", "www.aromascolombianos.com"},
            {"El sabor de cartagena", "Calle 8 # 9-34, Cartagena", "(601) 6543210", "www.elsabordecartagena.com"},
            {"La Cocina Antioqueña", "Avenida 25 # 19-81, Medellín", "(601) 6543210" ,"www.lacocinaantioqueña.com"},
            {"Mariscos del Caribe", "Calle 7 # 6-22, Barranquilla", "(601) 6543210" ," www.mariscosdelcaribe.com"},
            {"Sabores de Cali", "Carrera 10 # 11-55, Cali", "(601) 6543210" , "www.saboresdecali.com"}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JButton salirButton = new JButton("Salir");
        add(salirButton, BorderLayout.SOUTH);

        // Cambios en el botón de Salir
        salirButton.setBackground(new Color(255, 192, 203)); // Fondo color pastel
        salirButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y tamaño

        salirButton.addActionListener(e -> System.exit(0));
    }
}

class InformacionPanel extends JPanel {
    public InformacionPanel() {
        setLayout(new BorderLayout());

        JTextArea infoTextArea = new JTextArea("MasterChef Colombia es un popular programa de televisión que " +
                "destaca la cocina colombiana. El programa presenta a famosos de la farandula colombiana compitiendo por el título " +
                "de MasterChef. El jurado está compuesto por tres chefs expertos que evalúan las habilidades culinarias " +
                "de los concursantes. La ultima ganadora del concurso fue Carolina Acevedo para la edicion 2023 bajo muchas polemicas en redes sociales");
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setLineWrap(true);
        infoTextArea.setCaretPosition(0);
        infoTextArea.setOpaque(false);
        infoTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        add(scrollPane, BorderLayout.CENTER);

        JButton salirButton = new JButton("Salir");
        add(salirButton, BorderLayout.SOUTH);

        // Cambios en el botón de Salir
        salirButton.setBackground(new Color(255, 192, 203)); // Fondo color pastel
        salirButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y tamaño

        salirButton.addActionListener(e -> System.exit(0));
    }
}

class CreditosPanel extends JPanel {
    public CreditosPanel() {
        setLayout(new GridLayout(4, 1));

        JLabel creditsLabel = new JLabel("Créditos");
        add(creditsLabel);

        JLabel infoLabel = new JLabel("Harol Hernan Torres | Politecnico Internacional | Harol.Torres@pi.edu.co | 2023");
        add(infoLabel);

        JButton salirButton = new JButton("Salir");
        add(salirButton);

        // Cambios en el botón de Salir
        salirButton.setBackground(new Color(255, 192, 203)); // Fondo color pastel
        salirButton.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente y tamaño

        salirButton.addActionListener(e -> System.exit(0));
    }
}
