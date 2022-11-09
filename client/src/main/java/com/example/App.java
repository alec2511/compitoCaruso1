package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception{
        try(Socket s = new Socket("localhost",3000)){
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader tast=new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pr=new PrintWriter(s.getOutputStream(),true);
           while(true){
               pr.println(tast.readLine());
               System.out.println(br.readLine());
           } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
    {

        System.out.println( "Hello World!" );
    }
}
