package Mundo;

import java.util.ArrayList;

public class Asignatura {
    //Atributos
    private String nombreAsign;
    private String codigoAsign;
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private ArrayList<Encuesta> encuestas = new ArrayList<Encuesta>();
    //Constructor
    public Asignatura(String nombreA,String codigoA){
        nombreAsign=nombreA;
        codigoAsign=codigoA;
        estudiantes.clear();
        encuestas.clear();
    }
    //Metodos

    public String getNombreAsign() {
        return nombreAsign;
    }

    public String getCodigoAsign() {
        return codigoAsign;
    }

    public ArrayList<Encuesta> getEncuestas() {
        return encuestas;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public Estudiante buscarEstudiante(String codEs){
        Estudiante aux;
        for (int i = 0; i <estudiantes.size() ; i++) {
            aux=estudiantes.get(i);
            if (aux.getCodigo().equals(codEs)) {
                return aux;
            }
        }
        return null;
    }
    public boolean registrarEstudiante(Estudiante registro){
        estudiantes.add(registro);
        return true;
    }
    public void registrarEncuesta(Encuesta encuestarealizada){
        encuestas.add(encuestarealizada);
    }
}
