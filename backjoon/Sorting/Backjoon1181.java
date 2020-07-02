package Algorithm.backjoon.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Word implements Comparable<Word>{
    String words;
    int word_length;

    Word(String words, int word_length){
        this.words = words;
        this.word_length = word_length;
    }

    public int compareTo(Word word){
        if(this.word_length > word.word_length){
            return 1;
        }
        else if(this.word_length == word.word_length){
            if(this.words.compareTo(word.words) > 0){
                return 1;
            }
        }

        return -1;
    }
}

public class Backjoon1181 {
    static List<Word> wordList;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int idx = 0;
        int wordSize = sc.nextInt();
        
        wordList = new ArrayList<>();

        for(int i = 0; i<wordSize; i++){
           String str = sc.next();
           int length = str.length();

           if(find(str, idx) == 1) continue;
           else{
               wordList.add(new Word(str, length));
               idx++;
           }
        }
        sc.close();

        Collections.sort(wordList);

        for(int i = 0; i<idx; i++){
            System.out.println(wordList.get(i).words);
        }
    }

    static int find(String str, int idx){
        for(int i = 0; i<idx; i++){
            if(wordList.get(i).words.equals(str)){
                return 1;
            }
        }
        return 0;
    }
}