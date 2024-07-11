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
                                  ArrayList<DescuentoStrategy> descuentosList) {
        setLayout(new GridLayout(4, 1));

        JLabel adminLabel = new JLabel("Interfaz de Administrador", SwingConstants.CENTER);
        add(adminLabel);

        JButton crearProductoButton = new JButton("Crear Producto");
        crearProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearProduct(inventario);
            }
        });
        add(crearProductoButton);

        JButton crearDescuentoButton = new JButton("Crear Descuento");
        crearDescuentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearDescuento(descuentosList);
            }
        });
        add(crearDescuentoButton);

        JButton crearClientePremiumButton = new JButton("Crear Cliente Premium");
        crearClientePremiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearClientePremium(clientes);
            }
        });
        add(crearClientePremiumButton);
    }

    private void crearClientePremium ( ClientesPremium clientes) {
        JFrame frame = new JFrame("Crear Producto");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        InterfazCrearClientePremium interfaz = new InterfazCrearClientePremium(clientes
                ,frame);
        frame.add(interfaz.panelMain);

        frame.setVisible(true);

    }

    private void crearProduct(Inventario inventario) {
            JFrame frame = new JFrame("Crear Producto");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 300);

            InterfazCrearProducto interfaz = new InterfazCrearProducto(frame, inventario);
            frame.add(interfaz.getPanelMainCrearProducto());

            frame.setVisible(true);
    }

    private void crearDescuento(ArrayList<DescuentoStrategy> descuentosList) {
        JFrame frame = new JFrame("Crear descuento");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);

        InterfazCrearDescuento interfaz = new InterfazCrearDescuento(descuentosList);
        frame.add(interfaz.panelMainDes);

        frame.setVisible(true);
    }
}