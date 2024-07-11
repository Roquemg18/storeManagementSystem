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

    public SupermarketAppGui() {
        setTitle("Supermarket");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JButton clienteButton = new JButton("Ingresar como Cliente");
        JButton adminButton = new JButton("Ingresar como Administrador");
        JButton exitButton = new JButton("Salir");

        panel.add(clienteButton);
        panel.add(adminButton);
        panel.add(exitButton);

        inventario.agregarProducto(new Producto(20, "pan", "panaderia"), 20);
        inventario.agregarProducto(new Producto(20, "jamon", "fiambre"), 20);
        inventario.agregarProducto(new Producto(20, "queso", "fiambre"), 20);


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

        add(panel);
    }

    private void mostrarMenuCliente() {
        // Aquí puedes implementar el menú del cliente
        //JOptionPane.showMessageDialog(this, "Menú de Cliente");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("mi lista");
                AccionClienteGUI clienteGUI = new AccionClienteGUI(inventario, carrito,
                        clientes,descuentosList);

                frame.setContentPane(clienteGUI);

                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setSize(500, 300);
                frame.setVisible(true);
            }
        });
    }

    private void mostrarMenuAdministrador() {
        String password = JOptionPane.showInputDialog(this, "Ingrese la clave de " +
                "administrador:");
        if (password != null && esAdministrador(password)) {
            // Aquí puedes implementar el menú del administrador
            //JOptionPane.showMessageDialog(this, "Menú de Administrador");
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame frame = new JFrame("mi lista");
                    AccionAdministradorGUI administradorGUI =
                            new AccionAdministradorGUI(inventario, clientes, descuentosList);

                    frame.setContentPane(administradorGUI);

                    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setSize(500, 300);
                    frame.setVisible(true);
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Clave incorrecta", "Error",
                    JOptionPane.ERROR_MESSAGE);
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
}
