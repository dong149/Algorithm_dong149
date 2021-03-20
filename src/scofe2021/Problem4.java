package scofe2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem4 {
    private static class Genre{
        String info;
        double val;


        public Genre(String info, double val){
            this.info = info;
            this.val = val;
        }
    }

    private static class Content{
        char genre;
        double val;
        int pr;
        int y;
        int x;

        public Content(char genre, double val,int pr,int y,int x){
            this.genre = genre;
            this.val = val;
            this.pr = pr;
            this.y = y;
            this.x = x;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Genre> gList = new ArrayList<>();
        double[] genreValList = new double[5];
        String temp = br.readLine();
        String[] splitStr;
        splitStr = temp.split(" ");
        genreValList[0] =Double.parseDouble(splitStr[0]);
        genreValList[1] =Double.parseDouble(splitStr[1]);
        genreValList[2] =Double.parseDouble(splitStr[2]);
        genreValList[3] =Double.parseDouble(splitStr[3]);
        genreValList[4] =Double.parseDouble(splitStr[4]);
//        gList.add(new Genre("A",Double.parseDouble(splitStr[0])));
//        gList.add(new Genre("B",Double.parseDouble(splitStr[1])));
//        gList.add(new Genre("C",Double.parseDouble(splitStr[2])));
//        gList.add(new Genre("D",Double.parseDouble(splitStr[3])));
//        gList.add(new Genre("E",Double.parseDouble(splitStr[4])));

        PriorityQueue<Content> pq = new PriorityQueue<>(new Comparator<Content>() {
            @Override
            public int compare(Content o1, Content o2) {
                if(o1.pr<o2.pr)
                    return 1;
                else if(o1.pr>o2.pr)
                    return -1;
                else{
                    if(genreValList[o1.genre-'A']<genreValList[o2.genre-'A']){
                        return 1;
                    }else if(genreValList[o1.genre-'A']>genreValList[o2.genre-'A'])
                        return -1;
                    else{
                        if(o1.y>o2.y)
                            return 1;
                        else if(o1.y<o2.y)
                            return -1;
                        else{
                            if(o1.x>o2.x)
                                return 1;
                            else if(o1.x<o2.x)
                                return -1;
                            else
                                return 0;
                        }
                    }
                }
            }
        });



        temp = br.readLine();
        splitStr = temp.split(" ");
        int n,m;
        n = Integer.parseInt(splitStr[0]);
        m = Integer.parseInt(splitStr[1]);
        char[][] status = new char[n][m];
        char[][] gInfo = new char[n][m];
        for(int i=0;i<n;i++){
            temp = br.readLine();
            for(int j=0;j<m;j++){
                status[i][j] = (char)temp.charAt(j);
            }
        }
        for(int i=0;i<n-1;i++){
            temp = br.readLine();
            for(int j=0;j<m;j++){
                gInfo[i][j] = (char)temp.charAt(j);
            }
        }
        for (int i = 0; i < m; i++) {
            gInfo[n - 1][i] = (char)br.read();
        }
//        public Content(char genre, double val,int pr,int y,int x){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(status[i][j]=='W'){
                }else if(status[i][j]=='O'){
                    pq.add(new Content(gInfo[i][j],genreValList[gInfo[i][j]-'A'],0,i,j));
                }else{
                    pq.add(new Content(gInfo[i][j],genreValList[gInfo[i][j]-'A'],1,i,j));
                }
            }
        }

        while(!pq.isEmpty()){
            Content content = pq.poll();
            System.out.println(content.genre+" "+content.val+" "+content.y+" "+content.x);

        }



    }

}
