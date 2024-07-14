package ar.unrn.interfazGrafica;

import ar.unrn.Carrito;
import ar.unrn.Inventario;
import ar.unrn.Producto;
import ar.unrn.estructura.ClientesPremium;
import ar.unrn.strategy.DescuentoStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SupermarketAppGui extends JFrame {

    private static ArrayList<DescuentoStrategy> descuentosList = new ArrayList<>();
    private static ClientesPremium clientes = new ClientesPremium();
    protected Inventario inventario = new Inventario();
    protected Carrito carrito = new Carrito();

    public JPanel panelViewContent;

    public SupermarketAppGui() {
        setTitle("Supermarket");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Panel de botones
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));

        JButton clienteButton = new JButton("Ingresar como Cliente");
        JButton adminButton = new JButton("Ingresar como Administrador");
        JButton exitButton = new JButton("Salir");

        buttonPanel.add(clienteButton);
        buttonPanel.add(adminButton);
        buttonPanel.add(exitButton);

        // Panel de contenido
        panelViewContent = new JPanel(new BorderLayout());
        panelViewContent.setBackground(Color.black);
        panelViewContent.setPreferredSize(new Dimension(800, 500));

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(panelViewContent, BorderLayout.CENTER);

        // Agregar productos de ejemplo al inventario
        inventario.agregarProducto(new Producto(20, "pan", "panaderia"), 20);
        inventario.agregarProducto(new Producto(20, "jamon", "fiambre"), 20);
        inventario.agregarProducto(new Producto(20, "queso", "fiambre"), 20);

        showHome();

        clienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMenuCliente();
            }
        });

        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarMenuAdministrador();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(mainPanel);
    }

    private void mostrarMenuCliente() {
        // Aquí puedes implementar el menú del cliente
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AccionClienteGUI clienteGUI = new AccionClienteGUI(inventario, carrito,
                        clientes, descuentosList, SupermarketAppGui.this);
                showPanel(clienteGUI);
            }
        });
    }

    private void mostrarMenuAdministrador() {
        String password = JOptionPane.showInputDialog(this, "Ingrese la clave de administrador:");
        if (password != null && esAdministrador(password)) {
            // Aquí puedes implementar el menú del administrador
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    AccionAdministradorGUI administradorGUI =
                            new AccionAdministradorGUI(inventario, clientes,
                                    descuentosList, SupermarketAppGui.this);
                    showPanel(administradorGUI);
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Clave incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean esAdministrador(String otraContra) {
        String password = "1234";
        return otraContra != null && otraContra.equals(password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SupermarketAppGui().setVisible(true);
            }
        });
    }

    public void showPanel(JPanel panel) {
        panelViewContent.removeAll();
        panelViewContent.add(panel, BorderLayout.CENTER);
        panelViewContent.revalidate();
        panelViewContent.repaint();
    }

    public void showHome() {
        showPanel(new AccionClienteGUI(inventario, carrito, clientes, descuentosList,
                SupermarketAppGui.this));
    }

    public void showHomeAdmin() {
        showPanel(new AccionAdministradorGUI(inventario, clientes, descuentosList,
                SupermarketAppGui.this));
    }
}
