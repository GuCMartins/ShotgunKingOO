package com.trabalhooo;
import java.util.*;

public class Jogo 
{
    public static void main(String[] args) {
        int nivel = 1;
        
    }
    
    public void nivel_1(int nivel){
        Rei jogador = new Rei();
        List<Peao> Peoes = new ArrayList<>();      
        Sistema tab = new Sistema(nivel);
        int cont=0;
        
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(tab.getTabuleiro(i, j)==1){
                   Peao p = new Peao(i,j,cont);
                   Peoes.add(p);
                   cont++;
                }        
            }
        }
    }
}
