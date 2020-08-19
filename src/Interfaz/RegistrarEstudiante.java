package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarEstudiante extends JFrame {

    public RegistrarEstudiante(){
        setTitle("PARCIAL POO");
        setSize(1000, 300);
        setLocationRelativeTo(null);
        // setMinimumSize(new DimensionUIResource(300, 300));
        registrar();
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void registrar() {
        InterfazEncuesta interfazEncuesta = new InterfazEncuesta();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(new Color(0x5DD9C1));
        // objetos
        //entiqueta
        JLabel label = new JLabel();
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        label.setBounds(8, 40, 1000, 50);
        label.setForeground(new Color(0x190933));
        //Texto para llenar
        JTextField espacioNom = new JTextField();
        JTextField espacioCod = new JTextField();
        JTextField espacioLocal = new JTextField();
        espacioNom.setBounds(425, 100, 150, 30);
        espacioCod.setBounds(425,130,150,30);
        espacioLocal.setBounds(425,160,150,30);
        //Boton
        JButton bregistrar = new JButton("Registrar");
        JButton atras = new JButton("Atras");
        atras.setBounds(0,0,200,40);
        atras.setBackground(new Color(0xACFCD9));
        atras.setForeground(new Color(0x665687));
        bregistrar.setBounds(425, 200, 150, 40);
        bregistrar.setBackground(new Color(0xACFCD9));
        bregistrar.setForeground(new Color(0x665687));

        //añadir al panel
        panel.add(label);
        panel.add(espacioNom);
        panel.add(espacioCod);
        panel.add(bregistrar);
        panel.add(espacioLocal);
        panel.add(atras);
        label.setText("Por favor registre el nombre, codigo y localidad del estudiante");
        espacioNom.setText("");
        espacioCod.setText("");
        espacioLocal.setText("");

        bregistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String Nom=espacioNom.getText(),Cod=espacioCod.getText(),Local= espacioLocal.getText();
                if ( (Nom.equals("")) || (Cod.equals("")) || (Local.equals("")) ){
                    JOptionPane.showMessageDialog(null,"Llene los espacios en blanco");
                }else {
                    interfazEncuesta.controlador.agregarEstudiantes(espacioNom.getText(), espacioCod.getText(), espacioLocal.getText());
                    espacioNom.setText("");
                    espacioCod.setText("");
                    espacioLocal.setText("");
                }

            }
        });
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAdmin menuAdmin = new MenuAdmin();
                menuAdmin.setVisible(true);
                RegistrarEstudiante.super.setVisible(false);
            }
        });
    }
}
