package com.example.eric.listagemclassificados;

/**
 * Created by eric on 17/10/14.
 */
public class CorpoClassificado {
    private String descricao;
    private Imagem imagem;

    public CorpoClassificado(String descricao, Imagem imagem) {
        this.descricao = descricao;
        this.imagem = imagem;
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
