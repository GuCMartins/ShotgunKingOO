package com.trabalhooo;

public class Torre extends Peca {// aspectos basicos da peça

    public Torre(int linha, int coluna) {// criação da peca seguindo posicoes predeterminadas
        this.posx = coluna;
        this.posy = linha;
        this.ID = 5;
        this.Icon = 'T';
        this.hp = 5;
    }

    public void Movimenta(int reilinha, int reicoluna, Sistema tab) {// movimentacao da peca, seguindo a logica do xadrez e
                                                            // buscando sempre igualar
        int Oldcoluna = this.posx; // primeiramente a posicao x para dps igualar a y
        int Oldlinha = this.posy;
        if (this.posy == reilinha) {
            if (this.posx < reicoluna) {
                while (this.posx < reicoluna) {
                    this.posx++;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return;
                    }
                }
            } else {
                while (this.posx > reicoluna) {
                    this.posx--;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return;
                    }
                }
            }
        }
        while (this.posy < reilinha) {
            this.posy++;
            if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                this.posy--;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;
            }
        }
        while (this.posy > reilinha) {
            this.posy--;
            if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                this.posy++;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                return;
            }
        }
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
    }

    protected boolean MataRei(Sistema tab,int reiLinha, int reiColuna){
        if(tab.GetTabuleiro(reiLinha, reiColuna) instanceof Rei){
            return true;
        }
        return false;
    }
}
