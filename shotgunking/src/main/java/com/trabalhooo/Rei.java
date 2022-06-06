package com.trabalhooo;

import java.util.*;

public class Rei {
    private int ID;
    private char Icon = '♚';

    private int vidas = 2;
    private int balas = 5;
    private int Arma_dano = 2; 
    private int posx;
    private int posy;
    
    public Rei(){
        this.posx = 3;
        this.posy = 6;
    }

    public int getID(){
        return this.ID;
    }

    public char getIcon(){
        return this.Icon;
    }
    
    public int Movimento(int dir){
        switch(dir){
            case 4:
                if( posx==0){
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return 0;
                }
                posx--;
                return 1;

            case 7:
                if( posx==0 || posy ==7){
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return 0;
                }
                posx--;
                posy++;
                return 1;

            case 8:
                if(posy ==7){
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return 0;
                }
                posy++;
                return 1;

            case 9:
                if( posx==7 || posy ==7){
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return 0;
                }
                posx++;
                posy++;
                return 1;

            case 6:
                if( posx==7){
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return 0;
                }
                posx++;
                return 1;

            case 3:
                if( posx==7 || posy ==0){
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return 0;
                }
                posx++;
                posy--;
                return 1;
            
            case 2:
                if(posy == 0){
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return 0;
                }
                posy--;
                return 1;

            case 1:
                if( posx==0 || posy ==0){
                    System.out.println("Impossivel fazer o movimento");
                    System.out.println("Escolha outra opção");
                    return 0;
                }
                posx--;
                posy--;
                return 1;
        }
        System.out.println("Selecione uma opção de movimentação");
        return 0; 
    }

    public void Atirar(List<Peao> Apawn,Torre torres[],Bispo bispos[],Rainha rainha, int tabuleiro[][]){
        Scanner teclado = new Scanner(System.in);
        int alvox=teclado.nextInt();
        int alvoy=teclado.nextInt();
        double distancia=Math.sqrt(Math.pow(alvox-this.posx,2)+Math.pow(alvoy-this.posy,2));
        while(distancia>2 || tabuleiro[alvox][alvoy]==0){
            System.out.println("Posicionamento muito distante ou sem inimigos.Selecione outro local:");
            alvox=teclado.nextInt();
            alvoy=teclado.nextInt();
            distancia=Math.sqrt(Math.pow(alvox,2)+Math.pow(alvoy,2));
        }
        switch(tabuleiro[alvox][alvoy]){
            case 1:
                int tam = Apawn.size();
                for(int i=0;i<tam;i++){
                    if(Apawn.get(i).getX()==alvox && Apawn.get(i).getY()==alvoy){
                        Apawn.get(i).Dano(this.Arma_dano);
                        this.balas--;
                        break;
                    }                        
                }
            case 3:
                for(int i=0;i<2;i++){
                    if(bispos[i].getX()==alvox && bispos[i].getY()==alvoy){
                        bispos[i].Dano(this.Arma_dano);
                        this.balas--;
                        break;
                    }                        
                }
            case 4:
                for(int i=0;i<2;i++){
                    if(torres[i].getX()==alvox && torres[i].getY()==alvoy){
                        torres[i].Dano(this.Arma_dano);
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
}
