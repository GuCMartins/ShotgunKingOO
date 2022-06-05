package com.trabalhooo;

public class Bispo {
    private int ID = 6;
    private char Icon = '♗';
    
    private int hp = 4;
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
        if(this.posx==reix){
            if(this.posy<reiy){
                while(this.posy<reiy){
                this.posy++;
                this.posx++;
                if(!verificacao(this.posx,this.posy,tabela)){
                    this.posx--;
                    this.posy--;
                    return;
                    }
                } 
            }
            else{
                while(this.posy>reiy){
                    this.posy--;
                    this.posx--;
                    if(!verificacao(this.posx,this.posy,tabela)){
                        this.posx--;
                        this.posy--;
                        return;
                    }    
                }
            }
        }
        
        if(this.posx<reix){
            if(this.posy<=reiy){
                while(this.posx<reix){
                    this.posy++;
                    this.posx++;
                    if(!verificacao(this.posx,this.posy,tabela)){
                        this.posx--;
                        this.posy--;
                        return;
                    }
                } 
            }
            else{
                while(this.posx<reix){
                    this.posy--;
                    this.posx++;
                    if(!verificacao(this.posx,this.posy,tabela)){
                        this.posx--;
                        this.posy++;
                        return;
                    }
                }
            }    
        }
        if(this.posx>reix){
            if(this.posy<=reiy){
                while(this.posy<=reiy){
                    this.posy++;
                    this.posx++;
                    if(!verificacao(this.posx,this.posy,tabela)){
                        this.posx--;
                        this.posy--;
                        return;
                    }
                }
            }
            else{
                while(this.posx<reix){
                    this.posy--;
                    this.posx++;
                    if(!verificacao(this.posx,this.posy,tabela)){
                        this.posx--;
                        this.posy++;
                        return;
                    }
                }
            }    
        }
    }

    private  boolean verificacao(int x, int y, int tabela[][]){
        if(tabela[x][y]==0){
            return true;
        }
        return false;
    }
}
