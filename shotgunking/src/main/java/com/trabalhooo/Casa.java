package com.trabalhooo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Casa extends JButton {

    private Peca posicao;
    private int linha;
    private int coluna;

    ImageIcon iconReinoPreto = new ImageIcon(getClass().getResource("rei_no_preto.jpeg"));
    ImageIcon iconReinoBranco = new ImageIcon(getClass().getResource("rei_no_branco.jpeg"));
    ImageIcon iconPreto = new ImageIcon(getClass().getResource("preto.jpeg"));
    ImageIcon iconPretoMove = new ImageIcon(getClass().getResource("preto_move.jpeg"));
    ImageIcon iconBranco = new ImageIcon(getClass().getResource("branco.jpeg"));
    ImageIcon iconBrancoMove = new ImageIcon(getClass().getResource("branco_move.jpeg"));
    ImageIcon iconPeaonoPreto = new ImageIcon(getClass().getResource("peao_no_preto.jpeg"));
    ImageIcon iconPeaonoBranco = new ImageIcon(getClass().getResource("rei_no_branco.jpeg"));
    ImageIcon iconTorrenoPreto = new ImageIcon(getClass().getResource("torre_no_preto.jpeg"));
    ImageIcon iconTorrenoBranco = new ImageIcon(getClass().getResource("torre_no_branco.jpeg"));
    ImageIcon iconBisponoPreto = new ImageIcon(getClass().getResource("bispo_no_preto.jpeg"));
    ImageIcon iconBisponoBranco = new ImageIcon(getClass().getResource("bispo_no_branco.jpeg"));
    ImageIcon iconRainhanoPreto = new ImageIcon(getClass().getResource("rainha_no_preto.jpeg"));
    ImageIcon iconRainhanoBranco = new ImageIcon(getClass().getResource("rainha_no_branco.jpeg"));

    public Casa(Peca elemento, int linha, int coluna, int reiLinha, int reiColuna) {
        this.posicao = elemento;
        this.linha = linha;
        this.coluna = coluna;
        if (this.linha % 2 == 0) {
            if (this.coluna % 2 == 0) {
                switch (getElementoSwitch(elemento)) {
                    case 0:
                        if (setIconMov(reiLinha, reiColuna)) {
                            this.setIcon(iconBrancoMove);
                            break;
                        }
                        this.setIcon(iconBranco);
                        break;
                    case 1:
                        this.setIcon(iconPeaonoBranco);
                        break;
                    case 3:
                        this.setIcon(iconBisponoBranco);
                        break;
                    case 4:
                        this.setIcon(iconTorrenoBranco);
                        break;
                    case 7:
                        this.setIcon(iconRainhanoBranco);
                        break;
                    case 9:
                        this.setIcon(iconReinoBranco);
                        break;
                }
            } else {
                switch (getElementoSwitch(elemento)) {
                    case 0:
                        if (setIconMov(reiLinha, reiColuna)) {
                            this.setIcon(iconPretoMove);
                            break;
                        }
                        this.setIcon(iconPreto);
                        break;
                    case 1:
                        this.setIcon(iconPeaonoPreto);
                        break;
                    case 3:
                        this.setIcon(iconBisponoPreto);
                        break;
                    case 4:
                        this.setIcon(iconTorrenoPreto);
                        break;
                    case 7:
                        this.setIcon(iconRainhanoPreto);
                        break;
                    case 9:
                        this.setIcon(iconReinoPreto);
                        break;
                }

            }
        } else {
            if (this.coluna % 2 == 0) {
                switch (getElementoSwitch(elemento)) {
                    case 0:
                        if (setIconMov(reiLinha, reiColuna)) {
                            this.setIcon(iconPretoMove);
                            break;
                        }
                        this.setIcon(iconPreto);
                        break;
                    case 1:
                        this.setIcon(iconPeaonoPreto);
                        break;
                    case 3:
                        this.setIcon(iconBisponoPreto);
                        break;
                    case 4:
                        this.setIcon(iconTorrenoPreto);
                        break;
                    case 7:
                        this.setIcon(iconRainhanoPreto);
                        break;
                    case 9:
                        this.setIcon(iconReinoPreto);
                        break;
                }
            } else {
                switch (getElementoSwitch(elemento)) {
                    case 0:
                        if (setIconMov(reiLinha, reiColuna)) {
                            this.setIcon(iconBrancoMove);
                            break;
                        }
                        this.setIcon(iconBranco);
                        break;
                    case 1:
                        this.setIcon(iconPeaonoBranco);
                        break;
                    case 3:
                        this.setIcon(iconBisponoBranco);
                        break;
                    case 4:
                        this.setIcon(iconTorrenoBranco);
                        break;
                    case 7:
                        this.setIcon(iconRainhanoBranco);
                        break;
                    case 9:
                        this.setIcon(iconReinoBranco);
                        break;
                }

            }

        }
    }

    public Peca elemento() {
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

    public boolean setIconMov(int reiLinha, int reiColuna) {
        if (Math.abs(this.linha - reiLinha) == 1 || Math.abs(this.coluna - reiColuna) == 1) {
            return true;
        }
        return false;
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
