package com.trabalhooo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//Integrantes: 
//João Vítor de Castro Martins Ferreira Nogueira(202065560C), 
//Kayan Martins de Freitas(202176030), 
//Gustavo Coelho Martins(202165513B)

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


public class GerenciarRecursos {
    public static void Salvar(Serializable dados, String nomeArquivo) throws Exception {
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(nomeArquivo)))){
        oos.writeObject(dados);
        }
        }
        public static Object Consultar(String nomeArquivo) throws Exception{
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(nomeArquivo)))){
        return ois.readObject();
        }
        }
}
















/* 
public static String lerArquivo(String caminho) throws FileNotFoundException {

    StringBuilder conteudo = new StringBuilder();

    File arquivo = new File(caminho);

    Scanner leitor = new Scanner(arquivo);

    // varrendo o conteúdo do arquivo linha por linha
    while (leitor.hasNextLine()) {
        conteudo.append(leitor.nextLine()).append("\n");
    }

    return conteudo.toString();
}

public static void escreverArquivo(String caminho, String conteudo) {
    FileWriter fwArquivo;
    BufferedWriter bwArquivo;
    try {
        File arquivo = new File(caminho);

        //Se o arquivo já existir, então abrir para concatenação, caso contrário criar novo arquivo
        fwArquivo = new FileWriter(arquivo, false);
        bwArquivo = new BufferedWriter(fwArquivo);

        // escrevendo String no arquivo e adicionando caracter para criar nova linha
        bwArquivo.write(conteudo + '\n');

        // fechando o arquivo
        bwArquivo.close();
        fwArquivo.close();

    } catch (IOException e) {
        System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
    }
}
*/