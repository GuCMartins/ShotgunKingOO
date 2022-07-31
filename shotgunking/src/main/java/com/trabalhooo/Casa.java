package com.trabalhooo;
import javax.swing.JButton;

public class Casa extends JButton {

    private Peca posicao;
    private int linha;
    private int coluna;
    
    public Casa(Peca elemento) {
        this.posicao = elemento;
    }

    public Peca isBomba() {
        return posicao;
    }

    public void setBomba(Peca elemento) {
        this.posicao = elemento;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
}
