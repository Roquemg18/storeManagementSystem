package ar.unrn.interfazGrafica.interfacesDeCreacion;

import ar.unrn.estructura.Cliente;
import ar.unrn.estructura.ClientesPremium;
import ar.unrn.interfazGrafica.SupermarketAppGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearClientePremium extends JPanel {
    private JLabel title;
    private JLabel labelNombre;
    private JTextField inputNombre;
    private JLabel labelDni;
    private JTextField inputDni;
    private JLabel labelEdad;
    private JTextField inputEdad;
    private JButton buttonCliente;

    public InterfazCrearClientePremium(ClientesPremium clientes, SupermarketAppGui supermarketAppGui) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        title = new JLabel("Crear cliente premium", SwingConstants.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 30));

        labelNombre = new JLabel("Ingrese nombre del cliente", SwingConstants.CENTER);
        labelDni = new JLabel("Ingrese el DNI del cliente", SwingConstants.CENTER);
        labelEdad = new JLabel("Ingrese la edad del cliente", SwingConstants.CENTER);

        inputNombre = new JTextField();
        inputNombre.setPreferredSize(new Dimension(200, 40));

        inputDni = new JTextField();
        inputDni.setPreferredSize(new Dimension(200, 40));

        inputEdad = new JTextField();
        inputEdad.setPreferredSize(new Dimension(200, 40));

        buttonCliente = new JButton("Crear cliente premium");

        add(title, gbc);
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);
        add(labelNombre, gbc);
        add(inputNombre, gbc);
        add(labelDni, gbc);
        add(inputDni, gbc);
        add(labelEdad, gbc);
        add(inputEdad, gbc);
        add(Box.createRigidArea(new Dimension(0, 20)), gbc);
        add(buttonCliente, gbc);

        buttonCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = inputNombre.getText();
                    int dni = Integer.parseInt(inputDni.getText());
                    int edad = Integer.parseInt(inputEdad.getText());

                    Cliente cliente = new Cliente(nombre, dni, edad);
                    clientes.agregar(cliente);

                    JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent, "Cliente creado exitosamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    supermarketAppGui.showHomeAdmin();
                    // Limpiar campos después de crear el cliente
                    inputNombre.setText("");
                    inputDni.setText("");
                    inputEdad.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent, "DNI y edad deben ser números",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent, "Error al crear cliente: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
