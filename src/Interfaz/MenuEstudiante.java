package Interfaz;

import Mundo.Estudiante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEstudiante extends JFrame {
    public static Estudiante estudiante;
    InterfazEncuesta interfazEncuesta = new InterfazEncuesta();
    public MenuEstudiante(){
        setTitle("PARCIAL POO");
        setSize(1000, 300);
        setLocationRelativeTo(null);
        // setMinimumSize(new DimensionUIResource(300, 300));
        Menu();
        this.setResizable(false);
    }
    public void Menu(){
        // panel inst
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(new Color(0x5DD9C1));
        //Jlabel
        JLabel titulo = new JLabel();
        titulo.setFont(new Font("Verdana", Font.PLAIN, 15));
        titulo.setBounds(8, 0, 1000, 50);
        titulo.setForeground(new Color(0x190933));
        titulo.setText("Buscar Estudiante");
        //Espacio en blanco
        JTextField busqueda = new JTextField();
        busqueda.setBounds(425, 100, 150, 30);
        // Boton
        JButton atras = new JButton("Atras");
        atras.setBounds(0,0,200,40);
        atras.setBackground(new Color(0xACFCD9));
        atras.setForeground(new Color(0x665687));
        JButton Bbusqueda = new JButton("Buscar");
        Bbusqueda.setBounds(425,150,200,40);
        Bbusqueda.setBackground(new Color(0xACFCD9));
        Bbusqueda.setForeground(new Color(0x665687));
        panel.add(titulo);
        panel.add(busqueda);
        panel.add(Bbusqueda);
        panel.add(atras);
        Bbusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                estudiante =interfazEncuesta.controlador.buscarEstudiante(busqueda.getText());
                if (estudiante== null){
                    JOptionPane.showMessageDialog(null,"Estudiante no encontrado");
                }else{
                    JOptionPane.showMessageDialog(null,"Estudiante encontrado");
                    EscogerAsig escogerAsig = new EscogerAsig();
                    escogerAsig.setVisible(true);
                    MenuEstudiante.super.setVisible(false);
                }
            }
        });
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InterfazEncuesta interfazEncuesta = new InterfazEncuesta();
                interfazEncuesta.setVisible(true);
                MenuEstudiante.super.setVisible(false);
            }
        });
    }
}
