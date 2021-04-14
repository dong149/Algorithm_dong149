package algorithm;


import java.util.Scanner;

public class TrieNode {
    static Trie root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n= sc.nextInt() ;
            for(int i=0;i<n;i++){
                int input = sc.nextInt();
                String str = String.valueOf(input);
            }

        }
    }
    public static void trieInsert(String key){

        Trie temp = root;
        int idx;
        for(int i=0;i<key.length();i++){
            idx = key.charAt(i)-'0';
            if(temp.children[idx]==null){
                temp.children[idx] = new Trie();
            }
            temp = temp.children[idx];
        }
        temp.isEnd = true;
    }

    public static boolean trieSearch(String key){
        Trie temp = root;
        int idx;
        for(int i=0;i<key.length();i++){
            idx = key.charAt(i)-'0';
            if(temp.children[idx]==null){
                return false;
            }
            temp = temp.children[idx];
        }
        return (temp!=null&&temp.isEnd);

    }

    public static class Trie{
        Trie[] children = new Trie[10];
        boolean isEnd;
        public Trie(){
            isEnd = false;
            for(int i=0;i<10;i++){
                children[i] = null;
            }
        }
    }
}
