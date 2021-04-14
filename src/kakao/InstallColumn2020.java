package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InstallColumn2020 {
    public static void main(String[] args) {
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        solution(5, build_frame);
    }


//    public static Map<String, Integer> map = new HashMap<>();

    public static ArrayList<Build> buildList;

    public static int[][] solution(int n, int[][] build_frame) {

        for (int i = 0; i < build_frame.length; i++) {
            // 교차점
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            // 0->기둥 1-> 보
            int a = build_frame[i][2];
            // 0->삭제 1-> 설치
            int b = build_frame[i][3];
            boolean isPossible = false;
            if (b == 1) {

                //기둥일 때,
                if (a == 0) {
                    if (y == 0) {
                        isPossible = true;
                    } else {
                        for (int j = 0; j < buildList.size(); j++) {
                            Build cur = buildList.get(j);
                            // 아래에 기둥
                            if (cur.a == 0 && cur.y == y - 1 && cur.x == x) {
                                isPossible = true;
                                break;
                            }
                            // 아래에 보
                            if (cur.a == 1 && cur.y == y - 1) {
                                if (x - 1 >= 1 && cur.x == x - 1) {
                                    isPossible = true;
                                    break;
                                }
                                if (cur.x == x) {
                                    isPossible = true;
                                    break;
                                }
                            }
                        }
                    }
                } else { //보일 때
                    int cnt = 0;
                    for (int j = 0; j < buildList.size(); j++) {
                        Build cur = buildList.get(j);
                        // 기둥에 한쪽 끝 부분이 있을 때
                        if (cur.a == 0) {
                            if (y - 1 >= 1 && cur.x == x && cur.y == y - 1) {
                                isPossible = true;
                                break;
                            }
                            if (y - 1 >= 1 && cur.x == x + 1 && cur.y == y - 1) {
                                isPossible = true;
                                break;
                            }
                        } else {
                            if (x - 1 >= 1 && cur.x == x - 1 && cur.y == y) {
                                cnt++;
                                if (cnt >= 2) {
                                    isPossible = true;
                                    break;
                                }
                            } else if (x + 1 <= n && cur.x == x + 1 && cur.y == y) {
                                cnt++;
                                if (cnt >= 2) {
                                    isPossible = true;
                                    break;
                                }
                            }

                        }
                    }

                }
            } else { // 삭제
                //기둥일 때
                if(a==0){
                    for (int j = 0; j < buildList.size(); j++) {
                        Build cur = buildList.get(j);
                        if(cur.x==x&&cur.y==y&&cur.a==a){
                            continue;
                        }
                        //위에 기둥이 없어야함.
                        if(cur.x==x&&cur.y==y+1&&cur.a==a){
                            isPossible=false;
                            break;
                        }
                        //위에 달랑 붙어있는 보가 없어야함.
                        if(cur.a==1){

                        }

                    }

                }else{

                }
            }
            buildList.add(new Build(x, y, a));
        }

        int[][] answer = {};
        return answer;

    }

    public static class Build {
        int x;
        int y;
        int a;

        public Build(int x, int y, int a) {
            this.x = x;
            this.y = y;
            this.a = a;
        }
    }
}

