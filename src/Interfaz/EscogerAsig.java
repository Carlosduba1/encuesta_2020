package Interfaz;

import Mundo.Asignatura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscogerAsig extends JFrame {
    public static String codAsig;
    public static String codEs=MenuEstudiante.estudiante.getCodigo();
    public EscogerAsig(){
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
        //Ins
        MenuEstudiante menuEstudiante = new MenuEstudiante();
        JButton atras = new JButton("Atras");
        atras.setBounds(0,0,200,40);
        atras.setBackground(new Color(0xACFCD9));
        atras.setForeground(new Color(0x665687));
        JButton Baceptar = new JButton("Aceptar");
        Baceptar.setBounds(425,150,200,40);
        Baceptar.setBackground(new Color(0xACFCD9));
        Baceptar.setForeground(new Color(0x665687));
        JComboBox<String> cuadro = new JComboBox<String>();
        cuadro.setBounds(600,110,100,30);
        for (int i = 0; i <menuEstudiante.estudiante.getAsignaturas().size(); i++) {
            Asignatura asignatura =  menuEstudiante.estudiante.getAsignaturas().get(i);
            cuadro.addItem(asignatura.getNombreAsign());
        }

        panel.add(atras);
        panel.add(cuadro);
        panel.add(Baceptar);
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                menuEstudiante.setVisible(true);
                EscogerAsig.super.setVisible(false);
            }
        });
        Baceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String a =(String) cuadro.getSelectedItem();
                InterfazEncuesta interfazEncuesta = new InterfazEncuesta();
                codAsig =interfazEncuesta.controlador.NombredarcodAsig(a);
                if (MenuEstudiante.estudiante.buscarEncu(codAsig)== null){
                    Cuestionario cuestionario = new Cuestionario();
                    cuestionario.setVisible(true);
                    EscogerAsig.super.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"La encuesta de esta materia ya esta realizada");
                }

            }
        });

    }
}
