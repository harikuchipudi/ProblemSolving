package org.example;

import java.util.ArrayList;
import java.util.List;

public class IpAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(s, result, curr, 0);
        return result;
    }

    public static void backtrack(String s, List<String> result, List<String> curr, int index){

        if(index==s.length()){
            if(curr.size()==4){
                String temp = "";

                for(int i=0; i<3; i++){
                    temp = temp + curr.get(i) + ".";

                }
                temp = temp + curr.get(3);
                System.out.println(temp);
                result.add(temp);
                return;
            }
        }

        if(curr.size()>=4){
            return;
        }

        for(int size=1; size<=3; size++){
            if(index+size<=s.length()){
                String curr_substring = s.substring(index, index+size);
                if(isValid(curr_substring)){
                    curr.add(curr_substring);
                    backtrack(s, result, curr, index+size);
                    curr.remove(curr.size()-1);
                }
            }
        }




    }

    public static boolean isValid(String str){
        if(str.charAt(0)=='0' && str.length()>1){
            return false;
        }
        int value = Integer.parseInt(str);
        if(value<0 || value>255){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        restoreIpAddresses("25525511135");
    }

}
