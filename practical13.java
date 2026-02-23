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
        String line;
        while ((line = read.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                int key = Integer.parseInt(parts[0]);
                String data = parts[1];
                list.add(new Node(key, data));
        } read.close();

        Node [] nodes=list.toArray(new Node [0]);//Im preparing to apply the Binary search
        Random any=new Random();
        int[] keys=new int[30]; //Array of 30 random keys
        for (int i =0;i<30;i++) {
          keys[i]=any.nextInt(32654)+1;
        


             long[] binaryTimes = new long[30]; // Here its timing for binary search 
            for (int m= 0; m < 30; m++) {
                long start = System.nanoTime();
                binarySearch(nodes, keys[m]);
                long end = System.nanoTime();
                binaryTimes[m] = end - start;
            }
            
           long[] linearTimes = new long[30];// Here I time linear search
            for (int x = 0; x< 30; x++) {
                long start = System.nanoTime();
                linearSearch(nodes, keys[x]);
                long end = System.nanoTime();
                linearTimes[x] = end - start;
            }
             
            double average_linear= average(linearTimes);
            double std_linear=stdDev(linearTimes,average_linear); //Averages and standard deviations
            double average_binary= average(binaryTimes);
            double  std_binary=stdDev(binaryTimes,average_binary);
            System.out.println(average_linear + " " + std_linear + " " + average_binary + " " + std_binary);


  


        }


       } catch (Exception e) {
        System.out.println("There's Exception caught");
       }
     }
     private static String linearSearch(Node[] nodes, int key) {
        for (Node n : nodes) {
            if (n.key == key) return n.Data;
        }
        return null;
    }

    private static String binarySearch(Node[] nodes, int key) {
        int low = 0, high = nodes.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nodes[mid].key == key) return nodes[mid].Data;
            else if (nodes[mid].key < key) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    private static double average(long[] times) {
        long sum = 0;
        for (long t : times) sum += t;
        return (double) sum / times.length;
    }

    private static double stdDev(long[] times, double avg) {
        double sum = 0;
        for (long t : times) {
            double diff = t - avg;
            sum += diff * diff;
        }
        return Math.sqrt(sum / times.length);
    }
}

  
  