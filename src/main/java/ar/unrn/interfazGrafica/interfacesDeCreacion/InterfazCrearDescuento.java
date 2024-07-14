package ar.unrn.interfazGrafica.interfacesDeCreacion;

import ar.unrn.interfazGrafica.SupermarketAppGui;
import ar.unrn.strategy.DescuentoPorVolumen;
import ar.unrn.strategy.DescuentoPromocional;
import ar.unrn.strategy.DescuentoStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfazCrearDescuento extends JPanel{
    private JLabel titleDescuento;
    private JButton buttonDesVolumen;
    private JButton buttonDesPromocional;

    public InterfazCrearDescuento(ArrayList<DescuentoStrategy> descuentosList,
                                  SupermarketAppGui supermarketAppGui) {

        setLayout(new GridLayout(8, 1, 5, 5));

        titleDescuento = new JLabel("Lista de descuentos");
        buttonDesVolumen = new JButton("Crear descuento por volument");
        buttonDesPromocional = new JButton("crear descuento promocional");


        add(titleDescuento);
        add(buttonDesVolumen);
        add(buttonDesPromocional);


        buttonDesVolumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               supermarketAppGui.showPanel(new InterfazDescuentoPorVolumen(descuentosList,supermarketAppGui));

            }
        });
        buttonDesPromocional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new InterfazDescuentoPromosional(descuentosList,
                        supermarketAppGui));
            }
        });
    }


    public static class InterfazDescuentoPorVolumen extends JPanel{
        private JLabel titleDes;
        private JLabel labelCantidad;
        private JTextField inputCantidad;
        private JLabel labelPorcentaje;
        private JButton buttonDesVolumen;
        private JTextField inputPorcentaje;

        public InterfazDescuentoPorVolumen(ArrayList<DescuentoStrategy> descuentosList,
                                           SupermarketAppGui supermarketAppGui) {

            setLayout(new GridLayout(8, 1, 5, 5));
            titleDes = new JLabel("Descuento por Volumen");
            labelCantidad = new JLabel("Ingrese la cantidada minima para el descuento por volumen ");
            labelPorcentaje = new JLabel("Ingrese el porcentaje de descuento");
            inputCantidad = new JTextField(15);
            inputPorcentaje = new JTextField(15);
            buttonDesVolumen = new JButton("crear descuento por volument");

            add(titleDes);
            add(labelCantidad);
            add(inputCantidad);
            add(labelPorcentaje);
            add(inputPorcentaje);
            add(buttonDesVolumen);


            buttonDesVolumen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int cantidad = Integer.parseInt(inputCantidad.getText());
                    double porcentaje = Double.parseDouble(inputPorcentaje.getText());

                    DescuentoPorVolumen desVolumen = new DescuentoPorVolumen(cantidad,porcentaje);
                    descuentosList.add(desVolumen);

                    JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent, "Cliente creado " +
                                    "exitosamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    supermarketAppGui.showHomeAdmin();

                }
            });
        }
    }

    public static class InterfazDescuentoPromosional extends JPanel{
        private JLabel titleDes;
        private JLabel labelTipo;
        private JTextField inputTipo;
        private JLabel labelPorcentaje;
        private JButton buttonDesPromocional;
        private JTextField inputPorcentaje;

        public InterfazDescuentoPromosional(ArrayList<DescuentoStrategy> descuentosList
                , SupermarketAppGui supermarketAppGui) {

            setLayout(new GridLayout(8, 1, 5, 5));

            titleDes = new JLabel("Descuento por Volumen");
            labelTipo = new JLabel("Ingrese el tipo del producto ");
            labelPorcentaje = new JLabel("Ingrese el porcentaje de descuento");
            inputTipo = new JTextField(15);
            inputPorcentaje = new JTextField(15);
            buttonDesPromocional = new JButton("crear descuento promocional");

            add(titleDes);
            add(labelTipo);
            add(inputTipo);
            add(labelPorcentaje);
            add(inputPorcentaje);
            add(buttonDesPromocional);

            buttonDesPromocional.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String tipo = inputTipo.getText();
                    double porcentaje = Double.parseDouble(inputPorcentaje.getText());

                    DescuentoPromocional desPromociona = new DescuentoPromocional(tipo,
                            porcentaje);
                    descuentosList.add(desPromociona);
                    JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent, "Cliente creado " +
                                    "exitosamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    supermarketAppGui.showHomeAdmin();

                }
            });
        }
    }
}
