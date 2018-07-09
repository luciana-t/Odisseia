package br.trabalho221.odisseia;

public class ListSubject {
    private int id;
    private String materia;
    private String nota;

    public int getId() { return id; }

    public String getMateria() {
        return materia;
    }

    public String getNota() {
        return nota;
    }

    public ListSubject(int id, String materia, String nota) {
        this.id = id;
        this.materia = materia;
        this.nota = nota;
    }
}
