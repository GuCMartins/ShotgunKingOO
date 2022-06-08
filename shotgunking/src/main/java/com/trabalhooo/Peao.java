package com.trabalhooo;

public class Peao {
    private int ID=1;
    private char Icon = '♙';
    
    private int hp = 1;
    private int posx;
    private int posy;
    
    public Peao(int linha, int coluna){
        this.posx = coluna;
        this.posy = linha; 
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

    public int getHp(){
        return this.hp;
    }
    
    public void Movimenta(int reix, int reiy, Sistema tab){
      int Oldx=this.posx;
      int Oldy=this.posy;  
      if(this.posy<reiy){
        this.posy++;
        if(!verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
            this.posy--;
            tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
        }    
        tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
      }
    }

    public void Dano(int damage){
        this.hp-=damage;
    }

    private  boolean verificacao(int posicao,int x,int y){
        if(posicao!=0 || x>=7 || y>=7){
            return true;
        }
        return false;
    }
    
}
