package com.trabalhooo;

import java.util.*;
import java.util.Scanner;
import java.io.IOException;

public class Jogo {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        int nivel = 1;
        // tela inicial do jogo
        System.out.println("              BEM VINDO AO SHOTGUNKING");
        System.out.println("          _____________________________");
        System.out.println("         |(Para jogar do modo correto, |");
        System.out.println("         |  ative o NumLock e use o    |");
        System.out.println("         |     teclado numérico)       |");
        System.out.println("         |_____________________________|");
        System.out.println("                  ◀ INSTRUÇÕES ▶");
        System.out.println("      ________________________________________");
        System.out.println("     |● Para vencer, fuja das peças brancas e |");
        System.out.println("     |elimine com sua arma real.              |");
        System.out.println("     |                                        |");
        System.out.println("     |● Para se movimentar, escolha um dos    |");
        System.out.println("     |direcionais e o Rei se move nessa dire- |");
        System.out.println("     |ção. Algumas pecas brancas tentaram te  |");
        System.out.println("     |pegar, por isso use a estrategia para   |");
        System.out.println("     |engana-las e destrui-las.               |");
        System.out.println("     |                                        |");
        System.out.println("     |● A cada nível, mais pecas tentarao te  |");
        System.out.println("     |derrotar.Porém, a cada peça destruida, o|");
        System.out.println("     |jogador ganha uma bala para pode atirar |");
        System.out.println("     |mais um dia. As pecas brancas sao des-  |");
        System.out.println("     |truidas ou sendo atingidas pela arma ou |");
        System.out.println("     |quando o rei pula em cima delas.        |");
        System.out.println("     |Para atirar, pressione + (mais) como di-|");
        System.out.println("     |recional.                               |");
        System.out.println("     |                                        |");
        System.out.println("     |● O jogador já inicia o jogo com o pente|");
        System.out.println("     |cheio. Porém nao atire sem pensar, suas |");
        System.out.println("     |suas balas sao um recurso valioso.      |");
        System.out.println("     |                                        |");
        System.out.println("     |● Caso o jogador seja pego por alguma   |");
        System.out.println("     |peça inimiga, ele perde uma vida e o jo-|");
        System.out.println("     |go recomeça. Caso ele seja apanhado no- |");
        System.out.println("     |vamente, o jogo termina.                |");
        System.out.println("     |                                        |");
        System.out.println("     |● Antes de cada movimento, surge a opção|");
        System.out.println("     |de se executar um disparo. Caso essa op-|");
        System.out.println("     |ção seja escolhida(usando a tecla +),   |");
        System.out.println("     |sera necessario selecionar a posicao do |");
        System.out.println("     |inimigo que deseja alvejar. Caso esteja |");
        System.out.println("     |muito distante, nao sofrera dano.       |");
        System.out.println("     |________________________________________|");
        System.out.println("                                             ");
        System.out.println("\n           Pressione Enter para começar");
        teclado.nextLine();
        cls();
        Rei jogador = new Rei();
        int resultado;
        resultado = nivel_1(nivel, jogador);
        if (resultado == 0) {
            FimDoJogo();
            return;
        }

    }

    public static int nivel_1(int nivel, Rei jogador) {
        Scanner teclado = new Scanner(System.in);
        List<Peao> Peoes = new ArrayList<>();
        List<Torre> torres = new ArrayList<>();
        List<Bispo> bispos = new ArrayList<>();
        Rainha Queen = null;
        Sistema tab = new Sistema(nivel);
        String op;
        int n;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (tab.getTabuleiroSwitch(tab.getTabuleiro(i, j)) == 1) {
                    Peoes.add(new Peao(i, j));
                }
            }
        }

        while (tab.getNInimigos() > 0) {

            n = (int) Math.floor(Math.random() * (2) + 1);

            Peoes.get(n).Movimenta(jogador.getX(), jogador.getY(), tab);

            tab.impressaotabuleiro(tab, nivel, jogador.getbalas());

            VerificaAtirar(teclado, jogador,tab);

            jogador.Movimenta(jogador.getX(), jogador.getY(), tab);

            verificavidaP(Peoes.size(), Peoes, tab);
            cls();
        }

        return 1;
    }

    public static void verificavidaP(int tam, List<Peao> Peoes, Sistema tab) {
        for (int i = 0; i < tam; i++) {
            if (Peoes.get(i).getHp() <= 0) {
                tab.Morte(Peoes.get(i).getX(), Peoes.get(i).getY());
                Peoes.remove(i);
                tab.setNInimigos();
            }
        }
    }

    public static void verificavidaT(int tam, List<Torre> Torres, Sistema tab) {
        for (int i = 0; i < tam; i++) {
            if (Torres.get(i).getHp() <= 0) {
                tab.Morte(Torres.get(i).getX(), Torres.get(i).getY());
                Torres.remove(i);
                tab.setNInimigos();
            }
        }
    }

    public static void verificavidaB(int tam, List<Torre> Bispos, Sistema tab) {
        for (int i = 0; i < tam; i++) {
            if (Bispos.get(i).getHp() <= 0) {
                tab.Morte(Bispos.get(i).getX(), Bispos.get(i).getY());
                Bispos.remove(i);
                tab.setNInimigos();
            }
        }
    }

    public static void verificavidaR(Rainha Queen, Sistema tab) {
        if (Queen.getHp() <= 0) {
            tab.Morte(Queen.getX(), Queen.getY());
            Queen = null;
            tab.setNInimigos();
        }
    }

    public static void FimDoJogo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Voce Perdeu!!");
        System.out.println("Pressione Enter para terminar o jogo");
        teclado.nextLine();
    }

    public static void cls() {
        for (int i = 0; i < 50; i++) // Default Height of cmd is 300 and Default width is 80
            System.out.println("\b"); // Prints a backspace
    }

    public static void VerificaAtirar(Scanner teclado,Rei jogador, Sistema tab){
        System.out.println("Deseja atirar nesse turno(pressione 'x' e Enter para atirar): ");
        String op = teclado.nextLine();
        if (op.equals("x")) {
            System.out.println("Insira a coluna onde o inimigo se encontra:");
            int alvox = teclado.nextInt();
            System.out.println("Insira a linha onde o inimigo se encontra:");
            int alvoy = teclado.nextInt();
            double distancia = Math.sqrt(Math.pow(alvox - jogador.getX(), 2) + Math.pow(alvoy - jogador.getY(), 2));
            int continua;
            while (distancia > 3 || tab.getTabuleiro(alvox, alvoy) == null) {
                System.out.println(
                        "Posicionamento muito distante ou sem inimigos.Deseja continuar atirando?(se deseja, insira 1):");
                continua = teclado.nextInt();
                if (continua == 1) {
                    System.out.println("Insira a linha onde o inimigo se encontra:");
                    alvoy = teclado.nextInt();
                    System.out.println("Insira a coluna onde o inimigo se encontra:");
                    alvox = teclado.nextInt();
                    distancia = Math.sqrt(Math.pow(alvox - jogador.getX(), 2) + Math.pow(alvoy - jogador.getY(), 2));
                } else
                    return;
            }
            jogador.Atirar(tab,alvoy,alvox);
        }
    }    
}
