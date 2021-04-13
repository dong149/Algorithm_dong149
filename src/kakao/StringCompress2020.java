package kakao;

public class StringCompress2020 {
    public static void main(String[] args) {
        String input= "aa";
        int res = solution(input);
        System.out.println(res);
    }

    public static int solution(String s) {
        int min=s.length();
        for(int i=1;i<s.length();i++){
            min = Math.min(solve(i,s),min);
        }
        return min;
    }

    public static int solve(int k,String s){
        int cur=0;
        int cnt=1;
        String res="";
        while(true){
            int next = cur+k;
            boolean check=true;
            for(int i=0;i<k;i++){
                // 같을 때
                if(next+i>=s.length()||s.charAt(next+i)!=s.charAt(cur+i)){
                    check=false;
                    break;
                }
            }
            if(!check){
                if(cnt>1)
                    res+=String.valueOf(cnt);
                if(cur+k>=s.length()){
                    res+=s.substring(cur,s.length());
                    break;
                }
                res+=s.substring(cur,cur+k);
                cur = next;
                cnt=1;
            } else{
                cnt++;
                cur = next;
            }
        }

        return res.length();
    }
}
