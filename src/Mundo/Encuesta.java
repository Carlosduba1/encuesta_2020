package Mundo;

public class Encuesta {
    private String codiAsig;
    private String preguntas [];
    private String opciones [];
    private int respuestasn[] = new int[6];
    //Constructor
    public Encuesta(String codiAsigna){
        preguntas = new String[]{"¿Qué tan conforme se siente con lo aprendido a lo largo del semestre?",
                "¿El profesor ha seguido los temas planteados en el syllabus del curso adecuadamente?",
                "¿El profesor se toma su tiempo para resolver las dudas de sus estudiantes?",
                "¿El profesor ha tenido problemas a la hora de conectarse a la hora de conectarse?",
                "¿Considera que el profesor se ha adaptado correctamente a la modalidad virtual?",
                "¿El profesor ha realizado un seguimiento a los estudiantes a lo largo del semestre?"};
        opciones = new String[]{"Muy insatisfecho","Insatisfecho","Satisfecho","Muy satisfecho"};
        codiAsig=codiAsigna;
    }


    //Metodos
    public void hacerEncuesta(int Npregunta,int Nrespuesta){
        respuestasn[Npregunta]=Nrespuesta;
    }

    public String[] getPreguntas() {
        return preguntas;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public int[] getRespuestasn() {
        return respuestasn;
    }

    public String getCodiAsig() {
        return codiAsig;
    }

}
