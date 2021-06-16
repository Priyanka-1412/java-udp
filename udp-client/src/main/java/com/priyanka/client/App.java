package com.priyanka.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        // Establish connection
        DatagramSocket datagramSocket = new DatagramSocket();

        InetAddress ipAddress = InetAddress.getLocalHost();
        int port = 10001;
        byte[] sendData = null;

        String input = sc.nextLine();

        sendData = input.getBytes();

        // Data packet to send data
        DatagramPacket datagramPacketSend =
                new DatagramPacket(sendData, sendData.length, ipAddress, port);

        datagramSocket.send(datagramPacketSend);

        // Receive data
        byte[] receiveData = new byte[80];

        DatagramPacket datagramPacketReceive =
                new DatagramPacket(receiveData, receiveData.length);

        datagramSocket.receive(datagramPacketReceive);

        String str = new String(datagramPacketReceive.getData());

        System.out.println(str);

        datagramSocket.close();
    }
}
