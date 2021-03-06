package com.trabalhooo;

public class Bispo extends Peca {

    public Bispo(int linha, int coluna) {
        this.posx = coluna;
        this.posy = linha;
        this.ID = 3;
        this.Icon = 'B';

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
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                        return;
                    }
                }
                if (MataRei(tab, reilinha, reicoluna) == true) {// completar com uma info para que o rei possa ser morto

                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
            } else {
                while (this.posx > reicoluna) {
                    this.posy--;
                    this.posx--;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx++;
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
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
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
            } else {
                while (this.posx > reicoluna) {
                    this.posy++;
                    this.posx--;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
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
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
            } else {
                while (this.posx > reicoluna) {
                    this.posy--;
                    this.posx--;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
            }
        }
    }

    protected boolean MataRei(Sistema tab, int reiLinha, int reiColuna) {
        if (tab.GetTabuleiro(reiLinha, reiColuna) instanceof Rei) {
            return true;
        }
        return false;
    }
}
