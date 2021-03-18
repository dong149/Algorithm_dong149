package kakao;


/**
 * 2021 카카오 블라인드 메뉴 리뉴얼
 **/

// 다시 풀자.
public class MenuRenewal2021 {
//    // 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만
//    private static List<String> combination;
//    private static Map<String,Integer> map;
//    public String[] solution(String[] orders, int[] course) {
//        String[] answer = {};
//        combination = new ArrayList<>();
//        map = new HashMap<>();
//
//
//
//        //combination 에 모든 조합을 다 넣어준다.
//        for(int i=0;i<orders.length;i++){
//            char[] ordersChar = orders[i].toCharArray();
//            Arrays.sort(ordersChar);
//
//            for(int index=0;index<ordersChar.length-1;index++){
//                for(int j=0;j<course.length;j++){
//                    dfs(ordersChar,index,1,course[j],String.valueOf(ordersChar[index]));
//                }
//            }
//        }
//
//        for(String str:combination){
//            if(!map.containsKey(str)){
//                map.put(str,1);
//            }else{
//                map.put(str,map.get(str)+1);
//            }
//        }
//        List<String> keySetList = new ArrayList<>(map.keySet());
//        Collections.sort(keySetList,(o1,o2)->(map.get(o2).compareTo(map.get(o1))));
//        List<String> ansList = new ArrayList<>();
//        for(int i=0;i<course.length;i++){
//            int maxValue = 0;
//            for(String key:keySetList){
//                if(map.get(key)>=2 && key.length() == course[i]){
//                    if(map.get(key)>=maxValue){
//                        ansList.add(key);
//                        maxValue = map.get(key);
//
//                    }
//                }
//            }
//
//        }
//        Collections.sort(ansList);
////        for(String key:keySetList){
////            if(map.get(key)>=2){
////                ansList.add(key);
////            }
////        }
//
//
//        answer = ansList.toArray(new String[0]);
//
//
//        return answer;
//    }
//
//    private static void dfs(char[] arr,int idx,int length,int course,String str){
//        if(length == course){
//            combination.add(str);
//        }
//        for(int i=idx+1;i<arr.length;i++){
//            dfs(arr,i,length+1,course,str+arr[i]);
//        }
//    }
}
