package com.trabalhooo;

public class Peao extends Peca {

  public Peao(int coluna, int linha) {
    this.posx = coluna;
    this.posy = linha;
    this.ID = 1;
    this.Icon = 'P';
    this.hp = 1;
  }

  public void Movimenta(int reix, int reiy, Sistema tab) {
    int Oldx = this.posx;
    int Oldy = this.posy;
    if (this.posy < reiy) {
      this.posy++;
      if (verificacaoMov(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
        this.posy--;
        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
      }
      tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy);
    }
  }

  public void Dano(int damage) {
    this.hp -= damage;
  }

}
