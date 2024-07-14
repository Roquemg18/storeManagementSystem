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

public class AccionClienteGUI extends JPanel{

    public AccionClienteGUI(Inventario inventario, Carrito carrito,
                            ClientesPremium clientes, ArrayList<DescuentoStrategy> descuentosList, SupermarketAppGui supermarketAppGui) {

        setLayout(new GridLayout(3, 1));

        JButton loginPremiumButton = new JButton("Login Cliente Premium");
        JButton crearTicketButton = new JButton("Crear Ticket");
        JButton comprarButton = new JButton("Comprar Producto");

        loginPremiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                supermarketAppGui.showPanel(new LoginPremiumGUI(clientes,
                        descuentosList,supermarketAppGui));
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
                        clientes,descuentosList, supermarketAppGui));
            }
        });

        add(loginPremiumButton);
        add(crearTicketButton);
        add(comprarButton);
    }
}