package Interfaz;

import Mundo.Asignatura;
import Mundo.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarAsignatura extends JFrame {
    public RegistrarAsignatura(){
        setTitle("PARCIAL POO");
        setSize(1000, 300);
        setLocationRelativeTo(null);
        // setMinimumSize(new DimensionUIResource(300, 300));
        registrar();
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void registrar(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(new Color(0x5DD9C1));
        // objetos
        InterfazEncuesta interfazEncuesta = new InterfazEncuesta();
        //entiqueta
        JLabel label = new JLabel();
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        label.setBounds(8, 40, 1000, 50);
        label.setForeground(new Color(0x190933));
        //Texto para llenar
        JTextField espacioNomAsig = new JTextField();
        JTextField espacioCodAsig = new JTextField();
        espacioNomAsig.setBounds(425, 100, 150, 30);
        espacioCodAsig.setBounds(425,130,150,30);
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
        panel.add(espacioNomAsig);
        panel.add(espacioCodAsig);
        panel.add(bregistrar);
        panel.add(atras);
        label.setText("Por favor registre el nombre, codigo y localidad del estudiante");
        bregistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String Nom=espacioNomAsig.getText(),Cod=espacioCodAsig.getText();
                if ( Nom.equals("") || Cod.equals("") ){
                    JOptionPane.showMessageDialog(null,"Llene los espacios en blanco");
                }else{
                    interfazEncuesta.controlador.agregarMateria(espacioNomAsig.getText(),espacioCodAsig.getText());
                    espacioNomAsig.setText("");
                    espacioCodAsig.setText("");
                }
            }
        });
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAdmin menuAdmin = new MenuAdmin();
                menuAdmin.setVisible(true);
                RegistrarAsignatura.super.setVisible(false);
            }
        });
    }
}