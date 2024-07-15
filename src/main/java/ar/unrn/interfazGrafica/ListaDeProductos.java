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
        JPanel titlePanel = new JPanel(new BorderLayout());
        title = new JLabel("Productos", SwingConstants.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 18));
        titlePanel.add(title, BorderLayout.NORTH);

        // Label para describir las columnas
        JPanel descriptionPanel = new JPanel(new GridLayout(1, 6, 10, 0));
        descriptionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        descriptionPanel.add(new JLabel("Nombre", SwingConstants.CENTER));
        descriptionPanel.add(new JLabel("Tipo", SwingConstants.CENTER));
        descriptionPanel.add(new JLabel("Precio", SwingConstants.CENTER));
        descriptionPanel.add(new JLabel("Stock", SwingConstants.CENTER));
        descriptionPanel.add(new JLabel("Cantidad", SwingConstants.CENTER));
        descriptionPanel.add(new JLabel("Acción", SwingConstants.CENTER));
        titlePanel.add(descriptionPanel, BorderLayout.SOUTH);

        titlePanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        add(titlePanel, BorderLayout.NORTH);

        // Panel para la lista de productos
        panelLista = new JPanel();
        panelLista.setLayout(new GridLayout(0, 1, 0, 10));
        panelLista.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelLista.setPreferredSize(new Dimension(60, 10));

        ArrayList<Producto> productos = inventario.obtenerProductos();

            for (Producto producto : productos) {
                JPanel panelProducto = new JPanel();
                panelProducto.setLayout(new BoxLayout(panelProducto, BoxLayout.X_AXIS));
                panelProducto.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

                JLabel nombre = new JLabel(producto.getNombre());
                JLabel tipo = new JLabel(producto.getTipo());
                JLabel precio = new JLabel(String.valueOf(producto.getPrecio()));
                JLabel stock = new JLabel(String.valueOf(producto.getStock()));

                SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, producto.getStock(), 1);
                JSpinner cantidadSpinner = new JSpinner(spinnerModel);
                cantidadSpinner.setMaximumSize(new Dimension(60, 25));
                cantidadSpinner.setPreferredSize(new Dimension(60, 25));

                JButton comprarButton = new JButton("Comprar");
                comprarButton.setMaximumSize(new Dimension(200, 25));
                comprarButton.setPreferredSize(new Dimension(200, 25));

                // ... (código del ActionListener sin cambios)

                // Configurar tamaños fijos para los componentes
                Dimension labelSize = new Dimension(100, 25);
                nombre.setPreferredSize(labelSize);
                tipo.setPreferredSize(labelSize);
                precio.setPreferredSize(labelSize);
                stock.setPreferredSize(labelSize);

                panelProducto.add(nombre);
                panelProducto.add(Box.createHorizontalStrut(10));
                panelProducto.add(tipo);
                panelProducto.add(Box.createHorizontalStrut(10));
                panelProducto.add(precio);
                panelProducto.add(Box.createHorizontalStrut(10));
                panelProducto.add(stock);
                panelProducto.add(Box.createHorizontalStrut(10));
                panelProducto.add(cantidadSpinner);
                panelProducto.add(Box.createHorizontalStrut(10));
                panelProducto.add(comprarButton);
                panelProducto.add(Box.createHorizontalGlue());

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
                        "Compra finalizada. Gracias por su compra!",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                supermarketAppGui.showHome();
            }
        });
        buttonPanel.add(finalizarCompraButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(buttonPanel, BorderLayout.SOUTH);
    }
}