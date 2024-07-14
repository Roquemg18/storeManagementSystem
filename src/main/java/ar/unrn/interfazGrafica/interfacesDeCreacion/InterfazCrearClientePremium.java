package ar.unrn.interfazGrafica.interfacesDeCreacion;

import ar.unrn.estructura.Cliente;
import ar.unrn.estructura.ClientesPremium;
import ar.unrn.interfazGrafica.SupermarketAppGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCrearClientePremium extends JPanel{
    private JLabel title;
    private JLabel labelNombre;
    private JTextField inputNombre;
    private JLabel labelDni;
    private JTextField inputDni;
    private JLabel labelEdad;
    private JTextField inputEdad;
    private JButton buttonCliente;


    public InterfazCrearClientePremium(ClientesPremium clientes, SupermarketAppGui supermarketAppGui) {

        setLayout(new GridLayout(8, 1, 5, 5));

        title = new JLabel("Crear cliente premium");
        labelNombre = new JLabel("Ingrese nombre del cliente");
        labelDni = new JLabel("Ingrese el DNI del cliente");
        labelEdad = new JLabel("Ingrese la edad del cliente");
        inputNombre = new JTextField(15);
        inputDni = new JTextField(15);
        inputEdad = new JTextField(15);
        buttonCliente = new JButton("Crear cliente premium");

        add(title);
        add(labelNombre);
        add(inputNombre);
        add(labelDni);
        add(inputDni);
        add(labelEdad);
        add(inputEdad);
        add(buttonCliente);


        buttonCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = inputNombre.getText();
                    int dni = Integer.parseInt(inputDni.getText());
                    int edad = Integer.parseInt(inputEdad.getText());

                    Cliente cliente = new Cliente(nombre, dni, edad);
                    clientes.agregar(cliente);

                    JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent, "Cliente creado " +
                                    "exitosamente",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    supermarketAppGui.showHomeAdmin();
                    // Limpiar campos después de crear el cliente
                    inputNombre.setText("");
                    inputDni.setText("");
                    inputEdad.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent, "DNI debe ser un número",
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(supermarketAppGui.panelViewContent, "Error al crear cliente: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
