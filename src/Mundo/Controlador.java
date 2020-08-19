package Mundo;

import javax.swing.*;
import java.util.ArrayList;

public class Controlador {
    //Atributos
    ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
    //Metodos
    public void agregarMateria(String nomAsig,String codAsig){
        asignaturas.add(new Asignatura(nomAsig,codAsig));
    }
    public  void agregarEstudiantes(String nomEs,String codEs,String nonvocal){
        estudiantes.add(new Estudiante(nomEs,codEs,nonvocal));
    }
    public Estudiante buscarEstudiante(String cod){
        for (int i = 0; i <estudiantes.size() ; i++) {
            Estudiante es = estudiantes.get(i);
            if (es.getCodigo().equals(cod)){
                return es;
            }
        }
        return null;
    }
    public  Asignatura buscarAsignatura(String codAsig){
        for (int i = 0; i <asignaturas.size() ; i++) {
            Asignatura asig = asignaturas.get(i);
            if (asig.getCodigoAsign().equals(codAsig)){
                return asig;
            }
        }
        return null;
    }
    public void asignarEstudiante(String codEs,String codAsig){
        Estudiante es = buscarEstudiante(codEs);
        Asignatura asig = buscarAsignatura(codAsig);
        if (asig.buscarEstudiante(codEs)!=null || es.buscarAsig(codAsig)!=null ){
            new Exception("Estudiante ya registrado en esta materia");
        }else {
            asig.registrarEstudiante(es);
            es.registrarAsignaturas(asig);
            JOptionPane.showMessageDialog(null,"Estudiante registrado");
        }
    }

    public void realizarEncuesta(String codEs,String codAsig,Encuesta encuestarealizada )  {
        Estudiante es = buscarEstudiante(codEs);
        Asignatura asig = buscarAsignatura(codAsig);
        if (es.buscarEncu(asig.getCodigoAsign()) == null) {
            es.registrarEncuesta(encuestarealizada);
            asig.registrarEncuesta(encuestarealizada);
        }else{
            JOptionPane.showMessageDialog(null,"Fallo");
        }
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    public String NombredarcodEs (String nombre){
        for (int i = 0; i <estudiantes.size() ; i++) {
            Estudiante aux=estudiantes.get(i);
            if (aux.getNombre().equalsIgnoreCase(nombre)){
               return aux.getCodigo();
            }
        }
        return null;
    }
    public String NombredarcodAsig (String nombre){
        for (int i = 0; i <asignaturas.size() ; i++) {
            Asignatura aux=asignaturas.get(i);
            if (aux.getNombreAsign().equalsIgnoreCase(nombre)){
                return aux.getCodigoAsign();
            }
        }
        return null;
    }
}
