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

public class ListaDeProductos extends JPanel{
    private JLabel title;
    private JPanel panelLista;
    public JPanel panelMain;

    public ListaDeProductos(Inventario inventario, Carrito carrito) {
        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());

        title = new JLabel("Productos");
        panelMain.add(title, BorderLayout.NORTH);

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

                    carrito.agregarProducto(new ProductoEnCarrito(producto,1 ));

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
        panelMain.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }
}
