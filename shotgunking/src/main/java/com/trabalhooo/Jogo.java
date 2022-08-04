//Integrantes: 
//João Vítor de Castro Martins Ferreira Nogueira(202065560C), 
//Kayan Martins de Freitas(202176030), 
//Gustavo Coelho Martins(202165513B)
package com.trabalhooo;//interface

import java.util.*;
import java.util.Scanner;
import javax.swing.*;

public class Jogo extends JFrame {

    public static Scanner teclado;
    public static int TAMANHO = 7;
    private static JPanel painel;

    public static void main(String[] args) throws Exception {
        teclado = new Scanner(System.in);
        Rei jogador = new Rei();
        int estado ;
        String texto0 = "BEM VINDO AO SHOTGUNKING";
        String texto1 = "● Para vencer, fuja das peças brancas e elimine com sua arma real.\n ● Para se movimentar, selecione o Rei e depois o local aonde deseja ir.Algumas pecas brancas tentaram te pegar, por isso use a estrategia para engana-las e destrui-las. ";
        String texto2 = "● A cada nível, mais pecas tentarao te derrotar.Porém, a cada peça destruida, o jogador ganha uma bala para pode atirar mais um dia. As pecas brancas sao destruidas ou\n quando sao atingidas pela arma ou quando o rei pula em cima delas.";
        String texto3 = "● O jogador já inicia o jogo com o pente cheio. Porém nao atire sem pensar, suas balas sao um recurso valioso.\n  ● Caso o jogador seja pego por alguma peça inimiga, ele perde uma vida e o jogo recomeça. Caso ele seja apanhado novamente, o jogo termina.";
        String texto4 = "● Antes de cada movimento, surge a opção de se executar um disparo. Caso essa opção seja escolhida,sera necessario selecionar a posicao do  inimigo que deseja alvejar.\n Caso esteja muito distante, nao sofrera dano.";

        JOptionPane.showConfirmDialog(null, texto0, "ShotgunKing", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null);
        JOptionPane.showConfirmDialog(null, texto1, "Regras", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null);
        JOptionPane.showConfirmDialog(null, texto2, "Regras", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null);
        JOptionPane.showConfirmDialog(null, texto3, "Regras", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null);
        JOptionPane.showConfirmDialog(null, texto4, "Regras", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null);

        // tela inicial do jogo

        try {
            // aqui estamos criando uma variavel do mesmo tipo do dado que foi salvo, para
            // assim em seguida essa informação poder ser recuperada/alocada na variavel e
            // apresentada ao usuário.
            SalvarDado data2 = new SalvarDado();
            data2 = (SalvarDado) GerenciarRecursos.Consultar("dados.txt");

            if (data2.fim_jogo) {
                String guardado = JOptionPane.showInputDialog(null, "Jogador, escreva seu nome:", "Salvamento",
                        JOptionPane.QUESTION_MESSAGE);
                data2.nome = guardado;
                data2.fim_jogo = false;
                data2.nivel = 1;
                GerenciarRecursos.Salvar(data2, "dados.txt");

            } else {
                JOptionPane.showConfirmDialog(null,
                        "Bem vindo novamente ao jogo, continuando de onde parou ...", "ShotgunKing",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);
                // estado = data2.nivel;
            }
        } catch (Exception e) {
            // System.out.println(""+ e.getMessage());
            SalvarDado data2 = new SalvarDado();
            data2.fim_jogo = false;
            // voce pode criar seu proprio formato aqui, ou usar o tipo .txt, se modificar
            // aqui, lembre-se de modificar o do “CARREGAR” também, pois vc quer que ele
            // busque as informações no mesmo arquivo que foi salvo.
            data2.nivel = 1;
            GerenciarRecursos.Salvar(data2, "dados.txt");
        }

        int resultado = 0;

        try {
            SalvarDado data = (SalvarDado) GerenciarRecursos.Consultar("dados.txt");
            estado = data.nivel;
            do {
                resultado = nivel(estado, jogador, teclado);
                data.hp = jogador.hp;

                if (resultado == 1) {
                    jogador.perdeHp();
                    JOptionPane.showConfirmDialog(null, "voce morreu. Perde uma vida. " + jogador.getHp() + " vidas restantes", "ShotgunKing", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null);
                    System.out.println("perdeu vida");
                    GerenciarRecursos.Salvar(data, "dados.txt");
                } else if (resultado == 3) {
                    return;
                }

                if (jogador.getHp() == 0) {
                    data.fim_jogo = true; // proxima vez que for iniciar, voltara do começo
                    GerenciarRecursos.Salvar(data, "dados.txt");
                    fimDoJogo(teclado);
                    return;
                }

                if (resultado == 0) {
                    estado++;
                    data.nivel++;
                    GerenciarRecursos.Salvar(data, "dados.txt");
                    if(estado <= 3){
                        JOptionPane.showConfirmDialog(null, "voce ganhou. Passando para proximo mapa", "ShotgunKing", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null);
                    }else{
                        JOptionPane.showConfirmDialog(null, "Parabens, voce venceu todas as fases. Fim de jogo", "ShotgunKing", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null);
                        data.nivel = 1;
                        GerenciarRecursos.Salvar(data, "dados.txt");
                    }
                }
            } while (estado <= 3);

        } catch (Exception e) {
            System.out.println("nao deu");
        }
    }

