package com.trabalhooo;

public class Peao extends Peca {

  public Peao(int linha, int coluna) {
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
      if (verificacao(tab.getTabuleiro(this.posx, this.posy), this.posx, this.posy)) {
        this.posy--;
        tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
      }
      tab.setTabuleiro(Oldx, Oldy, this.posx, this.posy, this.ID);
    }
  }

  public void Dano(int damage) {
    this.hp -= damage;
  }

}
