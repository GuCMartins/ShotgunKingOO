package com.trabalhooo;

public abstract class Peca {

    protected int posx;
    protected int posy;
    protected int ID;
    protected int hp;
    protected char Icon;

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

    public abstract void Movimenta(int reix, int reiy, Sistema tab);

    protected abstract boolean mataRei(Sistema tab, int reiLinha, int reiColuna);

    public void dano(int damage){
        this.hp=this.hp-damage;
    }

    protected boolean verificacaoMov(Peca situacao, int x, int y) { // verificacao para limitar a movimentação
        if (situacao == null && (x >= 0 && x < 7) && (y >= 0 && y < 7)) { // da peca dentro do tabuleiro e nao ocupar a
            return true; // a mesa casa que outra peca
        }
        return false;
    }
}
