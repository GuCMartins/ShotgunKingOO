package com.trabalhooo;

public abstract class Peca {

    protected int posx;
    protected int posy;
    protected int ID;
    protected char Icon;
    protected int hp;
    protected int tirossofridos;

    public int getID() {
        return this.ID;
    }

    public int getX() {
        return this.posx;
    }

    public int getY() {
        return this.posy;
    }

    public char getIcon() {
        return this.Icon;
    }

    public int getHp() {
        return this.hp;
    }

    public abstract void Movimenta(int reix, int reiy, Sistema tab);

    public void Dano(){
        this.tirossofridos++;
    }

    protected boolean verificacaoMov(Peca situacao, int x, int y) { // verificacao para limitar a movimentação
        if (situacao == null && (x >= 0 && x < 7) && (y >= 0 && y < 7)) { // da peca dentro do tabuleiro e nao ocupar a
            return true; // a mesa casa que outra peca
        }
        return false;
    }
}
