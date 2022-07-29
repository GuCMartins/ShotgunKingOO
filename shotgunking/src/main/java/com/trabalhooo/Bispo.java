package com.trabalhooo;

public class Bispo extends Peca {

    public Bispo(int linha, int coluna) {
        this.posx = coluna;
        this.posy = linha;
        this.ID = 3;
        this.Icon = 'B';
        this.hp = 3;

    }

    public void Movimenta(int reilinha, int reicoluna, Sistema tab) {
        int Oldcoluna = this.posx;
        int Oldlinha = this.posy;
        if (this.posy == reilinha) {
            if (this.posx < reicoluna) {
                while (this.posy < reicoluna) {
                    this.posy++;
                    this.posx++;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return;
                    }
                }
            } else {
                while (this.posx > reicoluna) {
                    this.posy--;
                    this.posx--;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx++;
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return;
                    }
                }
            }
        }

        if (this.posy < reilinha) {
            if (this.posx <= reicoluna) {
                while (this.posx < reicoluna) {
                    this.posy++;
                    this.posx++;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return;
                    }
                }
            } else {
                while (this.posx > reicoluna) {
                    this.posy++;
                    this.posx--;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return;
                    }
                }
            }
        }
        if (this.posy > reilinha) {
            if (this.posx <= reicoluna) {
                while (this.posx <= reicoluna) {
                    this.posy--;
                    this.posx++;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return;
                    }
                }
            } else {
                while (this.posx > reicoluna) {
                    this.posy--;
                    this.posx--;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return;
                    }
                }
            }
        }
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
    }

    protected boolean MataRei(Sistema tab, int reiLinha, int reiColuna) {
        if (tab.GetTabuleiro(reiLinha, reiColuna) instanceof Rei) {
            return true;
        }
        return false;
    }
}
