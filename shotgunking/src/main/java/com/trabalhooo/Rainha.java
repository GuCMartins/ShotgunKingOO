package com.trabalhooo;

public class Rainha {
    private int ID;
    private char Icon = '♕';
    
    private int hp = 5;
    private int posx;
    private int posy;
    //funcoes basicas de criação,dano e morte e retorno dos aspectos privados 
    public Rainha(int x,int y,int pos){
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
    //movimentção da rainha
    public void Movimenta(int reix, int reiy, Sistema tab){
        int op=(int)Math.floor(Math.random()*(2)+1);
        int Oldx=this.posx;
        int Oldy=this.posy;
        if(op==1){
            if(this.posx==reix){
                if(this.posy<reiy){
                    while(this.posy<reiy){
                        this.posy++;
                        this.posx++;
                        if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                            this.posx--;
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
                        this.posx--;
                        if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                            this.posx--;
                            this.posy--;
                            tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                            return;
                        }    
                    }
                    tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                }
            }
            
            if(this.posx<reix){
                if(this.posy<=reiy){
                    while(this.posx<reix){
                        this.posy++;
                        this.posx++;
                        if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                            this.posx--;
                            this.posy--;
                            tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID); 
                }
                else{
                    while(this.posx<reix){
                        this.posy--;
                        this.posx++;
                        if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                            this.posx--;
                            this.posy++;
                            tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                }    
            }
            if(this.posx>reix){
                if(this.posy<=reiy){
                    while(this.posy<=reiy){
                        this.posy++;
                        this.posx++;
                        if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                            this.posx--;
                            this.posy--;
                            tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                }
                else{
                    while(this.posx<reix){
                        this.posy--;
                        this.posx++;
                        if(verificacao(tab.getTabuleiro(this.posx, this.posy),this.posx,this.posy)){
                            this.posx--;
                            this.posy++;
                            tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldx,Oldy,this.posx,this.posy,this.ID);
                }    
            }
        }    
        else{
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
        return;
        }  
    }

    private  boolean verificacao(int posicao,int x,int y){//verificacao para limitar a movimentacao dentro 
        if(posicao!=0 || x>=7 || y>=7){                   //do tabuleiro e nao ocupar a casa de outra peca
            return true;
        }
        return false;
    }
}
