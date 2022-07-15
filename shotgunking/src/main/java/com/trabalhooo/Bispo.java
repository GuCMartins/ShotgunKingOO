package com.trabalhooo;

public class Bispo extends Peca {

    public Bispo(int x, int y) {
        this.posx = x;
        this.posy = y;
        this.ID = 3;
        this.Icon = 'B';
        this.hp = 3;
    }

    public void Dano(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            posx = 10;
            posy = 10;
        }
    }

    public void Movimenta(int reix, int reiy, Sistema tab) {
        int Oldx = this.posx;
        int Oldy = this.posy;
        if (this.posx == reix) {
            if (this.posy < reiy) {
                while (this.posy < reiy) {
                    this.posy++;
                    this.posx++;
                    if (verificacao(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
            } else {
                while (this.posy > reiy) {
                    this.posy--;
                    this.posx--;
                    if (verificacao(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
            }
        }

        if (this.posx < reix) {
            if (this.posy <= reiy) {
                while (this.posx < reix) {
                    this.posy++;
                    this.posx++;
                    if (verificacao(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
            } else {
                while (this.posx < reix) {
                    this.posy--;
                    this.posx++;
                    if (verificacao(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy++;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
            }
        }
        if (this.posx > reix) {
            if (this.posy <= reiy) {
                while (this.posy <= reiy) {
                    this.posy++;
                    this.posx++;
                    if (verificacao(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
            } else {
                while (this.posx < reix) {
                    this.posy--;
                    this.posx++;
                    if (verificacao(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy++;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
            }
        }
    }
}
