package dataStructure;

public class TwoPointer {
    static int continuousSum(int num){
        //1. 변수, 배열 선언 및 초기화(count, sum, start index, end index)
        int count=1;
        int sum =0;
        int start_index =0;
        int end_index=0;

        /*
        포인터 이동원칙
        1. 숫자합이 num보다 큰 경우 -> start_index++(기존의 sum에서 start_index만큼 sum에서 제외)
        2. 숫자합이 num보다 작은 경우 -> end_index++(기존에 sum에서 end_index++한만큼 sum에 추가)
        3. 숫자합과 num이 같은경우(카운트 추가, end_index한칸 확장)
         */
        while(end_index!=num){
            if(sum>num){
                sum = sum-start_index;
                start_index++;
            } else if(sum<num){
                end_index++;
                sum =  sum+end_index;
            } else{
                count++;
                end_index++;
                sum = sum+end_index;}
        }

        return count;
    }
}
