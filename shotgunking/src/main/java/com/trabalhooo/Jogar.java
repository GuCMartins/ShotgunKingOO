package com.trabalhooo;//interface

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

public class Jogar implements MouseListener {

    public Sistema tabuleiro;
    public Jogo jogo;
    static public int ultimoReiColuna = -1;
    static public int ultimoReiLinha = -1;
    static public Casa ultimoRei = null;

    public Jogar(Sistema tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Casa casa = (Casa) me.getSource();

        // JOptionPane.showMessageDialog(null, "opa");

        double tiro = 3;
        double dist = Math.sqrt(2);

        if (SwingUtilities.isLeftMouseButton(me)) {
            System.out.println("Da casa" + casa.getLinha() + ", " + casa.getColuna() + ", " + casa.getPeca());
            System.out.println("Da casa" + ultimoReiLinha + ", " + ultimoReiColuna);

            if (casa.isDistantceequal(ultimoReiLinha, ultimoReiColuna, dist)) {
                casa.setText("♚");
                System.out.println("chegou");
                ultimoRei.setText(" ");
                System.out.println("Mandando o rei andar:" + ultimoReiLinha + ", " + ultimoReiColuna);
                ultimoRei.getElemento().movimentaRei(ultimoReiLinha, ultimoReiColuna, tabuleiro,
                        decideMov(casa.getLinha(), casa.getColuna()));
            }
            if (casa.getPeca().equals("rei")) {
                System.out.println("entrou");
                ultimoReiColuna = casa.getColuna();
                ultimoReiLinha = casa.getLinha();
                ultimoRei = casa;
                casa.setPeca(" ");
            }
        }

        if (SwingUtilities.isRightMouseButton(me)) {
            if (ultimoRei != null) {
                if (casa.isDistantceequal(ultimoReiLinha, ultimoReiColuna, tiro) && casa.getElemento() != null) {
                    ultimoRei.getElemento().atirar(tabuleiro, casa.getLinha(), casa.getColuna(), casa.getElemento());
                }
            }
        }
    }

    public int decideMov(int linha, int coluna) {
        int op = 0;
        if (linha == (ultimoReiLinha + 1) && coluna == (ultimoReiColuna - 1)) {
            op = 1;
        }
        if (linha == (ultimoReiLinha + 1) && coluna == ultimoReiColuna) {
            op = 2;
        }
        if (linha == (ultimoReiLinha + 1) && coluna == (ultimoReiColuna + 1)) {
            op = 3;
        }
        if (linha == ultimoReiLinha && coluna == (ultimoReiColuna - 1)) {
            op = 4;
        }
        if (linha == ultimoReiLinha && coluna == (ultimoReiColuna + 1)) {
            op = 6;
        }
        if (linha == (ultimoReiLinha - 1) && coluna == (ultimoReiColuna - 1)) {
            op = 7;
        }
        if (linha == (ultimoReiLinha - 1) && coluna == ultimoReiColuna) {
            op = 8;
        }
        if (linha == (ultimoReiLinha - 1) && coluna == (ultimoReiColuna + 1)) {
            op = 9;
        }
        return op;
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}