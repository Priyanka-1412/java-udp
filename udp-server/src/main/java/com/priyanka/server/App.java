package com.priyanka.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        // Server listening port
        int port = 10001;

        //Establish connection
        DatagramSocket datagramSocket = new DatagramSocket(port);

        // receive data
        byte[] receiveData = new byte[80];

        // Data packet for receiving data
        DatagramPacket datagramPacketReceive = new DatagramPacket(receiveData, receiveData.length);

        datagramSocket.receive(datagramPacketReceive);

        String str = new String(datagramPacketReceive.getData());

        System.out.println(str);

        // send data
        byte[] sendData = reverse(str.toUpperCase()).getBytes();

        // local ip address
        InetAddress ipAddress = InetAddress.getLocalHost();

        // Data packet for sending processed data back to client
        DatagramPacket datagramPacketSend = new DatagramPacket(sendData, sendData.length, ipAddress, datagramPacketReceive.getPort());

        datagramSocket.send(datagramPacketSend);
    }

    /**
     * Reverse a String
     * @param str String
     * @return String
     */
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
