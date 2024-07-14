package ar.unrn.interfazGrafica;

import ar.unrn.Carrito;
import ar.unrn.Inventario;
import ar.unrn.estructura.ClientesPremium;
import ar.unrn.strategy.DescuentoStrategy;
import ar.unrn.strategy.Venta;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CrearTicketGUI extends JPanel {

    private JLabel title;
    private JTextPane informacion;
    private JButton buttonFinal;

    public CrearTicketGUI(Inventario inventario, Carrito carrito, ClientesPremium clientes,
                          ArrayList<DescuentoStrategy> descuentosList,
                          SupermarketAppGui supermarketAppGui) {

        setLayout(new BorderLayout());

        // Panel para el título
        JPanel titlePanel = new JPanel();
        title = new JLabel("Ticket de superMarket");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(title);
        titlePanel.setPreferredSize(new Dimension(getWidth(), 30));
        add(titlePanel, BorderLayout.NORTH);

        // Area del ticket
        Venta reporte = new Venta(inventario, carrito);
        for (DescuentoStrategy descuento : descuentosList) {
            reporte.fijarEstrategia(descuento);
        }
        String ticket = formatearTicket(reporte.procesarVenta());

        informacion = new JTextPane();
        informacion.setEditable(false);
        informacion.setText(ticket);

        // Centrar el texto
        StyledDocument doc = informacion.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        JScrollPane scrollPane = new JScrollPane(informacion);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para el botón de finalizar
        JPanel buttonPanel = new JPanel();
        buttonFinal = new JButton("Cerrar ticket");
        buttonFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent,
                        "Compra realizada exitosamente \n vuelva pronto",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                supermarketAppGui.showHome();
            }
        });
        buttonPanel.add(buttonFinal);
        buttonPanel.setPreferredSize(new Dimension(getWidth(), 40));
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private String formatearTicket(String ticket) {
        DecimalFormat df = new DecimalFormat("#.##");
        String[] lines = ticket.split("\n");
        StringBuilder formattedTicket = new StringBuilder();

        for (String line : lines) {
            if (line.contains(":")) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    try {
                        double value = Double.parseDouble(parts[1].trim());
                        formattedTicket.append(parts[0]).append(": ").append(df.format(value)).append("\n");
                    } catch (NumberFormatException e) {
                        formattedTicket.append(line).append("\n");
                    }
                } else {
                    formattedTicket.append(line).append("\n");
                }
            } else {
                formattedTicket.append(line).append("\n");
            }
        }

        return formattedTicket.toString();
    }
}