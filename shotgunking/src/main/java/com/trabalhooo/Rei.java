//Integrantes: 
//João Vítor de Castro Martins Ferreira Nogueira(202065560C), 
//Kayan Martins de Freitas(202176030), 
//Gustavo Coelho Martins(202165513B)
package com.trabalhooo;//interface

import javax.swing.JOptionPane;

public class Rei extends Peca implements arma {// ver como vai funcionar o dano no rei

    private int balas = 5;
    private int Arma_dano = 2;

    public Rei() {
        this.posx = 3;
        this.posy = 6;
        this.ID = 9;
        this.Icon = 'R';
        this.hp = 3;
    }
    
    public void inicia(int linha,int coluna){
        this.posy=linha;
        this.posx = coluna;
    }

    public int getbalas() {
        return this.balas;
    }

    public boolean movimentaRei(int Oldlinha, int Oldcoluna, Sistema tab, int op) {
        boolean ver = false;
        while (!ver) {
            switch (op) {
                case 0:
                    if (posx - 1 == -1) {
                        op=reveMovimento();
                    } else {
                        posx--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 4:
                    if (posx - 1 == -1 || posy - 1 == -1) {
                        op=reveMovimento();
                    } else {
                        posx--;
                        posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 2:
                    if (posy - 1 == -1) {
                        op=reveMovimento();
                    } else {
                        posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 5:
                    if (posx + 1 == 7 || posy - 1 == -1) {
                        op=reveMovimento();
                    } else {    
                        posx++;
                        posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 1:
                    if (posx + 1 == 7) {
                        op=reveMovimento();
                    } else {
                        posx++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 6:
                    if (posx + 1 == 7 || posy + 1 == 7) {
                        op=reveMovimento();
                    } else {
                        posx++;
                        posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 3:
                    if (posy + 1 == 7) {
                        op=reveMovimento();
                    } else {
                        posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;

                case 7:
                    if (posx - 1 == -1 || posy + 1 == 7) {
                        op=reveMovimento();
                    } else {
                        posx--;
                        posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        ver = true;
                    }
                    break;
                default:
                    op = reveMovimento();    
            }
        }
        return true;
    }

    private int reveMovimento(){
        JOptionPane.showConfirmDialog(null, "Movimento impossivel", "Erro",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
        String[] move = {"🢀","🢂","🢁","🢃","🢄","🢅","🢆","🢇"};
        int option = JOptionPane.showOptionDialog(null, "Selecione assim que tomar a decisão", "Confirmação",
                JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, null, move, move[0]);
        return option;
    }

    public void atirar(Sistema tab, int alvolinha, int alvocoluna, Peca alvo) {

        tab.getTabuleiro(alvolinha, alvocoluna).dano(Arma_dano);
        alvo.dano(Arma_dano);
        this.balas--;

    }

    public void balasMatou() {
        this.balas++;
    }

    public void perdeHp() {
        this.hp--;
    }

    protected boolean mataRei(Sistema tab, int reiLinha, int reiColuna) {
        String[] options = { "Desisto", "Ainda vou lutar!" };
        int option = JOptionPane.showOptionDialog(null, "Quer mesmo desistir?", "Assim não...",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (option == 0) {
            return true;
        }
        return false;
    }

    public boolean movimenta(int reix, int reiy, Sistema tab) {
        return true;
    };

}