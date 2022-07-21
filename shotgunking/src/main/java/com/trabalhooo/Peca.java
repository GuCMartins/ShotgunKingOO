package com.trabalhooo;

public abstract class Peca {

    protected int posx;
    protected int posy;
    protected int ID;
    protected char Icon;
    protected int hp;

    public int GetID() {
        return this.ID;
    }

    public int GetLinha() {
        return this.posy;
    }

    public int GetColuna() {
        return this.posx;
    }

    public char GetIcon() {
        return this.Icon;
    }

    public int GetHp() {
        return this.hp;
    }

    public abstract void Movimenta(int reix, int reiy, Sistema tab);

    protected abstract boolean MataRei(Sistema tab, int reiLinha, int reiColuna);

    public void Dano(int damage){
        this.hp=this.hp-damage;
    }

    protected boolean verificacaoMov(Peca situacao, int x, int y) { // verificacao para limitar a movimentação
        if (situacao == null && (x >= 0 && x < 7) && (y >= 0 && y < 7)) { // da peca dentro do tabuleiro e nao ocupar a
            return true; // a mesa casa que outra peca
        }
        return false;
    }
}
