package com.trabalhooo;

public class Rei {
    private int ID = 9;
    private char Icon = '♚';
    
    private int hp = 1;
    private int vidas = 2;
    private int balas = 5;
    private int Arma_dano = 2; 
    private int posx;
    private int posy;
    
    public Rei(){
        this.posx = 3;
        this.posy = 6;
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
}
