package ar.unrn.interfazGrafica;

import ar.unrn.Inventario;
import ar.unrn.estructura.ClientesPremium;
import ar.unrn.interfazGrafica.interfacesDeCreacion.InterfazCrearClientePremium;
import ar.unrn.interfazGrafica.interfacesDeCreacion.InterfazCrearDescuento;
import ar.unrn.interfazGrafica.interfacesDeCreacion.InterfazCrearProducto;
import ar.unrn.strategy.DescuentoStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccionAdministradorGUI extends JPanel {

    public AccionAdministradorGUI(Inventario inventario, ClientesPremium clientes,
                                  ArrayList<DescuentoStrategy> descuentosList,
                                  SupermarketAppGui supermarketAppGui) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Agregar el título
        JLabel titleLabel = new JLabel("Acciones Administrador", SwingConstants.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 30));
        add(titleLabel, gbc);

        // Agregar espacio después del título
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);

        JButton crearProductoButton = new JButton("Crear Producto");
        JButton crearDescuentoButton = new JButton("Crear Descuento");
        JButton crearClientePremiumButton = new JButton("Crear Cliente Premium");

        // Configurar el tamaño de los botones
        Dimension buttonSize = new Dimension(300, 50);
        crearProductoButton.setPreferredSize(buttonSize);
        crearDescuentoButton.setPreferredSize(buttonSize);
        crearClientePremiumButton.setPreferredSize(buttonSize);

        crearProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new InterfazCrearProducto(inventario, supermarketAppGui));
            }
        });

        crearDescuentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new InterfazCrearDescuento(descuentosList, supermarketAppGui));
            }
        });

        crearClientePremiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new InterfazCrearClientePremium(clientes, supermarketAppGui));
            }
        });

        add(crearProductoButton, gbc);
        add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        add(crearDescuentoButton, gbc);
        add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        add(crearClientePremiumButton, gbc);
    }
}