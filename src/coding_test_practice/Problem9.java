package coding_test_practice;

public class Problem9 {

    /*
    재귀를 이용해서 이진 검색 binarySearch 를 수행하라
     */

    static int[] arr = {1,3,5,7,8,9};
    public static void main(String[] args) {

        System.out.println(solution(0,arr.length-1,4));

    }

    public static Integer solution(int l, int r, int find) {
        if(l>r)
            return null;
        int mid = (l+r)/2;
        if(arr[mid]<find){
            return solution(mid+1,r,find);
        }else if(arr[mid]==find){
            return mid;
        }else{
            return solution(l,mid-1,find);
        }
    }
}
