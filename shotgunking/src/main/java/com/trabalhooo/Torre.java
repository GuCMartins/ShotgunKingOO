package com.trabalhooo;

public class Torre {//aspectos basicos da peça
    private int ID;
    private char Icon = '♖';
    
    private int hp = 5;
    private int posx;
    private int posy;
    
    public Torre(int x,int y,int pos){//criação da peca seguindo posicoes predeterminadas
        this.posx=x;
        this.posy=y;
        this.ID=pos;        
    }

    public int getID(){//retorno de aspectos privados
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

    public void Dano(int damage){//caso a peça leve dano da arma.
        this.hp-=damage;         //se a vida da peça for reduzida a menos que 1(<+0),
        if(this.hp<=0){          // a peça é mandada para o fim do tabuleiro(ver como deletar a peca no meio da partida)
            posx=10;
            posy=10;
        }
    }
    
    public void Movimenta(int reix, int reiy, Sistema tab){//movimentacao da peca, seguindo a logica do xadrez e buscando sempre igualar 
        int Oldx=this.posx;                                //primeiramente a posicao x para dps igualar a y
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

    private  boolean verificacao(int posicao,int x,int y){//verificacao para limitar a movimentação 
        if(posicao!=0 || x>=7 || y>=7){                   // da peca dentro do tabuleiro e nao ocupar a 
            return true;                                  // a mesa casa que outra peca
        }
        return false;
    }
}
