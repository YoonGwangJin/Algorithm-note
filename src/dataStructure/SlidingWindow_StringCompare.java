package dataStructure;

import java.util.*;
public class SlidingWindow_StringCompare {

    private static void add(String str){
    }
    static void SlidingWindow_StringCompare(String string, int[] condition){

        int count = 0;
        //주어진 문자열 배열로 쪼갬
        String[] sArr  = string.split("");
        //현재 문자열 초기화
        String[] now = {sArr[0], sArr[1], sArr[2], sArr[3]};
        int[] compare;

        for(int i =0; i<string.length()-4; i++){
            compare = new int[]{0, 0, 0, 0};
            for(int j = 0; j<4; j++){
                if(now[j].equals("A")){
                    compare[j]++;
                } else if (now[j].equals("C")) {
                    compare[j]++;
                } else if (now[j].equals("G")) {
                    compare[j]++;
                } else if (now[j].equals("T")) {
                    compare[j]++;
                }else{}
            }

            // 조건과 비교
            boolean isMatch = true;
            for (int k = 0; k < 4; k++) {
                if (compare[k] != condition[k]) {
                    isMatch = false;
                    break;
                }
            }

            // 현재 문자열 기준으로 판단, 결과++
            if (isMatch) {
                count++;
            }

            //들어오는 나가는 문자열 업데이트
            now[i%4] = sArr[i+4];
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
         String s = "CCTGGATTG";
         int[] condition = {2,0,1,1};

         SlidingWindow_StringCompare(s, condition);
    }
}
