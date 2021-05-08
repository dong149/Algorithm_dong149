package kakao.blind2018_3;

public class Problem3 {
    public static void main(String[] args) {

        String[] words = {"go", "gone", "guild"};
        int ans = solution(words);
        System.out.println(ans);
    }

    public static int solution(String[] words) {
        int answer = 0;

        Trie root = new Trie();

        for (int i = 0; i < words.length; i++) {
            int idx = 0;
            Trie curNode = root;
            while (idx < words[i].length()) {
                int cur = words[i].charAt(idx) - 'a';
                if (curNode.arr[cur] == null) {
                    curNode.arr[cur] = new Trie();

                }
                curNode = curNode.arr[cur];
                curNode.cnt++;
                if (idx == words[i].length() - 1) {
                    curNode.isEnd = true;
                }
                idx++;
            }
        }
        for (int i = 0; i < words.length; i++) {
            Trie curNode = root;
            for (int j = 0; j < words[i].length(); j++) {
                int cur = words[i].charAt(j) - 'a';
                curNode = curNode.arr[cur];
                if (j == words[i].length() - 1 || curNode.cnt == 1) {
                    answer += (j + 1);
                    break;
                }
            }
        }


        return answer;
    }


    public static class Trie {
        Trie[] arr;
        int cnt;
        boolean isEnd;

        public Trie() {
            arr = new Trie[26];
            cnt = 0;
            isEnd = false;
        }

    }
}
