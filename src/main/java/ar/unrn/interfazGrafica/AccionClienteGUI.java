package ar.unrn.interfazGrafica;

import ar.unrn.Carrito;
import ar.unrn.Inventario;
import ar.unrn.estructura.ClientesPremium;
import ar.unrn.strategy.DescuentoStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccionClienteGUI extends JPanel {

    public AccionClienteGUI(Inventario inventario, Carrito carrito,
                            ClientesPremium clientes, ArrayList<DescuentoStrategy> descuentosList, SupermarketAppGui supermarketAppGui) {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Agregar el título
        JLabel titleLabel = new JLabel("Acciones Cliente", SwingConstants.CENTER);
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 30));
        add(titleLabel, gbc);

        // Agregar espacio después del título
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);

        JButton loginPremiumButton = new JButton("Login Cliente Premium");
        JButton crearTicketButton = new JButton("Crear Ticket");
        JButton comprarButton = new JButton("Comprar Producto");

        // Configurar el tamaño de los botones
        Dimension buttonSize = new Dimension(300, 50);
        loginPremiumButton.setPreferredSize(buttonSize);
        crearTicketButton.setPreferredSize(buttonSize);
        comprarButton.setPreferredSize(buttonSize);

        loginPremiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new LoginPremiumGUI(clientes,
                        descuentosList, supermarketAppGui));
            }
        });

        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new ListaDeProductos(inventario, carrito,
                        supermarketAppGui));
            }
        });

        crearTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new CrearTicketGUI(inventario, carrito,
                        clientes, descuentosList, supermarketAppGui));
            }
        });

        add(loginPremiumButton, gbc);
        add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        add(crearTicketButton, gbc);
        add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        add(comprarButton, gbc);
    }
}