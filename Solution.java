/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;
import java.util.*;
import java.io.*;

/**
 *
 * @author michael
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException{
        // TODO code application logic here
        try(Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter out = new PrintWriter("output.txt")){
        // TODO code application logic here
//        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int d, res =0, currentDmg =1, currentTD =0, minDmg, countC=0, cLoc=-1;
            
            d = sc.nextInt();
            String p = sc.next();
            
            char arr[] = new char[p.length()];
            arr = p.toCharArray();
            
            for(int j = 0 ; j<p.length();j++ ){
                if(arr[j]=='C'){
                    countC++;
                }
            }
            
            int locationC[] = new int[countC];
            for(int j = 0 ; j<p.length();j++ ){
                int k =0;
                if(arr[j]=='C'){
                    locationC[k] = j;
                    k++;
                }
            }
            
            minDmg = p.length()-countC;
                
            for(int l=0; l<locationC.length;l++){
                if(l==0){
                    currentTD = currentTD+locationC[l]*currentDmg;
                    
                }else{
                    currentTD = currentTD+(locationC[l]-locationC[l-1]-1)*currentDmg;
                
                }
                currentDmg = currentDmg*2;
            }                                
            
            while(d>=minDmg && currentTD > d){
                cLoc++;
                res++;
                currentTD = currentDmg*cLoc+currentDmg*2*(p.length()-cLoc-1);
            }
            
            if(d <minDmg){
                out.println("Case #" + i + ": IMPOSSIBLE");
            }else{
                if(d>=currentTD){
                    out.println("Case #" + i + ": " + res);
                }else{
                    out.println("ERROR-----------");
                }
            }
        }
    }
}
    
}
