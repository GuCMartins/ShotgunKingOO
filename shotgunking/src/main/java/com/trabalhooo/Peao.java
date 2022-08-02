package com.trabalhooo;

public class Peao extends Peca {

  public Peao(int linha, int coluna) {
    this.posx = coluna;
    this.posy = linha;
    this.ID = 1;
    this.Icon = 'P';
    this.hp = 1;
  }

  public boolean Movimenta(int reilinha, int reicoluna, Sistema tab) {
    int Oldcoluna = this.posx;
    int Oldlinha = this.posy;
    if (this.posy < reilinha) {
      this.posy++;

      if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
        this.posy--;
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
          if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
            return true;
          }
          return false;
      }

      tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);

    }else if(this.posy >= reilinha && this.posy < 6){
        this.posy++;
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);   
    }

    if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
      return true;
    }
    return false;
    
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
