package com.trabalhooo;

import java.util.*;

public class Rei extends Peca {// ver como vai funcionar o dano no rei

    private int vidas = 2;
    private int balas = 5;
    private int Arma_dano = 2;

    public Rei() {
        this.posx = 3;
        this.posy = 6;
        this.ID = 9;
        this.Icon = 'R';
    }

    public int getbalas() {
        return this.balas;
    }

    public void Movimenta(int Oldx, int Oldy, Sistema tab) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolha a opção de movimentação");
        int dir = teclado.nextInt();
        switch (dir) {
            case 4:
                if (posx - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx--;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                return;

            case 7:
                if (posx - 1 == -1 || posy - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx--;
                posy--;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                return;

            case 8:
                if (posy - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posy--;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                return;

            case 9:
                if (posx + 1 == 7 || posy - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx++;
                posy--;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                return;

            case 6:
                if (posx + 1 == 7) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx++;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                return;

            case 3:
                if (posx + 1 == 7 || posy + 1 == 0) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx++;
                posy++;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                return;

            case 2:
                if (posy + 1 == 7) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posy++;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                return;

            case 1:
                if (posx - 1 == 0 || posy + 1 == 7) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx--;
                posy++;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                return;
        }
        System.out.println("Selecione uma opção de movimentação");
        return;
    }

    public void Atirar(Sistema tab, int alvolinha, int alvocoluna) {

        tab.getTabuleiro(alvolinha, alvocoluna).Dano();
    
    }    

    public void Dano(int damage) {

    }
}