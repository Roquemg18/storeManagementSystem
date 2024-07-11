package ar.unrn.interfazGrafica.interfacesDeCreacion;

import ar.unrn.strategy.DescuentoPorVolumen;
import ar.unrn.strategy.DescuentoPromocional;
import ar.unrn.strategy.DescuentoStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfazCrearDescuento {
    private JLabel titleDescuento;
    private JButton buttonDesVolumen;
    private JButton buttonDesPromocional;
    public JPanel panelMainDes;

    public InterfazCrearDescuento(ArrayList<DescuentoStrategy> descuentosList) {
        panelMainDes = new JPanel();
        panelMainDes.setLayout(new GridLayout(8, 1, 5, 5));

        titleDescuento = new JLabel("Lista de descuentos");
        buttonDesVolumen = new JButton("Crear descuento por volument");
        buttonDesPromocional = new JButton("crear descuento promocional");


        panelMainDes.add(titleDescuento);
        panelMainDes.add(buttonDesVolumen);
        panelMainDes.add(buttonDesPromocional);


        buttonDesVolumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crear Producto");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);

                InterfazDescuentoPorVolumen interfaz =
                        new InterfazDescuentoPorVolumen(descuentosList,frame);
                frame.add(interfaz.panelMain);

                frame.setVisible(true);
            }
        });
        buttonDesPromocional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Crear Producto");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(400, 300);

                InterfazDescuentoPromosional interfaz =
                        new InterfazDescuentoPromosional(descuentosList, frame);
                frame.add(interfaz.panelMain);

                frame.setVisible(true);
            }
        });
    }


    public static class InterfazDescuentoPorVolumen {
        private JLabel titleDes;
        private JLabel labelCantidad;
        private JTextField inputCantidad;
        private JLabel labelPorcentaje;
        public JPanel panelMain;
        private JButton buttonDesVolumen;
        private JTextField inputPorcentaje;

        public InterfazDescuentoPorVolumen(ArrayList<DescuentoStrategy> descuentosList,
         JFrame frame) {
            panelMain = new JPanel();
            panelMain.setLayout(new GridLayout(8, 1, 5, 5));
            titleDes = new JLabel("Descuento por Volumen");
            labelCantidad = new JLabel("Ingrese la cantidada minima para el descuento por volumen ");
            labelPorcentaje = new JLabel("Ingrese el porcentaje de descuento");
            inputCantidad = new JTextField(15);
            inputPorcentaje = new JTextField(15);
            buttonDesVolumen = new JButton("crear descuento por volument");

            panelMain.add(titleDes);
            panelMain.add(labelCantidad);
            panelMain.add(inputCantidad);
            panelMain.add(labelPorcentaje);
            panelMain.add(inputPorcentaje);
            panelMain.add(buttonDesVolumen);


            buttonDesVolumen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int cantidad = Integer.parseInt(inputCantidad.getText());
                    double porcentaje = Double.parseDouble(inputPorcentaje.getText());

                    DescuentoPorVolumen desVolumen = new DescuentoPorVolumen(cantidad,porcentaje);
                    descuentosList.add(desVolumen);

                    JOptionPane.showMessageDialog(panelMain, "Cliente creado exitosamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    frame.dispose();

                }
            });
        }
    }

    public static class InterfazDescuentoPromosional {
        private JLabel titleDes;
        private JLabel labelTipo;
        private JTextField inputTipo;
        private JLabel labelPorcentaje;
        public JPanel panelMain;
        private JButton buttonDesPromocional;
        private JTextField inputPorcentaje;

        public InterfazDescuentoPromosional(ArrayList<DescuentoStrategy> descuentosList
                , JFrame frame) {
            panelMain = new JPanel();
            panelMain.setLayout(new GridLayout(8, 1, 5, 5));

            titleDes = new JLabel("Descuento por Volumen");
            labelTipo = new JLabel("Ingrese el tipo del producto ");
            labelPorcentaje = new JLabel("Ingrese el porcentaje de descuento");
            inputTipo = new JTextField(15);
            inputPorcentaje = new JTextField(15);
            buttonDesPromocional = new JButton("crear descuento promocional");

            panelMain.add(titleDes);
            panelMain.add(labelTipo);
            panelMain.add(inputTipo);
            panelMain.add(labelPorcentaje);
            panelMain.add(inputPorcentaje);
            panelMain.add(buttonDesPromocional);

            buttonDesPromocional.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String tipo = inputTipo.getText();
                    double porcentaje = Double.parseDouble(inputPorcentaje.getText());

                    DescuentoPromocional desPromociona = new DescuentoPromocional(tipo,
                            porcentaje);
                    descuentosList.add(desPromociona);
                    JOptionPane.showMessageDialog(panelMain, "Cliente creado exitosamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    frame.dispose();

                }
            });
        }
    }
}
