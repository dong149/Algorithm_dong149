package algorithm;


// a 와 b를 Swap합니다.
public class Swap {
    public static void main(String[] args) {
        int a=10,b=20;
        a = getItSelf(b,b=a);
        System.out.println(a);
        System.out.println(b);
    }
    private static int getItSelf(int itself, int dummy){
        return itself;
    }
}
