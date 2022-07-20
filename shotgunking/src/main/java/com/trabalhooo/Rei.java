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

    public int Getbalas() {
        return this.balas;
    }

    public void Movimenta(int Oldlinha, int Oldcoluna, Sistema tab) {
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
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;

            case 7:
                if (posx - 1 == -1 || posy - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx--;
                posy--;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;

            case 8:
                if (posy - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posy--;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;

            case 9:
                if (posx + 1 == 7 || posy - 1 == -1) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx++;
                posy--;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;

            case 6:
                if (posx + 1 == 7) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx++;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;

            case 3:
                if (posx + 1 == 7 || posy + 1 == 0) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx++;
                posy++;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;

            case 2:
                if (posy + 1 == 7) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posy++;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;

            case 1:
                if (posx - 1 == 0 || posy + 1 == 7) {
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return;
                }
                posx--;
                posy++;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;
        }
        System.out.println("Selecione uma opção de movimentação");
        return;
    }

    public void Atirar(Sistema tab, int alvolinha, int alvocoluna) {

        tab.GetTabuleiro(alvolinha, alvocoluna).Dano(Arma_dano);
        this.balas--;
    
    }

    protected boolean MataRei(Sistema tab,int reiLinha, int reiColuna){
        Scanner teclado = new Scanner(System.in);
        String confirm;
        System.out.println("Quer mesmo desistir?");
        confirm = teclado.nextLine();
        if(confirm.equals("sim")){
            return true;
        }
        return false;
    }
    
    
}