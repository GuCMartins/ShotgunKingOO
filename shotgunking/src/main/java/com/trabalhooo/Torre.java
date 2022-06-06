package com.trabalhooo;

public class Torre {
    private int ID;
    private char Icon = '♖';
    
    private int hp = 5;
    private int posx;
    private int posy;
    
    public Torre(int x,int y,int pos){
        this.posx=x;
        this.posy=y;
        this.ID=pos;        
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

    public void Dano(int damage){
        this.hp-=damage;
        if(this.hp<=0){
            posx=10;
            posy=10;
        }
    }
    
    public void Movimenta(int reix, int reiy, Sistema tab){
        int Oldx=this.posx;
        int Oldy=this.posy;
        if(this.posx==reix){
            if(this.posy<reiy){
                while(this.posy<reiy){
                    this.posy++;
                    if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                        this.posy--;
                        tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
            }
            else{
                while(this.posy>reiy){
                    this.posy--;
                    if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                        this.posy++;
                        tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
            }
        }
        while(this.posx<reix){
            this.posx++;
            if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                this.posx--;
                this.posy++;
                tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                return;
            }
        }
        tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
        while(this.posx>reix){
            this.posx--;
            if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                this.posx--;
                this.posy++;
                tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                return;
            }
        }
        tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
    }

    private  boolean verificacao(int posicao,int x,int y){
        if(posicao!=0 || x>=7 || y>=7){
            return true;
        }
        return false;
    }
}
