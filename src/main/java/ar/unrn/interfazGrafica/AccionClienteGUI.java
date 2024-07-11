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
    private JLabel title;
    private JPanel panelLista;
    public JPanel panelMain;

    public AccionClienteGUI(Inventario inventario, Carrito carrito, ClientesPremium clientes,
                            ArrayList<DescuentoStrategy> descuentosList ) {
        setLayout(new GridLayout(3, 1));

        JLabel clienteLabel = new JLabel("Interfaz de Cliente", SwingConstants.CENTER);
        add(clienteLabel);


        JButton loginPremium = new JButton("logearse como premium");
        loginPremium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("login cliente premium");

                LoginPremiumGUI login = new LoginPremiumGUI(clientes, descuentosList, frame);

                frame.setContentPane(login.panelMain);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setVisible(true);
            }
        });
        add(loginPremium);

        JButton comprarButton = new JButton("Comprar Producto");
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Lista de Productos");
                ListaDeProductos listaDeProductos = new ListaDeProductos(inventario,carrito);
                frame.setContentPane(listaDeProductos.getPanelMain());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setVisible(true);
            }
        });
        add(comprarButton);

        JButton generarTicketButton = new JButton("Generar Ticket");
        generarTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para generar ticket
                JFrame frame = new JFrame("Ticket");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 800);

                CrearTicketGUI ticketGUI = new CrearTicketGUI(inventario, carrito,
                        clientes, descuentosList,frame);
                frame.add(ticketGUI.panelMain);

                frame.setVisible(true);
            }
        });
        add(generarTicketButton);
    }
}
