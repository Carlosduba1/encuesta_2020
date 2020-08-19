package Interfaz;
import Mundo.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEncuesta extends JFrame  {

    public static Controlador controlador = new Controlador();
    public InterfazEncuesta() {
        setTitle("PARCIAL POO");
        setSize(1000, 300);
        setLocationRelativeTo(null);
        // setMinimumSize(new DimensionUIResource(300, 300));
        inicio();
        this.setResizable(false);
    }
    public void inicio(){
        // panel inst
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        panel.setBackground(new Color(0x5DD9C1));
        // objetos
        //entiqueta
        JLabel label = new JLabel();
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        label.setBounds(8, 0, 1000, 50);
        label.setForeground(new Color(0x5E77FF));
        //Boton
        JButton bAdmin = new JButton("Admin");
        JButton bEstudiante = new JButton("Estudiante");
        //Ubicacion de botones
        bAdmin.setBounds(425, 70, 200, 40);
        bEstudiante.setBounds(425,150,200,40);
        bAdmin.setBackground(new Color(0xACFCD9));
        bAdmin.setForeground(new Color(0x665687));
        bEstudiante.setBackground(new Color(0xACFCD9));
        bEstudiante.setForeground(new Color(0x665687));
        //Añadir al panel
        panel.add(bAdmin);
        panel.add(bEstudiante);
        panel.add(label);
        bAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuAdmin menuAdmin = new MenuAdmin();
                menuAdmin.setVisible(true);
                InterfazEncuesta.super.setVisible(false);
            }
        });
        bEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuEstudiante menuEstudiante = new MenuEstudiante();
                menuEstudiante.setVisible(true);
                InterfazEncuesta.super.setVisible(false);

            }
        });
        label.setText("Escoja una de la opciones");
 }
    //Ejecucion
    public static void main(String[] args) {
        InterfazEncuesta Ventana = new InterfazEncuesta();
        Ventana.setVisible( true );
    }
}