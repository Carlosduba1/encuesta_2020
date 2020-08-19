package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AsignarEstudiante extends JFrame {
    public AsignarEstudiante(){
        setTitle("PARCIAL POO");
        setSize(1000, 300);
        setLocationRelativeTo(null);
        // setMinimumSize(new DimensionUIResource(300, 300));
        asignar();
        this.setResizable(false);
    }
    public void asignar(){
        InterfazEncuesta interfazEncuesta = new InterfazEncuesta();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(new Color(0x5DD9C1));
        JComboBox<String> cuadro1 = new JComboBox<String>();
        JComboBox<String> cuadro2 = new JComboBox<String>();
        cuadro1.setBounds(50,50,150,40);
        cuadro2.setBounds(210,50,150,40);
        for (int i = 0; i <interfazEncuesta.controlador.getAsignaturas().size() ; i++) {
            cuadro1.addItem(interfazEncuesta.controlador.getAsignaturas().get(i).getNombreAsign());

        }
        for (int i = 0; i <interfazEncuesta.controlador.getEstudiantes().size() ; i++) {
            cuadro2.addItem(interfazEncuesta.controlador.getEstudiantes().get(i).getNombre());
        }
        JButton atras = new JButton("Atras");
        atras.setBounds(0,0,200,40);
        atras.setBackground(new Color(0xACFCD9));
        atras.setForeground(new Color(0x665687));
        JButton Basignar = new JButton("Asignar Estudiante");
        Basignar.setBounds(425,150,200,40);
        Basignar.setBackground(new Color(0xACFCD9));
        Basignar.setForeground(new Color(0x665687));
        panel.add(cuadro1);
        panel.add(cuadro2);
        panel.add(atras);
        panel.add(Basignar);
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MenuAdmin menuAdmin = new MenuAdmin();
                menuAdmin.setVisible(true);
                AsignarEstudiante.super.setVisible(false);
            }
        });
        Basignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String codAs = (String) cuadro1.getSelectedItem();
                codAs=interfazEncuesta.controlador.NombredarcodAsig(codAs);
                String codEs = (String) cuadro2.getSelectedItem();
                codEs=interfazEncuesta.controlador.NombredarcodEs(codEs);
                interfazEncuesta.controlador.asignarEstudiante(codEs,codAs);
            }
        });
    }
}
