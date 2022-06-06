package com.trabalhooo;

public class Peao {
    private int ID=1;
    private int local;
    private char Icon = '♙';
    
    private int hp = 1;
    private int posx;
    private int posy;
    
    public Peao(int x, int y,int id){
        this.local = id;
        this.posx = x;
        this.posy = y; 
    }

    public int getID(){
        return this.ID;
    }

    public int getX(){
        return this.posx;
    }

    public int getY(){
        return this.posy;
    }

    public char getIcon(){
        return this.Icon;
    }
    
    public void Movimenta(int reix, int reiy, Sistema tab){
      int Oldx=this.posx;
      int Oldy=this.posy;  
      if(this.posy<reiy){
        this.posy++;
        if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
            this.posy--;
            tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
        }    
        tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
      }
    }

    public void Dano(int damage){
        this.hp-=damage;
        if(this.hp<=0){
            posx=10;
            posy=10;
        }
    }

    private  boolean verificacao(int posicao,int x,int y){
        if(posicao!=0 || x>=7 || y>=7){
            return true;
        }
        return false;
    }
    
}
