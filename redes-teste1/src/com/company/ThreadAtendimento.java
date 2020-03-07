package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadAtendimento extends Thread{

    private Socket no;

    //construtor para poder instanciar no Servidor
    public ThreadAtendimento(Socket node){
        this.no = node;
    }

    //agora posso usar o node aqui
    public void run(){
        try {
            //cria a cadeia de entrada leitura de infos do socket
            InputStreamReader is = new InputStreamReader(no.getInputStream());
            BufferedReader reader = new BufferedReader(is);

            //cria a cadeia de entrada leitura de infos do socket
            OutputStream os = no.getOutputStream();
            DataOutputStream writer = new DataOutputStream(os);

            //ler socket do cliente
            String texto = reader.readLine();//bloqueante

            //escrever resposta para o cliente
            writer.writeBytes(texto.toUpperCase() + "\n");
            //thread acaba mas servidor continua, e pode ter varios clientes rodando
            no.close();

        } catch (Exception e){
        }
    }
}
