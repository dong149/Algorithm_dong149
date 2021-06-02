package a.timetest;



/*
 결론, 역시 단일 스레드에서는 StringBuilder가 우세하다.
 */


public class TimeTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<100000;i++){
            sb.append("g");
        }
        reverseAll(sb.toString());
    }

    public static void reverseAll(String str) {
        reverseString1(str);
        reverseString2(str);
        reverseString3(str);
    }


    public static void reverseString1(String str) {
        long before = System.currentTimeMillis();

        //전체길이에서 0인덱스를 포함해 i--를 이용해 반대로 읽어나갑니다.
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();

        long after = System.currentTimeMillis();
        System.out.println("1번 : " + (after - before) + "ms");
    }

    public static void reverseString2(String str) {
        long before = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer(str);
        System.out.println(sb.reverse());
        long after = System.currentTimeMillis();
        System.out.println("2번 : " + (after - before) + "ms");
    }

    public static void reverseString3(String str) {
        long before = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse());
        long after = System.currentTimeMillis();
        System.out.println("3번 : " + (after - before) + "ms");
    }


}
