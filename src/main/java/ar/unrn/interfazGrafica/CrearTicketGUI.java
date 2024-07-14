package ar.unrn.interfazGrafica;

import ar.unrn.Carrito;
import ar.unrn.Inventario;
import ar.unrn.estructura.ClientesPremium;
import ar.unrn.strategy.DescuentoStrategy;
import ar.unrn.strategy.Venta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CrearTicketGUI extends JPanel {

    public JPanel panelMain;

    private JLabel title;

    private JTextArea informacion;

    private JButton buttonFinal;

    public CrearTicketGUI(Inventario inventario, Carrito carrito, ClientesPremium clientes,
                          ArrayList<DescuentoStrategy> descuentosList) {

        panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        title = new JLabel("Ticket de superMarket");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        panelMain.add(title, gbc);

        Venta reporte = new Venta(inventario, carrito);
        for (DescuentoStrategy descuento : descuentosList) {
            reporte.fijarEstrategia(descuento);
        }
        String ticket = reporte.procesarVenta();

        informacion = new JTextArea(ticket);
        informacion.setEditable(false);
        informacion.setLineWrap(true);
        informacion.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(informacion);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.8;
        panelMain.add(scrollPane, gbc);

        buttonFinal = new JButton("Cerrar ticket");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        panelMain.add(buttonFinal, gbc);

        buttonFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
            }
        });
    }
}
