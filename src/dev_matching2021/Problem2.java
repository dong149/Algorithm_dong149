package dev_matching2021;



public class Problem2 {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows][columns];
        int input=1;
        // map을 구성합니다.
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j] = input;
                input++;
            }
        }

        for(int i=0;i<queries.length;i++){
            answer[i] = func(queries[i][0]-1,queries[i][1]-1,queries[i][2]-1,queries[i][3]-1,rows,columns);
        }


        return answer;
    }


    public static int func(int x1,int y1,int x2,int y2,int rows,int columns){
        int[][] nMap = new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                nMap[i][j] = map[i][j];
            }
        }
        int min=rows*columns;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(i==x1&&j>y1&&j<=y2){
                    nMap[i][j] = map[i][j-1];
                    min = Math.min(nMap[i][j],min);
                }else if(j==y2&&i>x1&&i<=x2){
                    nMap[i][j] = map[i-1][j];
                    min = Math.min(nMap[i][j],min);
                }else if(i==x2&&j>=y1&&j<y2){
                    nMap[i][j] = map[i][j+1];
                    min = Math.min(nMap[i][j],min);
                }else if(j==y1&&i>=x1&&i<x2){
                    nMap[i][j] = map[i+1][j];
                    min = Math.min(nMap[i][j],min);
                }

            }
        }


        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                map[i][j] = nMap[i][j];
            }
        }
//        for(int i=0;i<rows;i++){
//            for(int j=0;j<columns;j++){
//                map[i][j] = nMap[i][j];
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();


        return min;

    }
}
