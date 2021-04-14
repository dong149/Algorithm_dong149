package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5052 {
    static Trie root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            boolean isCorrect = true;
            root = new Trie();
            String[] trieList = new String[n];
            for (int i = 0; i < n; i++) {
                trieList[i] =br.readLine();
                trieInsert(trieList[i]);
            }

            for(int i=0;i<n;i++){
                if(!trieSearch(trieList[i])){
                    isCorrect=false;
                    break;
                }
            }
            if (isCorrect)
                sb.append("YES").append('\n');
            else
                sb.append("NO").append('\n');

        }
        System.out.print(sb);
    }

    public static void trieInsert(String key) {

        Trie temp = root;
        int idx;
        for (int i = 0; i < key.length(); i++) {
            idx = key.charAt(i) - '0';
            if (temp.children[idx] == null) {
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
            if(temp.isEnd){
                return false;
            }
            temp = temp.children[idx];
        }
        return true;

    }
    public static class Trie {
        Trie[] children = new Trie[10];
        boolean isEnd;

        public Trie() {
            isEnd = false;
            for (int i = 0; i < 10; i++) {
                children[i] = null;
            }
        }
    }
}
