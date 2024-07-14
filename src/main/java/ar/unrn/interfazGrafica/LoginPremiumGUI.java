package ar.unrn.interfazGrafica;

import ar.unrn.estructura.ClientesPremium;
import ar.unrn.strategy.DescuentoPorPremium;
import ar.unrn.strategy.DescuentoStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginPremiumGUI extends JPanel {

    public JPanel panelMain;
    private JLabel title;
    private JLabel labelDni;
    private JTextField inputDni;
    private JButton buttonLogin;

    public LoginPremiumGUI(ClientesPremium clientes, ArrayList<DescuentoStrategy> descuentosList) {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(8, 1, 5, 5));

        title = new JLabel("Login Cliente Premium");
        labelDni = new JLabel("Ingrese su dni para logearse");
        inputDni = new JTextField(15);
        buttonLogin = new JButton("Logearse");

        buttonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dniText = inputDni.getText().trim();
                if (!dniText.isEmpty()) {
                    try {
                        int dniUser = Integer.parseInt(dniText);
                        if (clientes.verificarPremium(dniUser)) {
                            DescuentoPorPremium descuentoPorPremium = new DescuentoPorPremium();
                            descuentosList.add(descuentoPorPremium);
                            //frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error: DNI no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El DNI debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo DNI no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panelMain.add(title);
        panelMain.add(labelDni);
        panelMain.add(inputDni);
        panelMain.add(buttonLogin);
    }

}
