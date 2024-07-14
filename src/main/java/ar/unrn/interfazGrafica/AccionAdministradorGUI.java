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
        setLayout(new GridLayout(4, 1));

        JLabel adminLabel = new JLabel("Interfaz de Administrador", SwingConstants.CENTER);
        add(adminLabel);

        JButton crearProductoButton = new JButton("Crear Producto");
        crearProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new InterfazCrearProducto(inventario, supermarketAppGui));

            }
        });
        add(crearProductoButton);

        JButton crearDescuentoButton = new JButton("Crear Descuento");
        crearDescuentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                supermarketAppGui.showPanel(new InterfazCrearDescuento(descuentosList, supermarketAppGui));
            }
        });
        add(crearDescuentoButton);

        JButton crearClientePremiumButton = new JButton("Crear Cliente Premium");
        crearClientePremiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new InterfazCrearClientePremium(clientes,
                 supermarketAppGui       ));
            }
        });
        add(crearClientePremiumButton);
    }


}