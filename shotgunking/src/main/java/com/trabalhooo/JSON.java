package com.trabalhooo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSON {
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
}
