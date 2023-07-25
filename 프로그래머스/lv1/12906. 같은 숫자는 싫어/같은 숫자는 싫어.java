import java.util.*;

// 연속 숫자 제거
public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        // arr크기만큼 반복
        for(int i=0; i<arr.length; i++) {
            // stack의 마지막으로 들어간 숫자 peek
            // stack에 값이 없는 상태에서 peek() 사용시 Exception
            if(stack.size() == 0 || arr[i] != stack.peek()) {
                // 연속하지 않는 숫자는 stack에 추가
                stack.push(arr[i]);
            }
        }
       
        // stack 크기만큼의 return용 배열 생성
        int[] answer = new int[stack.size()];
        
        // 마지막 idx부터 데이터 설정 (lifo이므로 pop()은 최상위 요소 반환)
        for(int i=stack.size()-1; i>=0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}