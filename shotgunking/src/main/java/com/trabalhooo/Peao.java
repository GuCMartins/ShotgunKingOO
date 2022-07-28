package com.trabalhooo;

public class Peao extends Peca {

  public Peao(int linha, int coluna) {
    this.posx = coluna;
    this.posy = linha;
    this.ID = 1;
    this.Icon = 'P';
    this.hp = 1;
  }

  public void Movimenta(int reilinha, int reicoluna, Sistema tab) {
    int Oldcoluna = this.posx;
    int Oldlinha = this.posy;
    if (this.posy < reilinha && this.hp > 0) {
      this.posy++;
      if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
        this.posy--;
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
        return;
      }
      tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
    }
  }

  @Override
  protected boolean MataRei(Sistema tab, int reiLinha, int reiColuna) {
    if (tab.GetTabuleiro(this.posy + 1, this.posx + 1) instanceof Rei
        || tab.GetTabuleiro(this.posy + 1, this.posx - 1) instanceof Rei) {
      return true;
    }
    return false;
  }

}
