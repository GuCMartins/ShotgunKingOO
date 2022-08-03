package com.trabalhooo;//interface

import java.util.*;

public class Rei extends Peca implements arma{// ver como vai funcionar o dano no rei
    
    private int balas = 5;
    private int Arma_dano = 2;

    public Rei() {
        this.posx = 3;
        this.posy = 6;
        this.ID = 9;
        this.Icon = 'R';
        this.hp = 2;
    }
    
    public void inicia(int linha,int coluna){
        this.posy=linha;
        this.posx = coluna;
    }

    public int getbalas() {
        return this.balas;
    }

    public void Movimenta(int Oldlinha, int Oldcoluna, Sistema tab, int op) {
        System.out.println("Escolha a opção de movimentação");
        boolean ver = false;
        while (!ver) {
            switch (op) {
                case 4:
                    if (posx - 1 == -1) {
                        System.out.println("Impossivel fazer o movimento");
                        System.out.println("Escolha outra opção");
                    } else {
                        posx--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 7:
                    if (posx - 1 == -1 || posy - 1 == -1) {
                        System.out.println("Impossivel fazer o movimento");
                        System.out.println("Escolha outra opção");

                    } else {
                        posx--;
                        posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 8:
                    if (posy - 1 == -1) {
                        System.out.println("Impossivel fazer o movimento");
                        System.out.println("Escolha outra opção");
                    } else {
                        posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 9:
                    if (posx + 1 == 7 || posy - 1 == -1) {
                        System.out.println("Impossivel fazer o movimento");
                        System.out.println("Escolha outra opção");
                    } else {
                        posx++;
                        posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 6:
                    if (posx + 1 == 7) {
                        System.out.println("Impossivel fazer o movimento");
                        System.out.println("Escolha outra opção");
                    } else {
                        posx++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 3:
                    if (posx + 1 == 7 || posy + 1 == 7) {
                        System.out.println("Impossivel fazer o movimento");
                        System.out.println("Escolha outra opção");
                    } else {
                        posx++;
                        posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 2:
                    if (posy + 1 == 7) {
                        System.out.println("Impossivel fazer o movimento");
                        System.out.println("Escolha outra opção");
                    } else {
                        posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 1:
                    if (posx - 1 == -1 || posy + 1 == 7) {
                        System.out.println("Impossivel fazer o movimento");
                        System.out.println("Escolha outra opção");
                    } else {
                        posx--;
                        posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;
            }
        }
    }

    public void atirar(Sistema tab, int alvolinha, int alvocoluna,Peca alvo) {

        tab.getTabuleiro(alvolinha, alvocoluna).dano(Arma_dano);
        alvo.dano(Arma_dano);
        this.balas--;

    }

    public void balasMatou(){
        this.balas++;
    }
    
    public void perdeHp(){
        this.hp--;
    }

    protected boolean mataRei(Sistema tab, int reiLinha, int reiColuna) {
        Scanner teclado = new Scanner(System.in);
        String confirm;
        System.out.println("Quer mesmo desistir?");
        confirm = teclado.nextLine();
        if (confirm.equals("sim")) {
            return true;
        }
        return false;
    }

    public void Movimenta(int reix, int reiy, Sistema tab){};

}