package ar.unrn.interfazGrafica.interfacesDeCreacion;

import ar.unrn.estructura.Cliente;
import ar.unrn.estructura.ClientesPremium;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearClientePremium {
    private JLabel title;
    private JLabel labelNombre;
    private JTextField inputNombre;
    private JLabel labelDni;
    private JTextField inputDni;
    private JLabel labelEdad;
    private JTextField inputEdad;
    private JButton buttonCliente;
    public JPanel panelMain;

    public InterfazCrearClientePremium(ClientesPremium clientes, JFrame frame) {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(8, 1, 5, 5));

        title = new JLabel("Crear cliente premium");
        labelNombre = new JLabel("Ingrese nombre del cliente");
        labelDni = new JLabel("Ingrese el DNI del cliente");
        labelEdad = new JLabel("Ingrese la edad del cliente");
        inputNombre = new JTextField(15);
        inputDni = new JTextField(15);
        inputEdad = new JTextField(15);
        buttonCliente = new JButton("Crear cliente premium");

        panelMain.add(title);
        panelMain.add(labelNombre);
        panelMain.add(inputNombre);
        panelMain.add(labelDni);
        panelMain.add(inputDni);
        panelMain.add(labelEdad);
        panelMain.add(inputEdad);
        panelMain.add(buttonCliente);


        buttonCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = inputNombre.getText();
                    int dni = Integer.parseInt(inputDni.getText());
                    int edad = Integer.parseInt(inputEdad.getText());

                    Cliente cliente = new Cliente(nombre, dni, edad);
                    clientes.agregar(cliente);

                    JOptionPane.showMessageDialog(panelMain, "Cliente creado exitosamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    frame.dispose();
                    // Limpiar campos después de crear el cliente
                    inputNombre.setText("");
                    inputDni.setText("");
                    inputEdad.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panelMain, "DNI debe ser un número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panelMain, "Error al crear cliente: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
