package com.trabalhooo;

public class Peao {
    private int ID;
    private char Icon = '♙';
    
    private int hp = 1;
    private int posx;
    private int posy;
    
    public Peao(int x, int y,int id){
        this.ID = id;
        this.posx = x;
        this.posy = y; 
    }

    public int getID(){
        return this.ID;
    }

    public char getIcon(){
        return this.Icon;
    }
    
    public void Movimenta(int reix, int reiy, int tabela [][]){
      if(this.posy<reiy){
        this.posy++;
      }
    }

    public void Dano(){
        this.hp-=2;
        if(this.hp<=0){
            posx=10;
            posy=10;
        }
    }
    
}
