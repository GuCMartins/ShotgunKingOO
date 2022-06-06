package com.trabalhooo;
import java.util.*;

public class Jogo 
{
    public static void main(String[] args) { 
    Scanner teclado = new Scanner(System.in);    
    int nivel = 1;
        //tela inicial do jogo
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
    System.out.println("     |________________________________________|");
    System.out.println("                                             ");
    System.out.println("\n           Pressione Enter para começar");
    teclado.nextLine();

    Rei jogador = new Rei();
    int resultado;
    resultado = nivel_1(nivel,jogador);
    if(resultado==0){
        //imprimir o fim do jogo com uma funcao do sistema
    }




    }
    
    public static int nivel_1(int nivel,Rei jpgador){
        Scanner teclado = new Scanner(System.in); 
        List<Peao> Peoes = new ArrayList<>();      
        Sistema tab = new Sistema(nivel);
        int cont=0;
        
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(tab.getTabuleiro(i, j)==1){
                    Peoes.add(new Peao(i, j,cont));
                    cont++;
                }       
            }
        }


        return 1;
    }
}
