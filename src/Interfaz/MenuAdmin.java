package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame {
    public MenuAdmin(){
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
        // objetos
        //entiqueta
        JLabel tutulo = new JLabel();
        tutulo.setFont(new Font("Verdana", Font.PLAIN, 15));
        tutulo.setBounds(8, 0, 1000, 50);
        tutulo.setForeground(new Color(0x190933));
        //Boton
        JButton bRegistrarEstudiante = new JButton("Registrar Estudiante");
        JButton bRegistrarMateria = new JButton("Registrar Materia");
        JButton atras = new JButton("Atras");
        JButton bAsignarEsudiante = new JButton("Asignar estudiante");
        //Ubicacion de botones
        bAsignarEsudiante.setBounds(425,200,200,40);
        bRegistrarEstudiante.setBounds(425, 70, 200, 40);
        bRegistrarMateria.setBounds(425,150,200,40);
        atras.setBounds(0,0,200,40);
        bAsignarEsudiante.setBackground(new Color(0xACFCD9));
        bAsignarEsudiante.setForeground(new Color(0x665687));
        atras.setBackground(new Color(0xACFCD9));
        atras.setForeground(new Color(0x665687));
        bRegistrarEstudiante.setBackground(new Color(0xACFCD9));
        bRegistrarEstudiante.setForeground(new Color(0x665687));
        bRegistrarMateria.setBackground(new Color(0xACFCD9));
        bRegistrarMateria.setForeground(new Color(0x665687));
        //Añadir al panel
        panel.add(bRegistrarEstudiante);
        panel.add(bRegistrarMateria);
        panel.add(tutulo);
        panel.add(atras);
        panel.add(bAsignarEsudiante);
        bRegistrarEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarEstudiante registrar = new RegistrarEstudiante();
                registrar.setVisible(true);
                MenuAdmin.super.setVisible(false);
            }
        });
        bRegistrarMateria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarAsignatura registrarAsignatura = new RegistrarAsignatura();
                registrarAsignatura.setVisible(true);
                MenuAdmin.super.setVisible(false);
            }
        });
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InterfazEncuesta interfazEncuesta = new InterfazEncuesta();
                interfazEncuesta.setVisible(true);
                MenuAdmin.super.setVisible(false);
            }
        });
        bAsignarEsudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AsignarEstudiante asignarEstudiante = new AsignarEstudiante();
                asignarEstudiante.setVisible(true);
                MenuAdmin.super.setVisible(false);
            }
        });
    }
}
