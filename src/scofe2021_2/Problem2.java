package scofe2021_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem2 {
    private static HashMap<String, Info> map = new HashMap<>();
    private static PriorityQueue<Edge> pq = new PriorityQueue<>(((o1, o2) -> o1.size - o2.size));

    public static class Edge {
        String start;
        String end;
        int size;

        public Edge(String start, String end, int size) {
            this.start = start;
            this.end = end;
            this.size = size;
        }
    }

    public static class Info {
        String goal;
        int rank;

        public Info(String goal, int rank) {
            this.goal = goal;
            this.rank = rank;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int n = Integer.parseInt(temp);
        for (int i = 0; i < n; i++) {
            temp = br.readLine();
            String[] tempSp = temp.split(" ");
            pq.add(new Edge(tempSp[0], tempSp[1], Integer.parseInt(tempSp[2])));
            if (!map.containsKey(tempSp[0])) {
                map.put(tempSp[0], new Info(tempSp[0], 0));
            }
            if (!map.containsKey(tempSp[1])) {
                map.put(tempSp[1], new Info(tempSp[1], 0));
            }
        }


        int cnt = 0;
        int max = map.keySet().size()-1;
        int res = 0;
        while (true) {
            if (!pq.isEmpty()) {
                Edge edge = pq.poll();
//                System.out.println(edge.size);
                String startGoal = find(edge.start);
                int startRank = map.get(startGoal).rank;
                String endGoal = find(edge.end);
                int endRank = map.get(endGoal).rank;

//
//                System.out.println("start: "+edge.start);
//                System.out.println("end: "+edge.end);
//                System.out.println("--");
//                System.out.println(startGoal);
//                System.out.println(endGoal);
//                System.out.println(startRank);
//                System.out.println(endRank);


                if (startGoal.equals(endGoal)) {
                    continue;
                } else {
                    if (startRank > endRank) {
//                        map.put(edge.end, new Info(edge.start, map.get(edge.end).rank));
                        map.put(endGoal,new Info(startGoal,map.get(endGoal).rank));
//                        map.put(startGoal,new Info(startGoal,startRank));
                    } else {
//                        map.put(edge.start, new Info(edge.end, map.get(edge.start).rank));
                        map.put(startGoal,new Info(endGoal,map.get(startGoal).rank));
//                        map.put(endGoal,new Info(endGoal,endRank));
                    }
                    if(startRank == endRank){
                        map.put(startGoal,new Info(endGoal,map.get(startGoal).rank+1));
                    }
//                    cnt++;
                    res += edge.size;
//                    System.out.println("cnt:"+cnt);
//                    System.out.println("res:"+res);
                }
            } else {
                break;
            }
//            if (cnt == max)
//                break;
        }

        System.out.println(res);

    }

    public static String find(String str) {
        if (map.get(str).goal.equals(str))
            return str;
        return find(map.get(str).goal);
    }
}
