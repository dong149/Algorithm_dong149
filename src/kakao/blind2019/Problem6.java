//package kakao.blind2019;
//
//public class Problem6 {
//    public static void main(String[] args) {
//
//    }
//    public int solution(String word, String[] pages) {
//        int answer = 0;
//
//
//
//        return answer;
//    }
//    public static Page getData(String s){
//        String[] sArr = s.split("\n");
//        String[] contentArr = sArr[3].split("content=\"");
//        int defScore = 0;
//        int linkScore=0;
//        int contentIdx=0;
//        for(int i=0;i<contentArr[1].length();i++){
//            if(contentArr[1].charAt(i)=='"'){
//                contentIdx=i;
//                break;
//            }
//        }
//        String content = contentArr[1].substring(0,contentIdx);
//        for(int i=0;i<sArr.length;i++){
//            if(sArr[i].contains("href")){
//                String[] linkArr = sArr[i].split("\"");
//                String link = linkArr[1].replaceAll("https://","").replaceAll(".com","");
//                linkScore=++;
//            }
//        }
//
//
//
//
//    }
//
//
//
//    public static class Page{
//        String link;
//        int defScore;
//        int linkScore;
//
//    }
//}
