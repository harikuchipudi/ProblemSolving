package org.example;
import java.util.*;

public class WordSearch {
    static Set<String> set = new HashSet<>();
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for(int row = 0; row<board.length; row++){
            for(int col=0; col<board[0].length; col++){
                backtrack(board, words, result, "", row, col, board.length, board[0].length, set);
            }
        }

        return result;
    }

    public static void backtrack(char[][] board, String[] words, List<String> result, String curr, int row, int col, int rows, int cols, Set<String> set){
        if( !set.contains(curr) && isValid(curr, new ArrayList<>(Arrays.asList(words)))){
            set.add(curr);
            result.add(new String(curr));
        }

        if(row>=0 && row<rows && col >= 0 && col < cols && board[row][col] != '?'){
            char ch = board[row][col];
            board[row][col] = '?';
            backtrack(board, words, result, curr+ch, row-1, col, rows, cols, set);
            backtrack(board, words, result, curr+ch, row, col-1, rows, cols, set);
            backtrack(board, words, result, curr+ch, row+1, col, rows, cols, set);
            backtrack(board, words, result, curr+ch, row, col+1, rows, cols, set);
            board[row][col] = ch;
        }
    }

    public static boolean isValid(String s, List<String> words){
        for(String st: words){
            if(s.equals(st)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        char[][] board =  new char[4][4];
//        Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
//        Output: ["eat","oath"]

    }
}
