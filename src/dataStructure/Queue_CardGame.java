package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 #2164
public class Queue_CardGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        //큐 생성, 초기화
        Queue<Object> card = new LinkedList<>();
        while (true) {
            if ((n = scanner.nextInt()) == -1) {
                break;
            } else {
                card.add(n);
            }
        }

        //패턴 반복, 종료
        while (card.size() >= 2) {
            //젤앞 카드 버림(first remove)
            card.poll();
            card.add(card.poll());
        }

        System.out.println(card.poll());
    }
}
