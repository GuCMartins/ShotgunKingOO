package com.trabalhooo;

public class Rainha extends Peca {
    
    // funcoes basicas de criação,dano e morte e retorno dos aspectos privados
    public Rainha(int linha, int coluna) {
        this.posx = coluna;
        this.posy = linha;
        this.Icon = 'Q';
        this.ID = 7;
        this.hp = 5;
    }
    
    public boolean Movimenta(int reilinha, int reicoluna, Sistema tab) {
        return true;
    }
    // movimentção da rainha
    /*
    public void Movimenta(int reilinha, int reicoluna, Sistema tab) {
        int op = (int) Math.floor(Math.random() * (2) + 1);
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
                while (this.posx > reicoluna && posy > 0) {
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
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return;
                    }
                }
            } else {
                while (this.posx > reicoluna && posy > 0) {
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
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
    }
    */

    protected boolean MataRei(Sistema tab,int reiLinha, int reiColuna){
        if(tab.GetTabuleiro(reiLinha, reiColuna) instanceof Rei){
            return true;
        }
        return false;
    }
}
