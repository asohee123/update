package opperator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
   
   public static void main(String[] args) {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
      
      try {
         int t = Integer.parseInt(br.readLine().trim());
         for(int i=0; i<t; i++) {
            String str[] = br.readLine().split(" ");
            wr.write(Integer.parseInt(str[0]) + Integer.parseInt(str[1]) + "\n");
         }
         wr.flush();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
