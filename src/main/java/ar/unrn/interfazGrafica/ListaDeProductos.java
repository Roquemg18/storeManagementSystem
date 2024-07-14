package ar.unrn.interfazGrafica;


import ar.unrn.Carrito;
import ar.unrn.Inventario;
import ar.unrn.Producto;
import ar.unrn.ProductoEnCarrito;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaDeProductos extends JPanel {
    private JLabel title;
    private JPanel panelLista;
    private JButton finalizarCompraButton;

    public ListaDeProductos(Inventario inventario, Carrito carrito, SupermarketAppGui supermarketAppGui) {
        setLayout(new BorderLayout());

        // Panel para el título
        JPanel titlePanel = new JPanel();
        title = new JLabel("Productos");
        titlePanel.add(title);
        titlePanel.setPreferredSize(new Dimension(getWidth(), 30)); // Ajusta la altura según necesites
        add(titlePanel, BorderLayout.NORTH);

        // Panel para la lista de productos
        panelLista = new JPanel();
        panelLista.setLayout(new GridLayout(0, 1));

        ArrayList<Producto> productos = inventario.obtenerProductos();

        for (Producto producto : productos) {
            JPanel panelProducto = new JPanel();
            panelProducto.setLayout(new FlowLayout());

            JLabel nombre = new JLabel(producto.getNombre());
            JLabel tipo = new JLabel(producto.getTipo());
            JLabel precio = new JLabel(String.valueOf(producto.getPrecio()));
            JLabel stock = new JLabel(String.valueOf(producto.getStock()));
            JButton comprarButton = new JButton("Comprar");

            comprarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carrito.agregarProducto(new ProductoEnCarrito(producto, 1));
                }
            });

            panelProducto.add(nombre);
            panelProducto.add(tipo);
            panelProducto.add(precio);
            panelProducto.add(stock);
            panelProducto.add(comprarButton);

            panelLista.add(panelProducto);
        }

        JScrollPane scrollPane = new JScrollPane(panelLista);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para el botón de finalizar compra
        JPanel buttonPanel = new JPanel();
        finalizarCompraButton = new JButton("Finalizar compra");
        finalizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent,
                        "Productos agregados correctamente al carrito",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                supermarketAppGui.showHome();
            }
        });
        buttonPanel.add(finalizarCompraButton);
        buttonPanel.setPreferredSize(new Dimension(getWidth(), 40)); // Ajusta la altura según necesites
        add(buttonPanel, BorderLayout.SOUTH);
    }
}