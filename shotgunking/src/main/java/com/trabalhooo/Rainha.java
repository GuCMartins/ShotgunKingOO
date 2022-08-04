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
    
    public boolean movimenta(int reilinha, int reicoluna, Sistema tab) {
        int op = (int) Math.floor(Math.random() * (2) + 1);
        int Oldcoluna = this.posx;
        int Oldlinha = this.posy;

        if(op == 1){
            if(this.posy < reilinha){          
                while (this.posy < reilinha) {
                    this.posy++;
                    if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
                    if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
                        if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
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
        }
        if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
            return true;
        }
        return false;
    }
    

    protected boolean mataRei(Sistema tab,int reiLinha, int reiColuna){
        if(posy == reiLinha){
            boolean hasPeca = false;
            int colunaTorre = posx + 1;

            if(colunaTorre < reiColuna){
                while(colunaTorre <  reiColuna){
                    System.out.println(colunaTorre);
                    if(tab.getTabuleiro(posy, colunaTorre) != null){
                        System.out.println(tab.getTabuleiro(posy, colunaTorre).Icon);
                        hasPeca = true;
                    }
                    colunaTorre++;
                }

                if(hasPeca == false){
                    return true;
                }
            }else{
                while(colunaTorre >  reiColuna){
                    System.out.println(colunaTorre);
                    if(tab.getTabuleiro(posy, colunaTorre) != null){
                        System.out.println(tab.getTabuleiro(posy, colunaTorre).Icon);
                        hasPeca = true;
                    }
                    colunaTorre--;
                }

                if(hasPeca == false){
                    return true;
                }
            }

        }else if(posx == reiColuna){
            boolean hasPeca = false;
            int copiaLinha = posy + 1;

            if(copiaLinha < reiLinha){
                while(copiaLinha < reiLinha){
                    if(tab.getTabuleiro(copiaLinha, posx) != null){
                        hasPeca = true;
                    }
                    copiaLinha++;
                }

                if(hasPeca == false){
                    return true;
                }
            }else{
                while(copiaLinha > reiLinha){
                    if(tab.getTabuleiro(copiaLinha, posx) != null){
                        hasPeca = true;
                    }
                    copiaLinha--;
                }

                if(hasPeca == false){
                    return true;
                }
            }
            
        }else{
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
        }
        return false;
    }

    @Override
    public boolean movimentaRei(int reix, int reiy, Sistema tab, int op) {
        // TODO Auto-generated method stub
        return false;
    }
}