package ar.unrn.interfazGrafica.interfacesDeCreacion;

import ar.unrn.Inventario;
import ar.unrn.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearProducto {
    private JPanel panelMainCrearProducto;
    private JPanel panelCrearProducto;
    private JLabel title;
    private JTextField inputNombre;
    private JTextField inputTipo;
    private JTextField inputPrecio;
    private JTextField inputStock;
    private JLabel labelNombre;
    private JLabel labelTipo;
    private JLabel labelPrecio;
    private JLabel labelStock;
    private JButton buttonCrearProducto;

    public InterfazCrearProducto(JFrame frame, Inventario inventario) {
        panelMainCrearProducto = new JPanel();
        panelMainCrearProducto.setLayout(new BorderLayout());

        panelCrearProducto = new JPanel();
        panelCrearProducto.setLayout(new GridLayout(8, 1, 5, 5)); // 8 filas, 1 columna, 5px de espacio horizontal y vertical

        title = new JLabel("Crear Producto", SwingConstants.CENTER);

        inputNombre = new JTextField(15);
        inputTipo = new JTextField(15);
        inputPrecio = new JTextField(15);
        inputStock = new JTextField(15);

        labelNombre = new JLabel("Nombre del producto");
        labelTipo = new JLabel("Tipo del producto");
        labelPrecio = new JLabel("Precio del producto");
        labelStock = new JLabel("Stock del producto");

        buttonCrearProducto = new JButton("Crear Producto");

        panelCrearProducto.add(labelNombre);
        panelCrearProducto.add(inputNombre);
        panelCrearProducto.add(labelTipo);
        panelCrearProducto.add(inputTipo);
        panelCrearProducto.add(labelPrecio);
        panelCrearProducto.add(inputPrecio);
        panelCrearProducto.add(labelStock);
        panelCrearProducto.add(inputStock);

        panelMainCrearProducto.add(title, BorderLayout.NORTH);
        panelMainCrearProducto.add(panelCrearProducto, BorderLayout.CENTER);
        panelMainCrearProducto.add(buttonCrearProducto, BorderLayout.SOUTH);

        buttonCrearProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = inputNombre.getText();
                    String tipo = inputTipo.getText();
                    double precio = Double.parseDouble(inputPrecio.getText());
                    int stock = Integer.parseInt(inputStock.getText());

                    Producto producto = new Producto(precio, nombre, tipo);
                    inventario.agregarProducto(producto);
                    inventario.aumentarCantidad(producto, stock);
                    JOptionPane.showMessageDialog(null, "producto creado exitosamente");
                    // Cerrar la ventana
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos.");
                }
            }
        });
    }

    public JPanel getPanelMainCrearProducto() {
        return panelMainCrearProducto;
    }


}
