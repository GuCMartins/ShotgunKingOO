package com.trabalhooo;

public class Torre extends Peca {// aspectos basicos da peça

    public Torre(int linha, int coluna) {// criação da peca seguindo posicoes predeterminadas
        this.posx = coluna;
        this.posy = linha;
        this.ID = 5;
        this.Icon = 'T';
        this.hp = 5;
    }

    public void Dano(int damage) {// caso a peça leve dano da arma.
        this.hp -= damage; // se a vida da peça for reduzida a menos que 1(<+0),
        if (this.hp <= 0) { // a peça é mandada para o fim do tabuleiro(ver como deletar a peca no meio da
                            // partida)
            posx = 10;
            posy = 10;
        }
    }

    public void Movimenta(int reiy, int reix, Sistema tab) {// movimentacao da peca, seguindo a logica do xadrez e
                                                            // buscando sempre igualar
        int Oldcoluna = this.posx; // primeiramente a posicao x para dps igualar a y
        int Oldlinha = this.posy;
        if (this.posy == reiy) {
            if (this.posx < reix) {
                while (this.posx < reix) {
                    this.posy++;
                    if (verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                        return;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
            } else {
                while (this.posy > reiy) {
                    this.posy--;
                    if (verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
            if (verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                this.posx--;
                this.posy++;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                return;
            }
        }
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
        while (this.posx > reix) {
            this.posx--;
            if (verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                this.posx--;
                this.posy++;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                return;
            }
        }
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
    }

    protected boolean MataRei(Sistema tab,int reiLinha, int reiColuna){
        if(tab.GetTabuleiro(reiLinha, reiColuna) instanceof Rei){
            return true;
        }
        return false;
    }
}
