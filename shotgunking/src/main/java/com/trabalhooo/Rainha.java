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
        int op = (int) Math.floor(Math.random() * (2) + 1);
        int Oldcoluna = this.posx;
        int Oldlinha = this.posy;

        if(op == 1){
            if(this.posy < reilinha){          
                while (this.posy < reilinha) {
                    this.posy++;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posy--;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        if(this.verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                            return true;
                        }
                        return false;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                if(this.verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                    return true;
                }
                return false;
            }else if(this.posy > reilinha){
                while (this.posy > reilinha) {
                    this.posy--;
                    if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                        this.posy++;
                        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                        if(this.verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                            return true;
                        }
                        return false;
                    }
                }
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                if(this.verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                    return true;
                }
                return false;
    
            }else{ 
                 
                if (this.posx < reicoluna) {
                    while (this.posx < reicoluna) {
                        this.posx++;
                        if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posx--;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
        
                            if(this.verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                                return true;
                            }
                            return false;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                    if(this.verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                        return true;
                    }
                    return false;
        
                } else if(this.posx > reicoluna){
                    while (this.posx > reicoluna) {
                        this.posx--;
                        if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                            this.posx++;
                            tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                            if(this.verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                                return true;
                            }
                            return false;
                        }
                    }
                    tab.setTabuleiro(Oldlinha, Oldcoluna, this.posy, this.posx);
                    if(this.verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
                        return true;
                    }
                    return false;
                }
            }
        }else{
            if (this.posy == reilinha) {
                if (this.posx < reicoluna) {
                    while (this.posy < reicoluna && this.posx < 6) {
                        this.posy++;
                        this.posx++;
                        if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
                        if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
                        if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
                    while (this.posx > reicoluna && this.posy < 6 && this.posx > 0) {
                        this.posy++;
                        this.posx--;
                        if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
                        if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
                        if (!verificacaoMov(tab.GetTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
        }
        if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
            return true;
        }
        return false;
    }
    

    protected boolean MataRei(Sistema tab,int reiLinha, int reiColuna){
        if(tab.GetTabuleiro(reiLinha, reiColuna) instanceof Rei){
            return true;
        }
        return false;
    }
}
