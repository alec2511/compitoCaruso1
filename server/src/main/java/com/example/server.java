package com.example;

import java.net.ServerSocket;
import java.net.Socket;

public class server {
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(3000);
    System.out.println("Server in ascolto sulla porta 3000");
    boolean running = true;
    
    //inizializzo la qta 
    int contatore=1;
    int biglietti=6;
    while (running) {
        // faccio connettere il server 
      Socket s = ss.accept();
      System.out.println("Client connesso");
      // gli passo i vari parametri 
      ClientHandler client = new ClientHandler(s,biglietti);
     
      contatore++;
      client.start();
    }
    ss.close();
  }
}