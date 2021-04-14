package kakao;

public class LyricSearch2020 {

    public static void main(String[] args) {
        String[] words={"frodo","front","frost","frozen","frame","kakao"};
        String[] queries={"fro??","????o","fr???","fro???","pro?"};
        solution(words,queries);
    }
    public static final int ALPHA = 'z'-'a'+1;
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie[] root1,root2;
        root1 = new Trie[10001];
        root2 = new Trie[10001];

        // input
        for(int i=0;i<words.length;i++){
            int len = words[i].length();
            if(root1[len]==null){
                root1[len] = new Trie();
            }
            if(root2[len]==null){
                root2[len] = new Trie();
            }
            trieInsert(words[i],false,root1[len]);
            trieInsert(words[i],true,root2[len]);
        }


        for(int i=0;i<queries.length;i++){
            boolean isLeft=true;
            String temp = queries[i];
            if(temp.charAt(temp.length()-1)!='?'){
                isLeft=false;
            }
            if(isLeft){
                answer[i] = trieFind(queries[i],root1,false);
            }else{
                answer[i] = trieFind(queries[i],root2,true);
            }
        }





        return answer;
    }



    public static void trieInsert(String s,boolean isReverse,Trie root){
        String temp="";
        if(isReverse) {
            StringBuffer sb = new StringBuffer(s);
            temp = sb.reverse().toString();
        }else{
            temp = s;
        }

        Trie cur = root;
        int idx;
        for(int i=0;i<temp.length();i++){
            cur.count++;
            idx = temp.charAt(i)-'a';
            if(cur.children[idx]==null){
                cur.children[idx] = new Trie();
            }
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public static int trieFind(String s,Trie[] root,boolean isReverse){
        String temp="";
        if(isReverse) {
            StringBuffer sb = new StringBuffer(s);
            temp = sb.reverse().toString();
        }else{
            temp = s;
        }
        int len = temp.length();
        if(root[len]==null){
            return 0;
        }
        int res = root[len].count;
        Trie cur = root[len];
        for(int i=0;i<temp.length();i++){
            int idx = temp.charAt(i)-'a';
            if(temp.charAt(i)=='?'){
                return res;
            }else{
                if(cur.children[idx]==null)
                    return 0;
                cur = cur.children[idx];
                res = cur.count;
            }
        }
        return res;

    }


    public static class Trie{
        Trie[] children = new Trie[ALPHA];
        boolean isEnd=false;
        int count=0;

        public Trie(){
            for(int i=0;i<ALPHA;i++){
                children[i]=null;
            }
        }


    }
}
