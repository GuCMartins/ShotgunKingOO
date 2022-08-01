import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Jogar implements MouseListener {

    private final Sistema tabuleiro;

    public Jogar(Sistema tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Casa casa = (Casa) me.getSource();

        if (SwingUtilities.isRightMouseButton(me)) {

            if (casa.getText().equals("")) {
                casa.setText("F");
                casa.setForeground(Color.BLUE);
                casa.setIcon(null);
            } else if (casa.getText().equals("F")) {
                casa.setText("B");
//                casa.setIcon(bomb);
//                System.out.println(new File("images\\bomb.png"));
                casa.setForeground(Color.RED);
            }else if (casa.getText().equals("B")) {
                casa.setText("");
//                casa.setIcon(bomb);
//                System.out.println(new File("images\\bomb.png"));
                casa.setForeground(Color.RED);
            }

        } else if (!casa.getText().equals("F")) {
            if (campo.isBomba(casa.getLinha(), casa.getColuna())) {
                ImageIcon bomb = new ImageIcon("images\\bomb.png");
                Image resizedImage = getScaledImage(bomb.getImage(), casa.getWidth() - 1, casa.getHeight() - 1);
                bomb.setImage(resizedImage);
                casa.setText("");
                casa.setForeground(Color.RED);

                JOptionPane.showMessageDialog(tabuleiro, "Você perdeu!");
            } else {
                casa.setText("" + campo.bombasRedor(casa.getLinha(), casa.getColuna()));
                casa.setForeground(Color.BLACK);

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