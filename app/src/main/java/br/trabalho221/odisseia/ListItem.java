package br.trabalho221.odisseia;

public class ListItem {
    private String NomeDisciplina;
    private String Comentario;

    public ListItem(String nomeDisciplina, String comentario) {
        NomeDisciplina = nomeDisciplina;
        Comentario = comentario;
    }

    public String getNomeDisciplina() {
        return NomeDisciplina;
    }

    public String getComentario() {
        return Comentario;
    }
}
