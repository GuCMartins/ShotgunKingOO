package com.trabalhooo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;

public class Jogar implements MouseListener {

    private final Sistema tabuleiro;
    static public int ultimoReiColuna = -1;
    static public int ultimoReiLinha = -1;
    static public Casa Inicio;
    static public Casa Final;

    public Jogar(Sistema tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Casa casa = (Casa) me.getSource();

        if (SwingUtilities.isLeftMouseButton(me)) {

            if (Math.sqrt(Math.pow((casa.getColuna() - ultimoReiColuna), 2)
                    + Math.pow((casa.getLinha() - ultimoReiLinha), 2)) <= Math.sqrt(2)) {
                Final = casa;
                Inicio.setText(" ");
                Inicio.setPeca(" ");
                Final.setText("♚");
                Final.setPeca("♚");
            }

        }

        if (SwingUtilities.isRightMouseButton(me)) {

            if (casa.getPeca().equals("rei")) {
                Inicio = casa;
                ultimoReiColuna = casa.getColuna();
                ultimoReiLinha = casa.getLinha();
            }
        }
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
