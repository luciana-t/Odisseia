package br.trabalho221.odisseia;

public class ListSubject {
    private String materia;
    private String nota;

    public String getMateria() {
        return materia;
    }

    public String getNota() {
        return nota;
    }

    public ListSubject(String materia, String nota) {
        this.materia = materia;
        this.nota = nota;
    }
}
