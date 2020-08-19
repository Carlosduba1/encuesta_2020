package Interfaz;

import Mundo.Encuesta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cuestionario extends JFrame {

    private int intentos = 0;
    private int seleccionado = 0;
    public Cuestionario(){
        setTitle("PARCIAL POO");
        setSize(1000, 300);
        setLocationRelativeTo(null);
        // setMinimumSize(new DimensionUIResource(300, 300));
        cuestionario();
        this.setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void cuestionario(){
        // panel inst
        InterfazEncuesta interfazEncuesta = new InterfazEncuesta();
        EscogerAsig escogerAsig = new EscogerAsig();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(new Color(0x5DD9C1));
        // objetos
        String codAsig=escogerAsig.codAsig,codEs = escogerAsig.codEs;
        Encuesta encuesta = new Encuesta(codAsig);
        String[] preguntas = encuesta.getPreguntas();
        String[] opciones = encuesta.getOpciones();
        //entiqueta
        JLabel label = new JLabel();
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        label.setBounds(8, 0, 1000, 50);
        label.setForeground(new Color(0x190933));
        //RadioButtom
        JRadioButton opcion1 = new JRadioButton(opciones[0]);
        JRadioButton opcion2 = new JRadioButton(opciones[1]);
        JRadioButton opcion3 = new JRadioButton(opciones[2]);
        JRadioButton opcion4 = new JRadioButton(opciones[3]);
        opcion1.setBounds(10,50,130,15);
        opcion2.setBounds(10,80,120,15);
        opcion3.setBounds(10,110,120,15);
        opcion4.setBounds(10,140,120,15);
        opcion1.setBackground(new Color(0x5DD9C1));
        opcion2.setBackground(new Color(0x5DD9C1));
        opcion3.setBackground(new Color(0x5DD9C1));
        opcion4.setBackground(new Color(0x5DD9C1));
        //Boton
        JButton b1 = new JButton("aceptar");
        b1.setBounds(425, 200, 150, 40);
        b1.setBackground(new Color(0xACFCD9));
        b1.setForeground(new Color(0x665687));
        //añadir al panel
        panel.add(label);
        panel.add(b1);
        panel.add(opcion1);
        panel.add(opcion2);
        panel.add(opcion3);
        panel.add(opcion4);
        label.setText(preguntas[intentos]);
        //Buttom group
        ButtonGroup grupoDeBotones = new ButtonGroup();
        grupoDeBotones.add(opcion1);
        grupoDeBotones.add(opcion2);
        grupoDeBotones.add(opcion3);
        grupoDeBotones.add(opcion4);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (intentos != 6) {
                    if ((opcion1.isSelected()) || (opcion2.isSelected()) || (opcion3.isSelected()) || (opcion4.isSelected())) {
                        if (opcion1.isSelected()) {
                            seleccionado = 1;
                        }
                        if (opcion2.isSelected()) {
                            seleccionado = 2;
                        }
                        if (opcion3.isSelected()) {
                            seleccionado = 3;
                        }
                        if (opcion4.isSelected()) {
                            seleccionado = 4;
                        }
                        encuesta.hacerEncuesta(intentos, seleccionado);
                        intentos++;
                        grupoDeBotones.clearSelection();
                        if (intentos == 6) {
                            interfazEncuesta.controlador.realizarEncuesta(codEs, codAsig, encuesta);
                            JOptionPane.showMessageDialog(null, "Ha completado la encuesta");
                            JButton Bsalir = new JButton("Volver al menu");
                            Bsalir.setBounds(625, 200, 150, 40);
                            Bsalir.setBackground(new Color(0xACFCD9));
                            Bsalir.setForeground(new Color(0x665687));
                            panel.add(Bsalir);
                            panel.repaint();
                            Bsalir.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent actionEvent) {
                                    interfazEncuesta.setVisible(true);
                                    Cuestionario.super.setVisible(false);
                                }
                            });
                        }else {
                            label.setText(preguntas[intentos]);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Seleccione una de las opciones", "", JOptionPane.WARNING_MESSAGE);
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"Usted ya ha completado la encuesta");
                }
            }
        });

    }
}
