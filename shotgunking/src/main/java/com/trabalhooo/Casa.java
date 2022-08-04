package com.trabalhooo;//interface

import java.awt.Color;
import javax.swing.JButton;

public class Casa extends JButton {
    
    private Peca posicao;
    private int linha;
    private int coluna;
    private String peca;

    public Casa(Peca elemento, int linha, int coluna) {
        
        if(elemento instanceof Rei){
            this.setForeground(Color.BLACK);
        }
        else{
            this.setForeground(Color.GRAY);
        }
        
        this.posicao = elemento;
        this.linha = linha;
        this.coluna = coluna;
        if (this.linha % 2 == 0) {
            if (this.coluna % 2 == 0) {
                this.setBackground(Color.WHITE);
            } else {
                this.setBackground(Color.green);
            }
        } else {
            if (this.coluna % 2 == 0) {
                this.setBackground(Color.green);
            } else {
                this.setBackground(Color.WHITE);
            }

        }
    }

    public Peca getElemento() {
        return posicao;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }
    

    public boolean isDistantceequal(int reiLinha, int reiColuna,double val) {
        if (Math.sqrt(Math.pow((this.linha - reiLinha),2)+ Math.pow((this.coluna - reiColuna),2)) <= val) {
            return true;
        }
        return false;
    }

    public void setIconNew(Peca elemento, int reiLinha, int reiColuna) {
        this.posicao = elemento;
        switch (getElementoSwitch(elemento)) {
            case 0:
                this.setText(" ");
                this.peca = " ";
                break;
            case 1:
                this.setText("♙");
                this.peca = "♙";
                break;
            case 3:
                this.setText("♗");
                this.peca = "♗";
                break;
            case 4:
                this.setText("♖");
                this.peca = "♖";
                break;
            case 7:
                this.setText("♕");
                this.peca = "♕";
                break;
            case 9:
                this.setText("♚");
                this.peca = "rei";
                break;
        }

    }

    public int getElementoSwitch(Peca elemento) {
        if (elemento instanceof Rei) {
            return 9;
        }
        if (elemento instanceof Peao) {
            return 1;
        }
        if (elemento instanceof Bispo) {
            return 3;
        }
        if (elemento instanceof Torre) {
            return 4;
        }
        if (elemento instanceof Rainha) {
            return 7;
        }
        return 0;
    }
}
