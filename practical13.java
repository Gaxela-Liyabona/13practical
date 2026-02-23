//Start of the programm
import java.lang.Math.*;
import java.io.*;
import java.text.*;
import java.util.*;
  public class practical13{
     static class Node{ // I'll use this class to store each recorf from ulysses file 
      int key;
      String Data;
      Node(int k,String d){
        key=k;
        Data=d;
      }
      
     }
     public static void main(String[] args) {
      //Since Im working with an file(external ulysses.numbered) I'll use the try catch statement so as to ensure that my program runs succesful even in event of an unexpected error (exception)
       try {
        BufferedReader read= new BufferedReader(new FileReader("ulysses.numbered"));
        List<Node>list=new ArrayList<>();
        while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                int key = Integer.parseInt(parts[0]);
                String data = parts[1];
                list.add(new Node(key, data));
        }
        
       } catch (Exception e) {
        System.out.println("There's Exception caught");
       }
     }
  }