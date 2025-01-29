package org.example;

public class WildCartMatching {

    public static void isMatch(String a, String b){
        if(recur(a, b, 0, 0)==true){
            System.out.println("True");
        }
        else {
            System.out.println("false");
        }
    }

    public static boolean recur(String s, String p, int i, int j){
        if(j==p.length()){
            return i == s.length();
        }

        if( i<s.length() && j<p.length() &&  (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
            return recur(s, p, i+1, j+1);
        }
        else{
            if(p.charAt(j)=='*'){
                return recur(s, p, i, j+1) || (i<s.length() && recur(s, p, i+1, j));
            }
        }
        return false;
    }

    public static void main(String[] args){
        isMatch("abcccc", "a?c*");
    }

}
