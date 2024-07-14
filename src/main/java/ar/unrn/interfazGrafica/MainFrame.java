package ar.unrn.interfazGrafica;

import javax.swing.*;

public class MainFrame {
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 JFrame frame = new JFrame("mi lista");
                 //ListaDeProductos lista = new ListaDeProductos();

                 //frame.setContentPane(lista.panelMain);

                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.pack();
                 frame.setVisible(true);


             }
         });
    }
}
