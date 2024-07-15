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

public class InterfazCrearDescuento extends JPanel {
    private JLabel titleDescuento;
    private JButton buttonDesVolumen;
    private JButton buttonDesPromocional;

    public InterfazCrearDescuento(ArrayList<DescuentoStrategy> descuentosList,
                                  SupermarketAppGui supermarketAppGui) {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        titleDescuento = new JLabel("Lista de descuentos", SwingConstants.CENTER);
        titleDescuento.setFont(new Font("Arial", Font.BOLD, 20));

        buttonDesVolumen = new JButton("Crear descuento por volumen");
        buttonDesVolumen.setPreferredSize(new Dimension(280, 30));

        buttonDesPromocional = new JButton("Crear descuento promocional");
        buttonDesPromocional.setPreferredSize(new Dimension(280, 30));

        add(titleDescuento, gbc);
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);
        add(buttonDesVolumen, gbc);
        add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        add(buttonDesPromocional, gbc);

        buttonDesVolumen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new InterfazDescuentoPorVolumen(descuentosList, supermarketAppGui));
            }
        });

        buttonDesPromocional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supermarketAppGui.showPanel(new InterfazDescuentoPromocional(descuentosList, supermarketAppGui));
            }
        });
    }



    public static class InterfazDescuentoPorVolumen extends JPanel {
        private JLabel titleDes;
        private JLabel labelCantidad;
        private JTextField inputCantidad;
        private JLabel labelPorcentaje;
        private JButton buttonDesVolumen;
        private JTextField inputPorcentaje;

        public InterfazDescuentoPorVolumen(ArrayList<DescuentoStrategy> descuentosList,
                                           SupermarketAppGui supermarketAppGui) {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 5, 5);

            titleDes = new JLabel("Descuento por Volumen", SwingConstants.CENTER);
            titleDes.setFont(new Font(titleDes.getFont().getName(), Font.BOLD, 30));

            labelCantidad = new JLabel("Ingrese la cantidad mínima para el descuento por volumen", SwingConstants.CENTER);
            labelPorcentaje = new JLabel("Ingrese el porcentaje de descuento", SwingConstants.CENTER);

            inputCantidad = new JTextField();
            inputCantidad.setPreferredSize(new Dimension(200, 40));

            inputPorcentaje = new JTextField();
            inputPorcentaje.setPreferredSize(new Dimension(200, 40));

            buttonDesVolumen = new JButton("Crear descuento por volumen");

            add(titleDes, gbc);
            add(Box.createRigidArea(new Dimension(0, 20)), gbc);
            add(labelCantidad, gbc);
            add(inputCantidad, gbc);
            add(labelPorcentaje, gbc);
            add(inputPorcentaje, gbc);
            add(Box.createRigidArea(new Dimension(0, 20)), gbc);
            add(buttonDesVolumen, gbc);


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

    public static class InterfazDescuentoPromocional extends JPanel {
        private JLabel titleDes;
        private JLabel labelTipo;
        private JTextField inputTipo;
        private JLabel labelPorcentaje;
        private JButton buttonDesPromocional;
        private JTextField inputPorcentaje;

        public InterfazDescuentoPromocional(ArrayList<DescuentoStrategy> descuentosList,
                                            SupermarketAppGui supermarketAppGui) {

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 5, 5);

            titleDes = new JLabel("Descuento Promocional", SwingConstants.CENTER);
            titleDes.setFont(new Font(titleDes.getFont().getName(), Font.BOLD, 30));

            labelTipo = new JLabel("Ingrese el tipo del producto", SwingConstants.CENTER);
            labelPorcentaje = new JLabel("Ingrese el porcentaje de descuento", SwingConstants.CENTER);

            inputTipo = new JTextField();
            inputTipo.setPreferredSize(new Dimension(200, 40));

            inputPorcentaje = new JTextField();
            inputPorcentaje.setPreferredSize(new Dimension(200, 40));

            buttonDesPromocional = new JButton("Crear descuento promocional");

            add(titleDes, gbc);
            add(Box.createRigidArea(new Dimension(0, 20)), gbc);
            add(labelTipo, gbc);
            add(inputTipo, gbc);
            add(labelPorcentaje, gbc);
            add(inputPorcentaje, gbc);
            add(Box.createRigidArea(new Dimension(0, 20)), gbc);
            add(buttonDesPromocional, gbc);

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
