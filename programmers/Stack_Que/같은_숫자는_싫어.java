package stack_que;

import java.util.*;

public class 같은_숫자는_싫어 {
     static class Solution {
        public int[] solution(int []arr) {

            Stack<Integer> repository = new Stack<>();

            for (int number : arr) {
                fillToStack(number, repository);
            }


            return convertToArray(repository);
        }

        // 변경된 스택을 배열로 변환하라
        private static int[] convertToArray (Stack<Integer> repository) {
            int[] arrayByStack = new int[repository.size()];
            int index = 0;
            // for (int i = 0; i < repository.size(); i++) {
            //     arrayByStack[i] = repository.get(i); // green
            //     arrayByStack[i] = repository.firstElement(); // red
            // }
            for ( int number : repository ) { // green
                arrayByStack[index++] = number;
            }

            return arrayByStack;
        }


        // 스택을 채워라
        // 스택이 비어있거나 또는 first-in과 일치하지 않는 경우 숫자 추가
        private static void fillToStack(int number, Stack<Integer> repository) {
            if (repository.isEmpty() || repository.peek() != number) {
                repository.push(number);
            }
        }
    }
}
