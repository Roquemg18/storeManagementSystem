package ar.unrn.interfazGrafica.interfacesDeCreacion;

import ar.unrn.Inventario;
import ar.unrn.Producto;
import ar.unrn.interfazGrafica.SupermarketAppGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearProducto extends JPanel {

    private JPanel panelCrearProducto;
    private JLabel title;
    private JTextField inputNombre, inputTipo, inputPrecio, inputStock;
    private JLabel labelNombre, labelTipo, labelPrecio, labelStock;
    private JButton buttonCrearProducto;

    public InterfazCrearProducto(Inventario inventario, SupermarketAppGui supermarketAppGui) {
        setLayout(new BorderLayout());

        // Panel del título
        JPanel titlePanel = new JPanel();
        title = new JLabel("Crear Producto", SwingConstants.CENTER);
        titlePanel.add(title);
        titlePanel.setPreferredSize(new Dimension(getWidth(), 40));
        add(titlePanel, BorderLayout.NORTH);

        // Panel del formulario
        panelCrearProducto = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;

        labelNombre = new JLabel("Nombre del producto", SwingConstants.LEFT);
        labelTipo = new JLabel("Tipo del producto", SwingConstants.LEFT);
        labelPrecio = new JLabel("Precio del producto", SwingConstants.LEFT);
        labelStock = new JLabel("Stock del producto", SwingConstants.LEFT);

        inputNombre = createStyledTextField();
        inputTipo = createStyledTextField();
        inputPrecio = createStyledTextField();
        inputStock = createStyledTextField();

        // Añadir componentes al panel del formulario
        gbc.gridy = 0; panelCrearProducto.add(labelNombre, gbc);
        gbc.gridy = 1; panelCrearProducto.add(inputNombre, gbc);
        gbc.gridy = 2; panelCrearProducto.add(labelTipo, gbc);
        gbc.gridy = 3; panelCrearProducto.add(inputTipo, gbc);
        gbc.gridy = 4; panelCrearProducto.add(labelPrecio, gbc);
        gbc.gridy = 5; panelCrearProducto.add(inputPrecio, gbc);
        gbc.gridy = 6; panelCrearProducto.add(labelStock, gbc);
        gbc.gridy = 7; panelCrearProducto.add(inputStock, gbc);

        // Añadir un panel de relleno para empujar el contenido hacia arriba
        gbc.gridy = 8;
        gbc.weighty = 1.0;
        panelCrearProducto.add(Box.createVerticalGlue(), gbc);

        add(panelCrearProducto, BorderLayout.CENTER);

        // Panel del botón
        JPanel buttonPanel = new JPanel();
        buttonCrearProducto = new JButton("Crear Producto");
        buttonPanel.add(buttonCrearProducto);
        buttonPanel.setPreferredSize(new Dimension(getWidth(), 40));
        add(buttonPanel, BorderLayout.SOUTH);

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
                    JOptionPane.showMessageDialog(null, "Producto creado exitosamente");
                    supermarketAppGui.showHomeAdmin();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores válidos.");
                }
            }
        });
    }

    private JTextField createStyledTextField() {
        JTextField textField = new JTextField();
        int width = 400;
        textField.setPreferredSize(new Dimension(width, 30));
        textField.setMaximumSize(new Dimension(width, 30));
        return textField;
    }
}