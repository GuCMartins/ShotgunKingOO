package com.trabalhooo;

public class Torre extends Peca {// aspectos basicos da peça

    public Torre(int coluna, int linha) {// criação da peca seguindo posicoes predeterminadas
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

    public void Movimenta(int reix, int reiy, Sistema tab) {// movimentacao da peca, seguindo a logica do xadrez e
                                                            // buscando sempre igualar
        int Oldx = this.posx; // primeiramente a posicao x para dps igualar a y
        int Oldy = this.posy;
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
    }
}
