package com.trabalhooo;


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
                tabuleiro[1][1]=1;//peao
                tabuleiro[1][3]=1;//peao
                tabuleiro[1][5]=1;//peao
                break;
            case 2:
                ninimigos=4;
                tabuleiro[0][3] = 1;//peao
                tabuleiro[1][2] = 5;//torre
                tabuleiro[1][4] = 5;//torre
                tabuleiro[2][3] = 4;//cavalo
                break;    
            case 3:
                ninimigos = 6;
                tabuleiro[0][1] = 4;//cavalo
                tabuleiro[0][3] = 5;//torre
                tabuleiro[0][5] = 4;//cavalo
                tabuleiro[3][0] = 3;//bisbo
                tabuleiro[3][6] = 3;//bispo
                tabuleiro[4][3] = 1;//peao
                break;        
        }
        
    }
    
    public int getTabuleiro(int i, int j){
        return tabuleiro[i][j];
    }    
  
}
