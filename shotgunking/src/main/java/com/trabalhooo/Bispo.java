package com.trabalhooo;

public class Bispo {
    private int ID = 6;
    private char Icon = '♗';
    
    private int hp = 5;
    private int posx;
    private int posy;
    
    public Bispo(int x,int y){
        this.posx=x;
        this.posy=y;        
    }

    public int getID(){
        return this.ID;
    }

    public char getIcon(){
        return this.Icon;
    }

    public void Dano(){
        this.hp-=2;
        if(this.hp<=0){
            posx=10;
            posy=10;
        }
    }
    
    public void Movimenta(int reix, int reiy, int tabela [][]){
        
    }
}
