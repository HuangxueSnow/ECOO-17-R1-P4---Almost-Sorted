/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almostsorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class AlmostSorted {

    /**
     * @param args the command line arguments
     */
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        for(int i=0;i<10;i++){
            dotestCase();
        }
    }

    private static void dotestCase() {
        int n = in.nextInt();
        in.nextLine();
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> sorted = new ArrayList<String>();
        for(int i=0;i<n;i++){
            String e = in.nextLine();
            list.add(e);
            sorted.add(e);
        }
        Collections.sort(sorted);
        int amount = coutMin(list,sorted);
        System.out.println(amount);
    }

    private static int coutMin(ArrayList list, ArrayList sorted) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            ArrayList<String> templi = (ArrayList<String>)list.clone();
            ArrayList<String> tempso = (ArrayList<String>)sorted.clone();
            templi.remove(list.get(i));
            tempso.remove(list.get(i));
            int c = coutP(templi,tempso);
            if(c<min)
                min = c;
        }
        return min;
    }

    private static int coutP(ArrayList<String> templi, ArrayList<String> tempso) {
        int c = 0;
        for(int i=0;i<templi.size();i++){
            String word = templi.get(i);
            int index = tempso.indexOf(word);
            if(index!=i){
                String temp = templi.get(index);
                templi.set(index, word);
                templi.set(i, temp);
                c++;
            }
        }
        return c;
    }
    
}
