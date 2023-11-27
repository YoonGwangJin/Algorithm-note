package dataStructure;

import java.io.IOException;
import java.util.Scanner;


//백준 #10986
public class RangeSum_RemainderSum {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int answer =0;
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] inputAccumulate = new int[N];
        int[] remainder = new int[N];
        int[] count = new int[M];

        //input 누적합 저장
        inputAccumulate[0] = scanner.nextInt();
        for(int i = 1; i<N; i++){
            inputAccumulate[i] = inputAccumulate[i-1] + scanner.nextInt();
        }

        //누적합 M으로 나눈 나머지 계산(인덱스가 0에서부터 i까지의 합이 0인 경우 answer++)
        for(int i = 0; i<N; i++){
            remainder[i] = inputAccumulate[i]%M;
            if(remainder[i] == 0) answer++;

            count[remainder[i]]++;
        }

        //누적합이 같은 인덱스에서 두가지를 뽑는 경우(ex : 0에서 j까지 나머지가 5인 경우 그리고 i에서 나머지가 5이면 i+1에서 j까지의 나머지는 0이다.)
        for(int i = 0; i<M; i++){
            if(count[i]>1){
                //nC2 = n(n-1)/2
                answer = answer + ((count[i]*count[i-1])/2);
            }
        }



        System.out.println(answer);
    }
}
