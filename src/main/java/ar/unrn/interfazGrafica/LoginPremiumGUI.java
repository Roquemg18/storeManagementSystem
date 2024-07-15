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

    private JLabel title;
    private JLabel labelDni;
    private JTextField inputDni;
    private JButton buttonLogin;

    public LoginPremiumGUI(ClientesPremium clientes,
                           ArrayList<DescuentoStrategy> descuentosList,
                           SupermarketAppGui supermarketAppGui) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        title = new JLabel("Login Cliente Premium", SwingConstants.CENTER);
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 26));

        labelDni = new JLabel("Ingrese su dni para logearse", SwingConstants.CENTER);
        labelDni.setFont(new Font(title.getFont().getName(), Font.BOLD, 16));

        inputDni = new JTextField(15);
        inputDni.setMaximumSize(new Dimension(200, 25));

        buttonLogin = new JButton("Logearse");
        buttonLogin.setMaximumSize(new Dimension(120, 40));

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
                            supermarketAppGui.showHome();
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

        add(title, gbc);
        add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        add(labelDni, gbc);
        add(Box.createRigidArea(new Dimension(0, 5)), gbc);
        add(inputDni, gbc);
        add(Box.createRigidArea(new Dimension(0, 10)), gbc);
        add(buttonLogin, gbc);
    }
}