package com.trabalhooo;

public class Rainha extends Peca {
    
    // funcoes basicas de criação,dano e morte e retorno dos aspectos privados
    public Rainha(int linha, int coluna) {
        this.posx = coluna;
        this.posy = linha;
        this.Icon = '♕';
        this.ID = 7;
        this.hp = 7;
    }
    
    // movimentção da rainha
    public void Movimenta(int reix, int reiy, Sistema tab) {
        int op = (int) Math.floor(Math.random() * (2) + 1);
        int Oldcoluna = this.posx;
        int Oldlinha = this.posy;
        if (op == 1) {
            if (this.posx == reix) {
                if (this.posy < reiy) {
                    while (this.posy < reiy) {
                        this.posy++;
                        this.posx++;
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posx--;
                            this.posy--;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                } else {
                    while (this.posy > reiy) {
                        this.posy--;
                        this.posx--;
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posx--;
                            this.posy--;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                }
            }

            if (this.posx < reix) {
                if (this.posy <= reiy) {
                    while (this.posx < reix) {
                        this.posy++;
                        this.posx++;
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posx--;
                            this.posy--;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                } else {
                    while (this.posx < reix) {
                        this.posy--;
                        this.posx++;
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posx--;
                            this.posy++;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                }
            }
            if (this.posx > reix) {
                if (this.posy <= reiy) {
                    while (this.posy <= reiy) {
                        this.posy++;
                        this.posx++;
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posx--;
                            this.posy--;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                } else {
                    while (this.posx < reix) {
                        this.posy--;
                        this.posx++;
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posx--;
                            this.posy++;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                }
            }
        } else {
            if (this.posx == reix) {
                if (this.posy < reiy) {
                    while (this.posy < reiy) {
                        this.posy++;
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posy--;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                } else {
                    while (this.posy > reiy) {
                        this.posy--;
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posy++;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                            return;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                }
            }
            while (this.posx < reix) {
                this.posx++;
                if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                    this.posx--;
                    this.posy++;
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                    return;
                }
            }
            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
            while (this.posx > reix) {
                this.posx--;
                if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                    this.posx--;
                    this.posy++;
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                    return;
                }
            }
            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
            return;
        }
    }

    protected boolean mataRei(Sistema tab,int reiLinha, int reiColuna){
        if(tab.getTabuleiro(reiLinha, reiColuna) instanceof Rei){
            return true;
        }
        return false;
    }
}
