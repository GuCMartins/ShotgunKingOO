package com.trabalhooo;

import java.util.*;
import java.util.Scanner;
import java.io.IOException;

public class Jogo {

    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        
            /* 
            data.nivel = teclado.nextInt();
            teclado.nextLine();
            data.nome = teclado.nextLine();
            try {
            GerenciarRecursos.Salvar(data, "dados.txt");//voce pode criar seu proprio formato aqui, ou usar o tipo .txt, se modificar aqui, lembre-se de modificar o do “CARREGAR” também, pois vc quer que ele busque as informações no mesmo arquivo que foi salvo.
            }
            catch(Exception e) {
            System.out.println("Could’t save: "+ e.getMessage());
            }
            
            try {
            //aqui estamos criando uma variavel do mesmo tipo do dado que foi salvo, para assim em seguida essa informação poder ser recuperada/alocada na variavel e apresentada ao usuário.
            SalvarDado data2 = (SalvarDado) GerenciarRecursos.Consultar("dados.txt");
            System.out.println(data2.nivel);
            System.out.println(data2.nome);
            }
            catch(Exception e) {
            System.out.println("Couldn't load save data: "+ e.getMessage());
            }

            */
            

        
        
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

        try {
            //aqui estamos criando uma variavel do mesmo tipo do dado que foi salvo, para assim em seguida essa informação poder ser recuperada/alocada na variavel e apresentada ao usuário.
            SalvarDado data2 = new SalvarDado();
            data2 = (SalvarDado) GerenciarRecursos.Consultar("dados.txt");

            if(data2.fim_jogo){
            System.out.println("Jogador, escreva seu nome:");
            data2.nome = teclado.nextLine();
            data2.fim_jogo = false;
            GerenciarRecursos.Salvar(data2, "dados.txt");

            }
            else {
                System.out.println("Bem vindo novamente ao jogo,"+ data2.nome +" continuando de onde parou ...");
               // estado = data2.nivel;
            }
            }
            catch(Exception e) {
            //System.out.println(""+ e.getMessage());
                SalvarDado data2 = new SalvarDado();
                data2.fim_jogo = false;
                //voce pode criar seu proprio formato aqui, ou usar o tipo .txt, se modificar aqui, lembre-se de modificar o do “CARREGAR” também, pois vc quer que ele busque as informações no mesmo arquivo que foi salvo.
                System.out.println("Jogador novo, escreva seu nome:");
                data2.nome = teclado.nextLine();
                data2.nivel = 1;
                GerenciarRecursos.Salvar(data2, "dados.txt");
            }
            
