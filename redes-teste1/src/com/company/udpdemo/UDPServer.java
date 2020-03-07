package com.company.udpdemo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) throws Exception{
        DatagramSocket serversocket = new DatagramSocket(9876);//determina qual porta quer

        while (true) {
            // declara buffer de recebimento
            byte[] recBuffer = new byte[1024];

            //cria datagrama a ser recebido
            DatagramPacket recPkt = new DatagramPacket(recBuffer, recBuffer.length);
            System.out.println("Esperando alguma mensagem");
            //recebimento do datagrama do host remoto(metodo bloqueante)
            serversocket.receive(recPkt);

            byte[] sendBuf = new byte[1024];
            sendBuf = "sou o servidor".getBytes();

            InetAddress IPAddress = recPkt.getAddress();
            int port = recPkt.getPort();

            DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, IPAddress, port);
            serversocket.send(sendPacket);
            System.out.println("mensagem enviada pelo servidor");
        }
    }
}
