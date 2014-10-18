package com.example.eric.listagemclassificados;

/**
 * Created by eric on 17/10/14.
 */
public class Classificado {
    private String titulo;
    private Usuario autor;
    private String descricao;
    private Imagem imagem;

    public Classificado(String titulo, Usuario autor, String descricao, Imagem imagem) {
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
}
