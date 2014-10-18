package com.example.eric.listagemclassificados;

/**
 * Created by eric on 17/10/14.
 */
public class Imagem {
    private int caminho; // De acordo com o modelo de domínio, o caminho deve ser String.

    public Imagem() {
    }

    public Imagem(int caminho) {
        this.caminho = caminho;
    }

    public int getCaminho() {
        return caminho;
    }

    public void setCaminho(int caminho) {
        this.caminho = caminho;
    }
}
