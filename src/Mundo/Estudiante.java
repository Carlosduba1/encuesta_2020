package Mundo;

import java.util.ArrayList;

public class Estudiante {
    //Atributos

    private String nombre;
    private String codigo;
    private String localidad;
    private ArrayList <Asignatura> asignaturas = new ArrayList<Asignatura>();
    private ArrayList <Encuesta> encuestas = new ArrayList<Encuesta>();

    //Constructor
    public Estudiante(String nom,String cod,String loca){
        nombre=nom;
        codigo=cod;
        localidad=loca;
        asignaturas.clear();
    }
    //Metodos
    public String getNombre() {
        return nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getLocalidad() {
        return localidad;
    }
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }
    public Asignatura buscarAsig(String codAsignatura){
        Asignatura aux;
        for (int i = 0; i <asignaturas.size() ; i++) {
            aux=asignaturas.get(i);
            if (aux.getCodigoAsign().equals(codAsignatura)) {
                return aux;
            }
        }
        return null;
    }
    public Encuesta buscarEncu(String codAsig){
        Encuesta aux;
        for (int i = 0; i <encuestas.size() ; i++) {
            aux=encuestas.get(i);
            if (aux.getCodiAsig().equals(codAsig)) {
                return aux;
            }
        }
        return null;
    }
    public ArrayList<Encuesta> getEncuestas() {
        return encuestas;
    }
    public void registrarEncuesta(Encuesta encuestarealizada){
        encuestas.add(encuestarealizada);
    }

    public void registrarAsignaturas(Asignatura asignatura) {
        asignaturas.add(asignatura);
    }
}
