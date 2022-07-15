package com.trabalhooo;

import java.util.*;

public class Sistema {

    private int ninimigos;
    private int tabuleiro[][];

    public Sistema(int nivel) {
        tabuleiro = new int[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                this.tabuleiro[i][j] = 0;
            }
        }

        this.tabuleiro[6][3] = 9;

        switch (nivel) {
            case 1:
                this.ninimigos = 3;
                this.tabuleiro[1][1] = 1;// peao
                this.tabuleiro[1][3] = 1;// peao
                this.tabuleiro[1][5] = 1;// peao
                break;
            case 2:
                this.ninimigos = 4;
                this.tabuleiro[0][3] = 1;// peao
                this.tabuleiro[1][2] = 4;// torre
                this.tabuleiro[1][4] = 4;// torre
                this.tabuleiro[2][3] = 3;// bispo
                break;
            case 3:
                this.ninimigos = 6;
                this.tabuleiro[0][1] = 4;// torre
                this.tabuleiro[0][3] = 4;// torre
                this.tabuleiro[0][5] = 5;// rainha
                this.tabuleiro[3][0] = 3;// bisbo
                this.tabuleiro[3][6] = 3;// bispo
                this.tabuleiro[4][3] = 1;// peao
                break;
        }

    }

    public int getNInimigos() {
        return this.ninimigos;
    }

    public void setNInimigos() {
        this.ninimigos--;
    }

    public int getTabuleiro(int i, int j) {
        return tabuleiro[i][j];
    }

    public void setTabuleiro(int Oldx, int Oldy, int Newx, int Newy, int val) {
        if (Newx == Oldx && Newy == Oldy) {
            return;
        }
        this.tabuleiro[Oldy][Oldx] = 0;
        this.tabuleiro[Newy][Newx] = val;
    }

    public void Morte(int Deadx, int Deady) {
        this.tabuleiro[Deady][Deadx] = 0;
    }

    public void impressaotabuleiro(Sistema tab, int nivel, int balas) {

        int contl, contc;// impressao dinamica do tabuleiro

        System.out.println("                    NÍVEL " + nivel);
        System.out.println("   0     1     2     3     4     5     6");
        System.out.println(" ________________________________________");
        for (contl = 0; contl < 7; contl++) {
            System.out.println("|     |     |     |     |     |     |     |");

            for (contc = 0; contc < 7; contc++) {
                switch (tab.getTabuleiro(contl, contc)) {
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
                    case 5:
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
