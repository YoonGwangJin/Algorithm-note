package dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] numbers = new int[N];
        for (int i=0; i<N; i++){
            numbers[i]=scanner.nextInt();
        }

        int storage;
        for(int i =0; i<N; i++){
            int change =0;
            for(int j =0 ;j<N-1-i; j++){
                if(numbers[j]>numbers[j+1]){
                    storage = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] =storage;
                    change++;
                }
            }
            if(change==0) break;
        }

        for (int i=0; i<N; i++){
            System.out.println(numbers[i]);
        }
    }
}
