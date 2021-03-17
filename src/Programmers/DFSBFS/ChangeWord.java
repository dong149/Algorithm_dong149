package Programmers.DFSBFS;

public class ChangeWord {
    private boolean[][] wordsMap;
    private boolean[] visited;
    int minDepth=Integer.MAX_VALUE;




    public int solution(String begin, String target, String[] words) {
        wordsMap = new boolean[words.length+1][words.length+1];
        visited = new boolean[words.length+1];
        int targetIdx=0;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(target)){
                targetIdx=i+1;
                break;
            }

        }
        for(int i=0;i<words.length+1;i++){
            String a="",b="";
            if(i==0){
                a = begin;
            }else{
                a = words[i-1];
            }
            for(int j=i+1;j<words.length+1;j++){
                b = words[j-1];
                if(checkString(a,b)){
                    wordsMap[i][j] = true;
                    wordsMap[j][i] = true;
                }
            }
        }

        dfs(0,wordsMap.length,0,targetIdx);


        if(minDepth==Integer.MAX_VALUE){
            return  0;
        }else{
            return minDepth;
        }
    }

    private void dfs(int idx,int n,int depth,int targetIdx){
        visited[idx] = true;

        if(idx==targetIdx){
            minDepth = Math.min(minDepth,depth);
            return;
        }
        for(int i=0;i<n;i++){
            if(wordsMap[idx][i]&&!visited[i]){
                dfs(i,n,depth+1,targetIdx);
                visited[i] = false;
            }
        }
    }

    private boolean checkString(String a,String b){
        int cnt=0;
        char[] aList = a.toCharArray();
        char[] bList = b.toCharArray();

        for(int i=0;i<a.length();i++){
            if(aList[i]==bList[i])
                cnt++;
        }
        if(cnt==a.length()-1)
            return true;
        else
            return false;
    }
}
