package br.trabalho221.odisseia;

public class Usuario {
    Usuario() {}

    Usuario(int id, String nome, String curso, String data_admissao, String data_cadastro) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.data_admissao = data_admissao;
        this.data_cadastro = data_cadastro;
    }

    public int id;
    public String nome;
    public String curso;
    public String data_admissao;
    public String data_cadastro;
}
