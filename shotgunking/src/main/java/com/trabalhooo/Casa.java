package com.trabalhooo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class Casa extends JButton {

    private Peca posicao;
    private int linha;
    private int coluna;
    private String peca;
    private boolean mover;

    /*
    switch (getElementoSwitch(elemento)) {
                    case 0:
                        if (setIconMov(reiLinha, reiColuna)) {
                            this.setText(".");
                            mover = true;
                            break;
                        }
                        mover = false;
                        break;
                    case 1:
                        this.setText("P");
                        break;
                    case 3:
                        this.setText("B");
                        break;
                    case 4:
                        this.setText("T");
                        break;
                    case 7:
                        this.setText("r");
                        break;
                    case 9:
                        this.setText("R");
                        break;
                }*/
    public Casa(Peca elemento, int linha, int coluna) {
        this.posicao = elemento;
        this.linha = linha;
        this.coluna = coluna;
        this.mover = false;
        if (this.linha % 2 == 0) {
            if (this.coluna % 2 == 0) {;
                this.setBackground(Color.LIGHT_GRAY);
            } else {
                this.setBackground(Color.DARK_GRAY);
            }
        } else {
            if (this.coluna % 2 == 0) {
                this.setBackground(Color.DARK_GRAY);
            } else {
                this.setBackground(Color.LIGHT_GRAY);
            }

        }

        this.setForeground(Color.WHITE);
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
    
    

    public boolean setIconMov(int reiLinha, int reiColuna) {
        if (Math.sqrt(Math.pow((this.linha - reiLinha),2)+ Math.pow((this.coluna - reiColuna),2)) == 1) {
            return true;
        }
        return false;
    }

    public void setIconNew(Peca elemento, int reiLinha, int reiColuna) {
        this.mover = false;
        switch (getElementoSwitch(elemento)) {
            case 0:
                if (setIconMov(reiLinha, reiColuna)) {
                    this.setText(".");
                    this.peca =  ".";
                    this.mover = true;
                    break;
                }
                this.setText(" ");
                this.peca = " ";
                break;
            case 1:
                this.setText("♙");
                this.peca = "♙";
                break;
            case 3:
                if (setIconMov(reiLinha, reiColuna)) {
                    this.setText(".");
                    this.mover = true;
                    break;
                }
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
                this.setForeground(Color.BLACK);
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
