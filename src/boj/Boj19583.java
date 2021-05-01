package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



/**
 * 학회원의 입장 확인 여부를 확인한다.
 * 입장 여부는 개강총회가 시작한 시간 이전에 대화를 한 적이 있는지 닉네임을 보고
 * 시작하자마자 채팅 기록을 남긴 경우도 확인
 * 퇴장 확인 여부
 */
public class Boj19583 {
    static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] time = br.readLine().split(" ");
        int start = getTime(time[0]);
        int end = getTime(time[1]);
        int sEnd = getTime(time[2]);
        int ans=0;
        String input="";
        while((input=br.readLine())!=null){
            String[] p = input.split(" ");
            int pTime = getTime(p[0]);
            String pName = p[1];
            if(pTime<=start){
                map.put(pName,map.getOrDefault(pName,1));
            }
            if(pTime>=end&&pTime<=sEnd){
                if(map.containsKey(pName)){
                    map.put(pName,2);
                }
            }
        }
        for(String key:map.keySet()){
            if(map.containsKey(key)&&map.get(key)==2){
                ans++;
            }
        }


        System.out.println(ans);


    }
    public static int getTime(String s){
        String[] sArr = s.split(":");
        return Integer.parseInt(sArr[0])*60+Integer.parseInt(sArr[1]);
    }
}
