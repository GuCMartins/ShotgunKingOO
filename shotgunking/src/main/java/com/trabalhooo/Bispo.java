package com.trabalhooo;

public class Bispo extends Peca {

    public Bispo(int coluna, int linha,int tirossofridos) {
        this.posx = coluna;
        this.posy = linha;
        this.ID = 3;
        this.Icon = 'B';
        switch(tirossofridos){
            case 0:
                this.hp = 3;
            case 1:
                this.hp = 1;
            default:
                this.hp=0;        
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
                    if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
            } else {
                while (this.posy > reiy) {
                    this.posy--;
                    this.posx--;
                    if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
            }
        }

        if (this.posx < reix) {
            if (this.posy <= reiy) {
                while (this.posx < reix) {
                    this.posy++;
                    this.posx++;
                    if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
            } else {
                while (this.posx < reix) {
                    this.posy--;
                    this.posx++;
                    if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy++;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
            }
        }
        if (this.posx > reix) {
            if (this.posy <= reiy) {
                while (this.posy <= reiy) {
                    this.posy++;
                    this.posx++;
                    if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
            } else {
                while (this.posx < reix) {
                    this.posy--;
                    this.posx++;
                    if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                        this.posx--;
                        this.posy++;
                        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
            }
        }
    }
}
