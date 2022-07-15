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
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                return;

            case 7:
                if (posx - 1 == -1 || posy - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx--;
                posy--;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                return;

            case 8:
                if (posy - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posy--;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                return;

            case 9:
                if (posx + 1 == 7 || posy - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx++;
                posy--;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                return;

            case 6:
                if (posx + 1 == 7) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx++;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                return;

            case 3:
                if (posx + 1 == 7 || posy + 1 == 0) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx++;
                posy++;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                return;

            case 2:
                if (posy + 1 == 7) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posy++;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                return;

            case 1:
                if (posx - 1 == 0 || posy + 1 == 7) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx--;
                posy++;
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                return;
        }
        System.out.println("Selecione uma opção de movimentação");
        return;
    }

    public void Atirar(List<Peao> Apawn, List<Torre> torres, List<Bispo> bispos, Rainha rainha, Sistema tab) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Insira a coluna onde o inimigo se encontra:");
        int alvox = teclado.nextInt();
        System.out.println("Insira a linha onde o inimigo se encontra:");
        int alvoy = teclado.nextInt();
        double distancia = Math.sqrt(Math.pow(alvox - this.posx, 2) + Math.pow(alvoy - this.posy, 2));
        int op;
        while (distancia > 3 || tab.getTabuleiro(alvox, alvoy) == 0) {
            System.out.println(
                    "Posicionamento muito distante ou sem inimigos.Deseja continuar atirando?(se deseja, insira 1):");
            op = teclado.nextInt();
            if (op == 1) {
                System.out.println("Insira a linha onde o inimigo se encontra:");
                alvox = teclado.nextInt();
                System.out.println("Insira a coluna onde o inimigo se encontra:");
                alvoy = teclado.nextInt();
                distancia = Math.sqrt(Math.pow(alvox - this.posx, 2) + Math.pow(alvoy - this.posy, 2));
            } else
                return;
        }
        switch (tab.getTabuleiro(alvox, alvoy)) {
            case 1:
                int tam = Apawn.size();
                for (int i = 0; i < tam; i++) {
                    if (Apawn.get(i).getX() == alvox && Apawn.get(i).getY() == alvoy) {
                        Apawn.get(i).Dano(this.Arma_dano);
                        this.balas--;
                        break;
                    }
                }
            case 3:
                for (int i = 0; i < 2; i++) {
                    if (bispos.get(i).getX() == alvox && bispos.get(i).getY() == alvoy) {
                        bispos.get(i).Dano(this.Arma_dano);
                        this.balas--;
                        break;
                    }
                }
            case 4:
                for (int i = 0; i < 2; i++) {
                    if (torres.get(i).getX() == alvox && torres.get(i).getY() == alvoy) {
                        torres.get(i).Dano(this.Arma_dano);
                        this.balas--;
                        break;
                    }
                }
            case 5:
                rainha.Dano(this.Arma_dano);
                this.balas--;
                break;
        }

    }

    public void Dano(int damage) {

    }
}