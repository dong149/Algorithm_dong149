package boj;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj7568 {

    public static void main(String[] args) throws IOException {
        int n;
        int[][] arr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        for(int i=0;i<n;i++){
            String temp = br.readLine();
            String[] tempArr = temp.split(" ");
            arr[i][0] = Integer.parseInt(tempArr[0]);
            arr[i][1] = Integer.parseInt(tempArr[1]);
        }


        for(int i=0;i<n;i++){
            int rank=1;
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]){
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
}