        Rei jogador = new Rei();
        int resultado = 0, ver;
        try{
            SalvarDado data = (SalvarDado) GerenciarRecursos.Consultar("dados.txt");
            int estado = data.nivel;
        do {
            ver = nivel(estado, jogador);
            data.hp = jogador.hp;
            if(ver != 0){
                jogador.perdeHp();
                System.out.println("perdeu vida");
                data.hp--;
                GerenciarRecursos.Salvar(data, "dados.txt");
            }

            if (jogador.GetHp()==0) {
                FimDoJogo();
                data.fim_jogo = true; //proxima vez que for iniciar, voltara do começo
                data.hp = 2; //volta a vida ao valor inicial
                data.nivel = 1; //volta para o nivel 1
                GerenciarRecursos.Salvar(data, "dados.txt");

                
                return;
            }

        estado++;
        data.nivel++;
        
        GerenciarRecursos.Salvar(data, "dados.txt");
        do {
            ver = nivel(estado, jogador);
            if(ver != 0){
                jogador.perdeHp();
                data.hp--;
                System.out.println("perdeu vida");
                GerenciarRecursos.Salvar(data, "dados.txt");
            }
            resultado += ver;
            if (jogador.GetHp()==0) {
                FimDoJogo();
                data.fim_jogo = true; //proxima vez que for iniciar, voltara do começo
                data.hp = 2; //volta a vida ao valor inicial
                data.nivel = 1; //volta para o nivel 1
                GerenciarRecursos.Salvar(data, "dados.txt");
                return;
            }
        } while (ver != 0);
    }
 catch(Exception e) {
    System.out.println("nao deu");
    }
}
    public static int nivel(int nivel, Rei jogador) {
        Scanner teclado = new Scanner(System.in);
        List<Peca> inimigos = new ArrayList<>();
        Sistema tab = new Sistema(nivel,jogador);
        boolean ver;
        int n;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                switch (tab.GetTabuleiroSwitch(tab.GetTabuleiro(i, j))) {
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

        while (tab.GetNInimigos() > 0) {

            tab.impressaotabuleiro(tab, nivel, jogador);

            ver = VerificaAtirar(teclado, jogador, tab, inimigos);

            if (ver == false) {

                jogador.Movimenta(jogador.GetLinha(), jogador.GetColuna(), tab);

                verificaPinimigo(jogador, inimigos, tab.GetNInimigos());
            }

            verificavida(inimigos, tab);
            

            cls();

 

            if (inimigos.size() > 0) {

                n = (int) Math.floor(Math.random() * tab.GetNInimigos());


                for (int i = 0; i < inimigos.size(); i++) {
                    if (inimigos.get(i).MataRei(tab, jogador.GetLinha(), jogador.GetColuna()) == true) {
                        inimigos=null;
                        tab=null;
                        return 1;
                    }
                }

                if(inimigos.get(n).Movimenta(jogador.GetLinha(), jogador.GetColuna(), tab) == false){
                    int i = inimigos.size() - 1;
                    while(inimigos.get(i).Movimenta(jogador.GetLinha(), jogador.GetColuna(), tab) == false && i>0){
                        i--;
                    }
                }
            }

        }
        return 0;
    }

    

    public static void verificavida(List<Peca> inimigos, Sistema tab) {
        for (int i = 0; i < inimigos.size(); i++) {
            if (inimigos.get(i).GetHp() <= 0) {
                tab.Morte(inimigos.get(i).GetLinha(), inimigos.get(i).GetColuna(), tab.GetTabuleiro(inimigos.get(i).GetLinha(), inimigos.get(i).GetColuna()));
                inimigos.remove(i);
                tab.SetNInimigos();
            }
        }
    }

    public static boolean verificaPRei(Peca jogador, Peca inimigo) {
        if (inimigo.GetLinha() == jogador.GetLinha() && inimigo.GetColuna() == jogador.GetColuna()) {
            return true;
        }
        return false;
    }

    public static void verificaPinimigo(Peca jogador, List<Peca> inimigos, int nInimigos) {
        for (int i = 0; i < nInimigos; i++) {
            if (inimigos.get(i).GetLinha() == jogador.GetLinha() && inimigos.get(i).GetColuna() == jogador.GetColuna()) {
                inimigos.get(i).Dano(10);
                return;
            }
        }
        return;
    }

    public static void FimDoJogo() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Voce Perdeu!!");
        System.out.println("Pressione Enter para terminar o jogo");
        teclado.nextLine();
    }

    public static void cls() {
        for (int i = 0; i < 50; i++) // Default Height of cmd is 300 and Default width is 80
        {
            System.out.println("\b"); // Prints a backspace
        }
    }

    public static boolean VerificaAtirar(Scanner teclado, Rei jogador, Sistema tab, List<Peca> inimigos) {
        System.out.println("Deseja atirar nesse turno(pressione 'x' e Enter para atirar): ");
        String op = teclado.nextLine();
        if (op.equals("x")) {
            System.out.println("Insira a linha onde o inimigo se encontra:");
            int alvolinha = teclado.nextInt();
            System.out.println("Insira a coluna onde o inimigo se encontra:");
            int alvocoluna = teclado.nextInt();
            double distancia = Math
                    .sqrt(Math.pow(alvolinha - jogador.GetLinha(), 2) + Math.pow(alvocoluna - jogador.GetColuna(), 2));
            int continua;
            while (distancia > 3 || tab.GetTabuleiro(alvolinha, alvocoluna) == null) {
                System.out.println(
                        "Posicionamento muito distante ou sem inimigos.Deseja continuar atirando?(se deseja, insira 1):");
                continua = teclado.nextInt();
                if (continua == 1) {
                    System.out.println("Insira a linha onde o inimigo se encontra:");
                    alvolinha = teclado.nextInt();
                    System.out.println("Insira a coluna onde o inimigo se encontra:");
                    alvocoluna = teclado.nextInt();
                    distancia = Math.sqrt(Math.pow(alvolinha - jogador.GetLinha(), 2)
                            + Math.pow(alvocoluna - jogador.GetColuna(), 2));
                } else {
                    return false;
                }
            }
            int i = 0;

            while (!(inimigos.get(i).GetLinha() == alvolinha && inimigos.get(i).GetColuna() == alvocoluna)) {
                i++;
            }

            jogador.Atirar(tab, alvolinha, alvocoluna, inimigos.get(i));
            return true;
        }
        return false;
    }



    public static void Salvar_info(SalvarDado data,int nivel, boolean fim_jogo,int hp) {
        try {
            data.nivel = nivel;
            data.fim_jogo = fim_jogo;
            data.hp = hp;
            GerenciarRecursos.Salvar(data, "dados.txt");
            }
            catch(Exception e) {
            System.out.println("é sobre isso");
            }
    }
}

