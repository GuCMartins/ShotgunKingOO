//Integrantes: 
//João Vítor de Castro Martins Ferreira Nogueira(202065560C), 
//Kayan Martins de Freitas(202176030), 
//Gustavo Coelho Martins(202165513B)

package com.trabalhooo;//interface

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class SalvarDado implements Serializable{

    private static final long serialVersionUID = 1L; 
//você pode escrever qualquer numero que quiser, mas tem que ser um numero do tipo long.
// é o comando usado para fazer com que as estruturas de dados possam voltar ao seu original. O que nos economiza bastante tempo, //para que não tenhamos que fazer isso manualmente.
//Agora declare as variáveis que você quer, neste exemplo:
public String nome;
public int nivel;
public boolean fim_jogo;
public int hp;

}












 /* 
    public static String toJSON(Contato contato) {
        Gson gson = new Gson();
        String json = gson.toJson(contato);
        return json;
    }

    public static String toJSON(List<Contato> contatos) {
        Gson gson = new Gson();
        String json = gson.toJson(contatos);
        return json;
    }

    public static Contato toContato(String conteudo) {
        Gson gson = new Gson();
        Contato contato = gson.fromJson(conteudo, Contato.class);

        return contato;
    }

    public static List<Contato> toContatos(String conteudo) {
        Gson gson = new Gson();
        Type pessoasTipo = new TypeToken<ArrayList<Contato>>() {
        }.getType();
        List<Contato> contatos = gson.fromJson(conteudo, pessoasTipo);

        return contatos;
    }
    
*/