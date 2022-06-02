package com.trabalhooo;
import java.util.*;

public class Jogo 
{
    public static void main(String[] args) { 
    Scanner teclado = new Scanner(System.in);    
    int nivel = 1;
        //tela inicial do jogo
    System.out.println("              BEM VINDO AO CHASE");
    System.out.println("          _____________________________");
    System.out.println("         |(Para jogar do modo correto, |");
    System.out.println("         |  ative o NumLock e use o    |");
    System.out.println("         |     teclado numérico)       |");
    System.out.println("         |_____________________________|");
    System.out.println("                  ◀ INSTRUÇÕES ▶");
    System.out.println("      ________________________________________");
    System.out.println("     |● Para vencer, fuja dos robôs e os faça |");
    System.out.println("     |colidir para se destruírem.             |");
    System.out.println("     |                                        |");
    System.out.println("     |● Sempre que dois robôs colidirem entre |");
    System.out.println("     |si, eles viram uma pilha de escombros.  |");
    System.out.println("     |Caso um robô colida com uma pilha de es-|");
    System.out.println("     |combros, ele também passa a integrá-la. |");
    System.out.println("     |                                        |");
    System.out.println("     |● A cada nível, o jogador recebe um te- |");
    System.out.println("     |letrasnporte que o permite ir até qual- |");
    System.out.println("     |quer ponto do mapa que não esteja ocupa-|");
    System.out.println("     |do por obstaculos, robôs ou pilhas de   |");
    System.out.println("     |escombros.                              |");
    System.out.println("     |Para usar, pressione + (mais) como dire-|");
    System.out.println("     |cional.                                 |");
    System.out.println("     |                                        |");
    System.out.println("     |● O jogador já inicia o jogo com um te- |");
    System.out.println("     |letranspote aleatório, que pode ser u-  |");
    System.out.println("     |sado para levá-lo para um ponto aleató- |");
    System.out.println("     |rio do mapa que não esteja ocupado.     |");
    System.out.println("     |Para usar, pressione - (menos ) como di-|");
    System.out.println("     |recional.                               |");
    System.out.println("     |                                        |");
    System.out.println("     |● Caso o jogador seja pego por algum ro-|");
    System.out.println("     |bô, a aventura acaba e o jogo termina.  |");
    System.out.println("     |________________________________________|");
    System.out.println("            __________________________");
    System.out.println("           | X= Jogador     ℝ=Robô    |");
    System.out.println("           | ▲ = Pilha de Escombros   |");
    System.out.println("           | # = Obstáculo            |");
    System.out.println("           |__________________________|");
    System.out.println("\n           Pressione Enter para começar");
    teclado.nextLine();
    }
    
    public void nivel_1(int nivel){
        Scanner teclado = new Scanner(System.in); 
        Rei jogador = new Rei();
        List<Peao> Peoes = new ArrayList<>();      
        Sistema tab = new Sistema(nivel);
        int cont=0;
        
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                if(tab.getTabuleiro(i, j)==1){
                   Peao p = new Peao(i,j,cont);
                   Peoes.add(p);
                   cont++;
                }        
            }
        }
    }
}
