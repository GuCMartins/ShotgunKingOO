//Integrantes: 
//João Vítor de Castro Martins Ferreira Nogueira(202065560C), 
//Kayan Martins de Freitas(202176030), 
//Gustavo Coelho Martins(202165513B)
package com.trabalhooo;//interface

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sistema extends JFrame {

    
    private int ninimigos;
    private Peca tabuleiro[][];
    public static int TAMANHO = 7;

    public Sistema(int nivel, Rei jogador) {
        tabuleiro = new Peca[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                this.tabuleiro[i][j] = null;
            }
        }

        jogador.inicia(6, 3);

        this.tabuleiro[6][3] = new Rei();

        switch (nivel) {
            case 1:
                this.ninimigos = 3;
                this.tabuleiro[1][1] = new Peao(1, 1);// peao
                this.tabuleiro[1][3] = new Peao(1, 3);// peao
                this.tabuleiro[1][5] = new Peao(1, 5);// peao
                break;
            case 2:
                this.ninimigos = 4;
                this.tabuleiro[0][3] = new Peao(0, 3);// peao
                this.tabuleiro[1][2] = new Torre(1, 2);// torre
                this.tabuleiro[1][4] = new Torre(1, 4);// torre
                this.tabuleiro[2][3] = new Bispo(2, 3);// bispo
                break;
            case 3:
                this.ninimigos = 6;
                this.tabuleiro[0][1] = new Torre(0, 1);// torre
                this.tabuleiro[0][3] = new Torre(0, 3);// torre
                this.tabuleiro[0][5] = new Rainha(0, 5);// rainha
                this.tabuleiro[3][0] = new Bispo(3, 0);// bisbo
                this.tabuleiro[3][6] = new Bispo(3, 6);// bispo
                this.tabuleiro[4][3] = new Peao(4, 3);// peao
                break;
        }
    }

    public void setPainel(JPanel painel, int reiLinha, int reiColuna) {
        painel.setLayout(new GridLayout(TAMANHO, TAMANHO));
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                Casa casa = new Casa(getTabuleiro(i, j), i, j);
                casa.setIconNew(getTabuleiro(i, j), reiLinha, reiColuna);

                casa.setPreferredSize(new Dimension(50, 50));
                casa.setBorder(BorderFactory.createLineBorder(Color.black));

                painel.add(casa);
            }
        }

        this.add(painel);
        this.setVisible(true);
        this.setSize(5000, 5000);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.repaint();
        this.pack();
        this.setLocationRelativeTo(null);
        this.setLocation(775,75);
    }

    public int getNInimigos() {
        return this.ninimigos;
    }

    public void setNInimigos() {
        this.ninimigos--;
    }

    public Peca getTabuleiro(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    public int getTabuleiroSwitch(Peca elemento) {
        if (elemento instanceof Rei) {
            return 9;
        }
        if (elemento instanceof Peao) {
            return 1;
        }
        if (elemento instanceof Bispo) {
            return 3;
        }
        if (elemento instanceof Torre) {
            return 4;
        }
        if (elemento instanceof Rainha) {
            return 7;
        }
        return 0;
    }

    public void setTabuleiro(int oldLinha, int oldColuna, int newLinha, int newColuna) {
        if (newLinha == oldLinha && newColuna == oldColuna) {
            return;
        }
        this.tabuleiro[newLinha][newColuna] = getTabuleiro(oldLinha, oldColuna);
        this.tabuleiro[oldLinha][oldColuna] = null;
    }

    public void resetPainel(JPanel painel, Rei jogador) {
        painel.removeAll();
        setPainel(painel, jogador.getLinha(), jogador.getColuna());
    }

    public void morte(int linha, int coluna, Peca situacao) {
        if (!(situacao instanceof Rei))
            this.tabuleiro[linha][coluna] = null;
    }

}
