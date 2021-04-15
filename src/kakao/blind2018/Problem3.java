package kakao.blind2018;

import java.util.LinkedList;

public class Problem3 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        int res = solution(cacheSize,cities);
        System.out.println(res);


    }
    public static LinkedList<String> cache = new LinkedList<>();
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;


        if(cacheSize==0)
            return cities.length*5;
        for(int i=0;i<cities.length;i++){
            String city = cities[i].toUpperCase();
            if(cache.remove(city)){
                cache.add(city);
                answer++;
            }else{
                if(cache.size()>=cacheSize){
                    cache.pollFirst();
                }
                cache.add(city);
                answer+=5;

            }
        }
        return answer;
    }
}

