package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;



public class ClientHandler extends Thread {
    
    private Socket s;
    private BufferedReader br = null;
    private PrintWriter prWr = null;
    private static int conta;
    private static int bigl;

    

    public ClientHandler(Socket sock,int b) {
       
        bigl=b;
        this.s = s;

        try {
            //  parlare
            prWr = new PrintWriter(sock.getOutputStream(), true);
            //  ascoltare
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
         prWr.println("a: prende il biglietto: d : se è disponibile q "); 
        // prWr.println("Ciao,qual'è il tuo nome"); 
         //prWr.println("Ciao,qual'è il tuo nome"); 

        try {
            //ciclo 
            while(true){
                //stringa  lettura 
                String st=br.readLine();
                //controllo per vedere i biglietti 
                if(st.equals("D")){
                    quantitadisp(prWr,bigl);
                }else  if(st.equals("A")){
                    bigl=quantitadisp(prWr,bigl);
                    s.close();
                }else if(st.equals("Q")){
                    //chiudo 
                    prWr.println("ciao ciao");
                    s.close();
                }else{
                    prWr.println(st+ " non è stato trovato");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //per vedere quanti biglietti ci sono
            public static int quantitadisp(PrintWriter prWr, int bigl) throws Exception{
                
                //controllo perchè deve essere per forza maggiore di zero 
                if(bigl>0){
                    // scrivo quanti biglietti ci sono 
                    prWr.println("ci sono "+bigl+"bigl");

                }else{
                    // se è il caso contrario allora non ci sono + biglietti
                    prWr.println(" non ci sono più biglietti");
                }
                // returno quanti biglietti ci sono 
                return bigl;
            }

            // acquisto dei biglietti 
            public static int compra( PrintWriter prw, int bigl) throws Exception{
               // la qta deve essere sempre maggiore di zero perchè sennò vuol dire che non ce ne sono 
               
                if(bigl>0){
                    // faccio una somma e aggiungo 1 biglietto 
                    bigl=bigl+1;
                    // comunico che è stato comprato il biglietto 
                    prw.println("comprato biglietto");
                }else{
                    // scrivo che non ci sono biglietti 
                    prw.println("non ci sono + biglietti");

                }
                // returno quanti biglietti ci sono 
                return bigl;

            }

        }