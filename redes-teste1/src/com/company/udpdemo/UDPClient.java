package com.company.udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception{

        //endereco IP do host remoto(server)
        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");

        //canal de comunicacao NAO orientado a conexao
        //clientSocket tera uma porta designada pelo SO
        //enviar e receber infos
        DatagramSocket clientSocket = new DatagramSocket(); // SO define a porta

        //declara e preenche buffer de envio
        byte[] sendData = new byte[1024];
        sendData = "sou um cliente".getBytes();

        //cria datagrama com endereco e porta do host remoto
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,9876);


        //envio do datagrama pacote ao host remoto(servidor)
        clientSocket.send(sendPacket);

        System.out.println("mensagem enviada para o servidor");

        //declaracao do buffer de recebimento se houver
        byte[] recBuffer = new byte[1024];

        //cria datagrama a ser recebido
        DatagramPacket recPkt = new DatagramPacket(recBuffer, recBuffer.length);

        //socket receba o pacote
        clientSocket.receive(recPkt);//bloqueante, esperar chegar

        //transformar a informacao que receber
        String informacao = new String(recPkt.getData(),
                recPkt.getOffset(), //IMPORTANTE --> google --> datagrampacket getoffset api --> stackoverflow, baeldung
                recPkt.getLength()
        );

        System.out.println("recebido do servidor "+ informacao);
        clientSocket.close();

    }
}
