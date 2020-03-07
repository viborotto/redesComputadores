package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception {

        //Tenta criar uma conexao com host remoto "127.0.0.1" na porta 3000
        //Soscket s tera uma porta designada pelo SO do servidor
        Socket s = new Socket("127.0.0.1", 3000);

        //cria a cadeia de saida da escrita de informacoes pelo socket
        OutputStream os = s.getOutputStream();
        DataOutputStream writer = new DataOutputStream(os);

        //cria a cadeia de entrada leitura de informacoes pelo socket
        InputStreamReader is = new InputStreamReader(s.getInputStream());
        BufferedReader reader = new BufferedReader(is);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        String texto = inFromUser.readLine();//bloqueante

        writer.writeBytes(texto + "\n");

        //agora precisa ler esse texto do socket
        String response = reader.readLine();//metodo bloqueante, o codigo vai ficar travado ate capturar infos do teclado, ate resposta
        System.out.println("DoServidor:" + response);

        s.close();
    }
}
