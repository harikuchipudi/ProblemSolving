package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void breaktheWord(String s, int index, List<String> wordList, List<String> curr){
        if(index==s.length() && isValid(s, new ArrayList<>(curr))){
            System.out.println(" ");
            for(String string: curr){
                System.out.print(string + " ");
            }
            return;
        }

        for(int i=index; i<s.length(); i++){
            for(int j=0; j<wordList.size(); j++){
                String curr_word = wordList.get(j);
                if(i+curr_word.length() <= s.length()){
                    String curr_substring = s.substring(i, i+curr_word.length());
                    if(curr_substring.equals(curr_word)){
                        curr.add(curr_substring);
                        breaktheWord(s, i+curr_word.length(), wordList, curr);
                        curr.removeLast();
                    }
                }
            }
        }
    }

    public static boolean isValid(String s, List<String> list){
        int count = 0;
        for(String st: list){
            count += st.length();
        }
        return count == s.length();
    }

    public static void main(String[] args){
        String s = "leetcodecodeleet";
        List<String> wordList = new ArrayList<>(Arrays.asList("leet", "code"));
        breaktheWord(s, 0, wordList, new ArrayList<>() );
    }
}
