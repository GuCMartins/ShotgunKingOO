package com.trabalhooo;

public class Bispo extends Peca {

    public Bispo(int linha, int coluna) {
        this.posx = coluna;
        this.posy = linha;
        this.ID = 3;
        this.Icon = 'B';
        this.hp = 3;

    }

    public boolean movimenta(int reilinha, int reicoluna, Sistema tab) {
        int Oldcoluna = this.posx;
        int Oldlinha = this.posy;
        if (this.posy == reilinha) {
            if (this.posx < reicoluna) {
                while (this.posy < reicoluna && this.posx < 6) {
                    this.posy++;
                    this.posx++;
                    if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                            return true;
                        }
                        return false;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                    return true;
                }
                return false;
            } else {
                while (this.posx > reicoluna && this.posy > 0) {
                    this.posy--;
                    this.posx--;
                    if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx++;
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                            return true;
                        }
                        return false;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                    return true;
                }
                return false;
            }
        }else if (this.posy < reilinha) {
            if (this.posx <= reicoluna) {
                while (this.posx <= reicoluna && this.posx < 6 && this.posx < 6) {
                    this.posy++;
                    this.posx++;
                    if(this.posy > 6 || this.posx > 6){
                        System.out.println("aqui");
                        this.posy--;
                        this.posx--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        return true;
                    }else{
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posx--;
                            this.posy--;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                            if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                                return true;
                            }
                            return false;
                        }
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                    return true;
                }
                return false;

            } else {
                while (this.posx > reicoluna && this.posy < 6 && this.posx > 0) {
                    this.posy++;
                    this.posx--;
                    if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy++;
                        if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                            return true;
                        }
                        return false;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                    return true;
                }
                return false;
            }
        }else if (this.posy > reilinha) {
            if (this.posx < reicoluna) {
                while (this.posx < reicoluna && this.posy > 0 && this.posx < 6) {
                    this.posy--;
                    this.posx++;
                    if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx--;
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                            return true;
                        }
                        return false;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                    return true;
                }
                return false;
            } else if(this.posx >= reicoluna){
                while (this.posx >= reicoluna && this.posy > 0 && this.posx > 0) {
                    this.posy--;
                    this.posx--;
                    if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posx++;
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                            return true;
                        }
                        return false;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                    return true;
                }
                return false;
            }
        }
        if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
            return true;
        }
        return false;
    }

    protected boolean mataRei(Sistema tab, int reiLinha, int reiColuna) {
        if(this.posx < reiColuna){
            int copiaColuna = this.posx + 1;
            

            if(this.posy < reiLinha){
                int copiaLinha = this.posy + 1;
                while(copiaColuna <= reiColuna && copiaLinha <= reiLinha){

                    if(tab.getTabuleiro(copiaLinha, copiaColuna) != null){
                        if(tab.getTabuleiro(copiaLinha, copiaColuna) instanceof Rei){
                            return true;
                        }
                        return false;
                    }
                    copiaColuna++;
                    copiaLinha++;
                }
            }else if(this.posy > reiLinha){
                int copiaLinha = this.posy - 1;
                while(copiaColuna <= reiColuna && copiaLinha >= reiLinha){
                    if(tab.getTabuleiro(copiaLinha, copiaColuna) != null){
                        if(tab.getTabuleiro(copiaLinha, copiaColuna) instanceof Rei){
                            return true;
                        }
                        return false;
                    }
                    copiaColuna ++;
                    copiaLinha --;
                }
            }

        }else if(this.posx > reiColuna){
            int copiaColuna = this.posx - 1;
            

            if(this.posy < reiLinha){
                int copiaLinha = this.posy + 1;
                while(copiaColuna >= reiColuna && copiaLinha <= reiLinha){
                    if(tab.getTabuleiro(copiaLinha, copiaColuna) != null){
                        if(tab.getTabuleiro(copiaLinha, copiaColuna) instanceof Rei){
                            return true;
                        }
                        return false;
                    }
                    copiaColuna --;
                    copiaLinha ++;
                }
            }else if(this.posy > reiLinha){
                int copiaLinha = this.posy - 1;
                while(copiaColuna >= reiColuna && copiaLinha >= reiLinha){
                    if(tab.getTabuleiro(copiaLinha, copiaColuna) != null){
                        if(tab.getTabuleiro(copiaLinha, copiaColuna) instanceof Rei){
                            return true;
                        }
                        return false;
                    }
                    copiaColuna --;
                    copiaLinha --;
                }
            }
        }
        return false;
    }
    @Override
    public boolean movimentaRei(int reix, int reiy, Sistema tab, int op) {
        // TODO Auto-generated method stub
        return false;
    }
}
