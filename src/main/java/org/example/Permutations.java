package org.example;

public class Permutations {
    public static void printPermutations(String s,  int index, String curr, boolean[] used){
        if(curr.length()==s.length()){
            System.out.println(curr);
            return;
        }

        for(int i=1; i<=s.length(); i++){
            if(!used[i-1]){
                used[i-1] = true;
                printPermutations(s, i, curr+s.charAt(i-1), used);
                used[i-1] = false;
            }
        }

    }

    public static void main(String[] args){
        boolean[] used = new boolean[3];
        printPermutations("123", 0, "", used);
    }
}
