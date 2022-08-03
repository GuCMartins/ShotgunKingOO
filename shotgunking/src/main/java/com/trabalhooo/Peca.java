package com.trabalhooo;//interface

public abstract class Peca {

    protected int posx;
    protected int posy;
    protected int ID;
    protected int hp;
    protected char Icon;

    @Override
    public String toString() {
        return "Peca{" + "posx=" + posx + ", posy=" + posy + ", ID=" + ID + ", hp=" + hp + ", Icon=" + Icon + '}';
    }
    
    

    public int getID() {
        return this.ID;
    }

    public int getLinha() {
        return this.posy;
    }

    public int getColuna() {
        return this.posx;
    }

    public char getIcon() {
        return this.Icon;
    }

    public int getHp() {
        return this.hp;
    }
    
    public void atirar(Sistema tab, int alvolinha, int alvocoluna,Peca alvo){};
    
    public abstract boolean Movimenta(int reix, int reiy, Sistema tab,int op);

    public boolean verificaMov(int oldLinha, int Oldcoluna, int newLinha, int newColuna){
        if(oldLinha == newLinha && Oldcoluna == newColuna){
            return false;
        }
        return true;
    }

    public abstract boolean Movimenta(int reix, int reiy, Sistema tab);

    protected abstract boolean mataRei(Sistema tab, int reiLinha, int reiColuna);

    public void dano(int damage){
        this.hp=this.hp-damage;
    }

    protected boolean verificacaoMov(Peca situacao, int linha, int coluna) { // verificacao para limitar a movimentação
        if (situacao == null && (linha >= 0 && linha < 7) && (coluna >= 0 && coluna < 7)) { // da peca dentro do tabuleiro e nao ocupar a
            return true; // a mesa casa que outra peca
        }
        return false;
    }
}