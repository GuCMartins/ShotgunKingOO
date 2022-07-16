package com.trabalhooo;

public class Rainha extends Peca {
    
    // funcoes basicas de criação,dano e morte e retorno dos aspectos privados
    public Rainha(int coluna, int linha) {
        this.posx = coluna;
        this.posy = linha;
        this.Icon = '♕';
        this.ID = 7;
        this.hp = 7;
    }

    public void Dano(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) {
            posx = 10;
            posy = 10;
        }
    }

    // movimentção da rainha
    public void Movimenta(int reix, int reiy, Sistema tab) {
        int op = (int) Math.floor(Math.random() * (2) + 1);
        int Oldx = this.posx;
        int Oldy = this.posy;
        if (op == 1) {
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
        } else {
            if (this.posx == reix) {
                if (this.posy < reiy) {
                    while (this.posy < reiy) {
                        this.posy++;
                        if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                            this.posy--;
                            tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                } else {
                    while (this.posy > reiy) {
                        this.posy--;
                        if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                            this.posy++;
                            tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                }
            }
            while (this.posx < reix) {
                this.posx++;
                if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                    this.posx--;
                    this.posy++;
                    tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                    return;
                }
            }
            tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
            while (this.posx > reix) {
                this.posx--;
                if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
                    this.posx--;
                    this.posy++;
                    tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
                    return;
                }
            }
            tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
            return;
        }
    }
}
