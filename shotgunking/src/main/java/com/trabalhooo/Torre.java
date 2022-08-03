package com.trabalhooo;//interface

public class Torre extends Peca {// aspectos basicos da peça

    public Torre(int linha, int coluna) {// criação da peca seguindo posicoes predeterminadas
        this.posx = coluna;
        this.posy = linha;
        this.ID = 5;
        this.Icon = 'T';
        this.hp = 3;
    }

    public boolean Movimenta(int reilinha, int reicoluna, Sistema tab) {// movimentacao da peca, seguindo a logica do xadrez e
                                                            // buscando sempre igualar
        int Oldcoluna = this.posx; // primeiramente a posicao x para dps igualar a y
        int Oldlinha = this.posy;

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
        while (this.posy < reilinha) {
            this.posy++;
            if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                this.posy--;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                return true;
            }
        }
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
        while (this.posy > reilinha) {
            this.posy--;
            if (!verificacaoMov(tab.getTabuleiro(this.posy, this.posx), this.posy, this.posx)) {
                this.posy++;
                tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
                return true;
            }
        }
        tab.setTabuleiro(Oldlinha, Oldcoluna, this.posx, this.posy);
        return true;
    }

    protected boolean mataRei(Sistema tab,int reiLinha, int reiColuna){
        /*if(tab.getTabuleiro(reiLinha, reiColuna) instanceof Rei){

        if(verificaMov(Oldlinha, Oldcoluna, this.posy, this.posx) == true){
            return true;
        }*/
        return false;
    }

    public boolean Movimenta(int reix, int reiy, Sistema tab,int op){
        return true;
    }
    
    protected boolean MataRei(Sistema tab,int reiLinha, int reiColuna){
       
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

        }

        return false;
    }
}
