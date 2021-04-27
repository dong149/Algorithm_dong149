package boj;

import java.util.*;
import java.util.regex.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class Boj5430 {
    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = Integer.parseInt(sc.nextLine());

        Pattern p = Pattern.compile("\\b([0-9]+)\\b");

        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();
            String s = sc.nextLine();
            int n = Integer.parseInt(sc.nextLine());
            ArrayList<Integer> arr = new ArrayList<>();
            String input = sc.nextLine();
            Matcher ma = p.matcher(input);
            while (ma.find()) {
                arr.add(Integer.parseInt(ma.group()));
            }
            boolean mode = true;
            boolean isPossible = true;
            int start = 0;
            int end = arr.size();
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (cur == 'R')
                    mode = !mode;
                else {
                    if (mode) {
                        if (start==end) {
                            isPossible = false;
                            break;
                        }
                        start++;
                    } else {
                        if (start==end) {
                            isPossible = false;
                            break;
                        }
                        end--;
                    }
                }

            }
            if (!isPossible) {
                sb.append("error").append('\n');
            } else {
                sb.append('[');
                if (mode) {
                    for (int i = start; i < end; i++) {
                        sb.append(arr.get(i));
                        if (i != end-1) {
                            sb.append(',');
                        }
                    }
                } else {
                    for (int i = end - 1; i >= start; i--) {
                        sb.append(arr.get(i));
                        if (i != start) {
                            sb.append(',');
                        }
                    }
                }

                sb.append(']').append('\n');
            }
            System.out.print(sb);
        }


    }


}

