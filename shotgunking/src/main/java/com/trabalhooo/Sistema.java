package com.trabalhooo;

import java.util.*;

public class Sistema {

    private int ninimigos;
    private Peca tabuleiro[][];

    public Sistema(int nivel) {
        tabuleiro = new Peca[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                this.tabuleiro[i][j] = null;
            }
        }

        this.tabuleiro[6][3] = new Rei();

        switch (nivel) {
            case 1:
                this.ninimigos = 3;
                this.tabuleiro[1][1] = new Peao(1,1);// peao
                this.tabuleiro[1][3] = new Peao(1,3);// peao
                this.tabuleiro[1][5] = new Peao(1,5);// peao
                break;
            case 2:
                this.ninimigos = 4;
                this.tabuleiro[0][3] = new Peao(0,3);// peao
                this.tabuleiro[1][2] = new Torre(1,2);// torre
                this.tabuleiro[1][4] = new Torre(1,4);// torre
                this.tabuleiro[2][3] = new Bispo(2,3);// bispo
                break;
            case 3:
                this.ninimigos = 6;
                this.tabuleiro[0][1] = new Torre(0,1);//torre
                this.tabuleiro[0][3] = new Torre(0,3);// torre
                this.tabuleiro[0][5] = new Rainha(0,5);// rainha
                this.tabuleiro[3][0] = new Bispo(3,0);// bisbo
                this.tabuleiro[3][6] = new Bispo(3,6);// bispo
                this.tabuleiro[4][3] = new Peao(4,3);// peao
                break;
        }

    }

    public int GetNInimigos() {
        return this.ninimigos;
    }

    public void SetNInimigos() {
        this.ninimigos--;
    }
    
    public Peca GetTabuleiro(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    public int GetTabuleiroSwitch(Peca elemento){
        if(elemento instanceof Rei){
            return 9;
        }
        if(elemento instanceof Peao){
            return 1;
        }
        if(elemento instanceof Bispo){
            return 3;
        }
        if(elemento instanceof Torre){
            return 4;
        }
        if(elemento instanceof Rainha){
            return 7;
        }
        return 0;
    }

    public void setTabuleiro(int Oldlinha, int Oldcoluna, int Newlinha, int Newcoluna) {
        if (Newlinha == Oldlinha && Newcoluna == Oldcoluna) {
            return;
        }
        this.tabuleiro[Newlinha][Newcoluna] = GetTabuleiro(Oldlinha,Oldcoluna);
        this.tabuleiro[Oldlinha][Oldcoluna] = null;
    }

    public void Morte(int linha, int coluna, Peca situacao) {
        if(!(situacao instanceof Rei))
            this.tabuleiro[linha][coluna] = null;
    }

    public void impressaotabuleiro(Sistema tab, int nivel, int balas) {

        int contl, contc;// impressao dinamica do tabuleiro

        System.out.println("                    NÍVEL " + nivel);
        System.out.println("   0     1     2     3     4     5     6");
        System.out.println(" ________________________________________");
        for (contl = 0; contl < 7; contl++) {
            System.out.println("|     |     |     |     |     |     |     |");

            for (contc = 0; contc < 7; contc++) {
                switch (tab.GetTabuleiroSwitch(GetTabuleiro(contl, contc))) {
                    case 9:
                        System.out.print("|  R  ");// impressao do jogador
                        break;
                    case 1:
                        System.out.print("|  P  ");// impressao do inimigo
                        break;
                    case 3:
                        System.out.print("|  B  ");// impressao do inimigo
                        break;
                    case 4:
                        System.out.print("|  T  ");// impressao do inimigo
                        break;
                    case 7:
                        System.out.print("|  r  ");// impressao do inimigo
                        break;
                    default:
                        System.out.print("|     ");// impressao das paredes do tabuleiro
                        break;
                }
            }

            System.out.println("| " + contl);

            System.out.println("|_____|_____|_____|_____|_____|_____|_____|");
        }
        System.out.println("");
        System.out.println("  ______________________________        7  8  9");
        System.out.println(" |(Para se movimentar,pressione|        \\ | /");
        System.out.println(" | um dirercional e,em seguida,|         \\|/");// menus de itens e dicas do jogador
        System.out.println(" |      pressione Enter)       |  4 --Direcionais-- 6      Numero de balas:");
        System.out.println(" |_____________________________|          /|\\                  " + balas + " restantes");
        System.out.println("                                         / | \\ ");
        System.out.println("                                        1  2  3 ");
    }
}
