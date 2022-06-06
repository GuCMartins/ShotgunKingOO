package com.trabalhooo;

import java.util.*;

public class Sistema {
    
    private int ninimigos;
    private int tabuleiro [][];
    
    
    public Sistema(int nivel){
        tabuleiro= new int [7][7];
        for (int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                tabuleiro[i][j]=0;
            }
        }
        
        switch(nivel){
            case 1:
                ninimigos=3;
                tabuleiro[1][1]= 1;//peao
                tabuleiro[1][3]= 1;//peao
                tabuleiro[1][5]= 1;//peao
                break;
            case 2:
                ninimigos=4;
                tabuleiro[0][3] = 1;//peao
                tabuleiro[1][2] = 4;//torre
                tabuleiro[1][4] = 4;//torre
                tabuleiro[2][3] = 5;//rainha
                break;    
            case 3:
                ninimigos = 6;
                tabuleiro[0][1] = 4;//torre
                tabuleiro[0][3] = 4;//torre
                tabuleiro[0][5] = 5;//rainha
                tabuleiro[3][0] = 3;//bisbo
                tabuleiro[3][6] = 3;//bispo
                tabuleiro[4][3] = 1;//peao
                break;        
        }
        
    }
    
    public int getTabuleiro(int i, int j){
        return tabuleiro[i][j];
    }

    public void setTabuleiro(int Oldx, int Oldy,int Newx,int Newy,int val){
        this.tabuleiro[Oldx][Oldy] = 0;
        this.tabuleiro[Newx][Newy] = val;
    }

    public void impressaotabuleiro(int m[][], Rei jogador,List<Peao> Apawn,Torre Atower[],Bispo Abishop[],Rainha Aqueen){

        int contl,contc;//impressao dinamica do tabuleiro

        System.out.println("                    NÍVEL ");
        System.out.println("   0     1     2     3     4     5     6     7     8");
        System.out.println(" _____________________________________________________");
        for(contl=0;contl<7;contl++){ 
        System.out.println("|     |     |     |     |     |     |     |     |     |");
        
            for(contc=0;contc<7;contc++){
                if(m[contl][contc]==jogador.getID()){
                    System.out.println("|  "+jogador.getIcon()+"  ");//impressao do jogador
                }
                else
                if(m[contl][contc]==1){//peao
                    System.out.println("|  ♙  ");//impressao do inimigo
                }else
                if(m[contl][contc]==5){//torre
                    System.out.println("|  ♖  ");//impressao do inimigo
                }else
                if(m[contl][contc]==6){//bispo
                    System.out.println("|  ♗  ");//impressao do inimigo
                }else
                if(m[contl][contc]==8){//rainha
                    System.out.println("|  ♕  ");//impressao do inimigo
                }else
                    System.out.println("|     ");//impressao das paredes do tabuleiro
            }
        
            System.out.println("| "+contl);
        
            System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|_____|\n");
        }
        System.out.println("\n");
        System.out.println("  ______________________________           7  8  9\n");
        System.out.println("  |(Para se movimentar,pressione|           \\ | /\n");
        System.out.println("  | um dirercional e,em seguida,|            \\|/\n");// menus de itens e dicas do jogador
        System.out.println("  |      pressione Enter)       |     4 --Direcionais-- 6\n");
        System.out.println("  |_____________________________|            /|\\ \n");
        System.out.println("                                            / | \\ \n");
        System.out.println("                                           1  2  3 \n");
    }    
}
