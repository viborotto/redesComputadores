package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerConcorrente {
    public static void main(String[] args) throws Exception{
        //receptivo
        //criar mecanismo para escutar e atender conexoes pela porta 3000
        ServerSocket serverSocket = new ServerSocket(3000);

        //para nao ficar pra sempre
        while(true){
            //metodo bloqueante que cria um novo socket com o nó
            //socket no tera uma porta designada pelo SO
            //socket conexao
            System.out.println("Esperando conexao");
            Socket no = serverSocket.accept(); //bloqueante ate que chegue do cliente informacao para estabelecer conexao
            System.out.println("Conexao aceita");

            //ler algo do no recebido do cliente(THREAD)
            //apos executar volta e fica esperando nova conexao
            ThreadAtendimento thread = new ThreadAtendimento(no);
            thread.start();
            //escrever algo para o no do cliente


        }
    }
}