    public static int nivel(int nivel, Rei jogador, Scanner teclado) throws Exception {
        painel = new JPanel();
        List<Peca> inimigos = new ArrayList<>();
        Sistema tab = new Sistema(nivel, jogador);
        tab.setPainel(painel, jogador.getLinha(), jogador.getColuna());
        int n;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                switch (tab.getTabuleiroSwitch(tab.getTabuleiro(i, j))) {
                    case 1:
                        inimigos.add(new Peao(i, j));
                        break;
                    case 3:
                        inimigos.add(new Bispo(i, j));
                        break;
                    case 4:
                        inimigos.add(new Torre(i, j));
                        break;
                    case 7:
                        inimigos.add(new Rainha(i, j));
                        break;
                    default:
                        break;
                }
            }
        }

        n = (int) Math.floor(Math.random() * tab.getNInimigos());

        inimigos.get(n).movimenta(jogador.getLinha(), jogador.getColuna(), tab);

        SalvarDado data = (SalvarDado) GerenciarRecursos.Consultar("dados.txt");
        while (tab.getNInimigos() > 0) {

            tab.resetPainel(painel, jogador);

            String[] options = { "Desisto","Sair", "Vou jogar" };
            int option = JOptionPane.showOptionDialog(null, "Selecione assim que tomar a decisão", "Confirmação",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (option == 0) {
                boolean ver = jogador.mataRei(tab, jogador.getLinha(), jogador.getColuna());
                if (ver == true) {
                    data.fim_jogo = true; // proxima vez que for iniciar, voltara do começo
                    GerenciarRecursos.Salvar(data, "dados.txt");
                    
                    return 3;
                }
            }if(option == 1){
                data.fim_jogo = false; // proxima vez que for iniciar, voltara do começo
                    GerenciarRecursos.Salvar(data, "dados.txt");
                    return 3;

            }else {
                String[] move = { "🢀", "🢂", "🢁", "🢃", "🢄", "🢅", "🢆", "🢇", "⍟" };
                option = JOptionPane.showOptionDialog(null, "Selecione assim que tomar a decisão", "Confirmação",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, move, move[0]);

                if (option == 8 && jogador.getbalas() > 0) {
                    boolean failure = true;
                    boolean verificatiro = true;
                    int alvoLinha = 0, alvoColuna = 0;
                    while (failure) {
                        String[] op = { "Desistir do tiro", "0", "1", "2", "3", "4", "5", "6" };
                        JOptionPane.showConfirmDialog(null, "Vamos atirar. " + jogador.getbalas() + " balas restantes", "ShotgunKing", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null);
                        alvoLinha = JOptionPane.showOptionDialog(null, "Selecione linha em que o alvo se encontra:",
                                "Atirar",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                        alvoColuna = JOptionPane.showOptionDialog(null, "Selecione coluna em que o alvo se encontra:",
                                "Atirar",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                        if (alvoLinha == 0 || alvoColuna == 0) {
                            option = 10;
                            failure = false;
                            verificatiro = false;
                        }else if (tab.getTabuleiro(alvoLinha-1, alvoColuna-1) == null || Math.sqrt(Math.pow((alvoLinha-1) - jogador.getLinha(), 2) + Math.pow((alvoColuna-1) - jogador.getColuna(), 2)) > 3) {
                            JOptionPane.showConfirmDialog(null, "Alvo não alcancado/sem alvo", "Erro",JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
                        } else {
                            failure = false;
                        }
                    }

                    if(option != 8){
                        continue;
                    }

                    int confirmacao = 0;

                    for(int i = 0; i <inimigos.size();i++){
                        
                        if (inimigos.get(i).getLinha() == alvoLinha - 1 && inimigos.get(i).getColuna() == alvoColuna - 1) {
                            confirmacao = i;
                        }
                    }

                    jogador.atirar(tab, alvoLinha - 1, alvoColuna - 1, inimigos.get(confirmacao));
                } else {
                    jogador.movimentaRei(jogador.getLinha(), jogador.getColuna(), tab, option);
                    verificaPinimigo(jogador, inimigos, tab.getNInimigos());
                }

                verificavida(inimigos, tab);

                if (inimigos.size() > 0) {

                    n = (int) Math.floor(Math.random() * tab.getNInimigos());
                    try{
                        SalvarDado data2 = new SalvarDado();
                        data2 = (SalvarDado) GerenciarRecursos.Consultar("dados.txt");
                    for (int i = 0; i < inimigos.size(); i++) {
                        if (inimigos.get(i).mataRei(tab, jogador.getLinha(), jogador.getColuna()) == true) {
                            inimigos = null;
                            tab = null;
                            data2.fim_jogo = true;
                            GerenciarRecursos.Salvar(data2, "dados.txt");
                            return 1;
                        }
                    }
                }catch(Exception e){
                    System.out.println();
                }

                    if (inimigos.get(n).movimenta(jogador.getLinha(), jogador.getColuna(), tab) == false) {
                        int i = inimigos.size() - 1;
                        while (inimigos.get(i).movimenta(jogador.getLinha(), jogador.getColuna(), tab) == false
                                && i > 0) {
                            i--;
                        }
                    }
                }
            
            }
        }
    
        painel.removeAll();
        inimigos = null;
        tab = null;
        return 0;

    }

    public static void verificavida(List<Peca> inimigos, Sistema tab) {
        for (int i = 0; i < inimigos.size(); i++) {
            if (inimigos.get(i).getHp() <= 0) {
                tab.morte(inimigos.get(i).getLinha(), inimigos.get(i).getColuna(),
                        tab.getTabuleiro(inimigos.get(i).getLinha(), inimigos.get(i).getColuna()));
                inimigos.remove(i);
                tab.setNInimigos();
            }
        }
    }

    public static void verificaPinimigo(Peca jogador, List<Peca> inimigos, int nInimigos) {
        for (int i = 0; i < nInimigos; i++) {
            if (inimigos.get(i).getLinha() == jogador.getLinha()
                    && inimigos.get(i).getColuna() == jogador.getColuna()) {
                inimigos.get(i).dano(10);
                return;
            }
        }
        return;
    }

    public static void fimDoJogo(Scanner teclado) {
        JOptionPane.showConfirmDialog(null, "Você perdeu todas as vidas. Fim de jogo", "Fim de jogo", JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE, null);
    }

    public static void Salvar_info(SalvarDado data, int nivel, boolean fim_jogo, int hp) {
        try {
            data.nivel = nivel;
            data.fim_jogo = fim_jogo;
            data.hp = hp;
            GerenciarRecursos.Salvar(data, "dados.txt");
        } catch (Exception e) {
            System.out.println("é sobre isso");
        }
    }
}
