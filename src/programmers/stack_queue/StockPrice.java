package programmers.stack_queue;



import java.util.Stack;

public class StockPrice {


    public static void main(String[] args) {
//        int[] test = {5,4,3,2,1};
//        int[] ans = solution(test);
        int len = 100000;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }


    private static class Price{
        int price;
        int time;
        public Price(int price,int time){
            this.price = price;
            this.time = time;

        }
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Price> st = new Stack<>();

        int time=-1;
        for(int temp: prices){
            // 비어있으면 그냥 하나 넣어준다.
            time++;
            if(st.isEmpty()){
                st.push(new Price(temp,time));
                continue;
            }

            while(true){
                // 가격이 하락했을 경우
                if(!st.isEmpty()&&st.peek().price>temp){
                    Price answerPrice = st.pop();
                    answer[answerPrice.time] = time-answerPrice.time;
                }else {
                    st.push(new Price(temp, time));
                    break;
                }
            }
        }
        while(!st.isEmpty()){
            Price temp = st.pop();
            answer[temp.time] = time-temp.time;
        }
        return answer;
    }
}
