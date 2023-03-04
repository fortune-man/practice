package Sort;
import java.util.*;

public class K번째_수 {
    private int[] answer;

    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            // length = i j k
            answer = new int[commands.length];

            for ( int index = 0; index < commands.length; index++ ) {
                int[] command = commands[index];
                copyArray(array, index, command);
            }

            return answer;
        }

        private void copyArray(int[] array, int index, int[] command) {
            int[] copy = Arrays.copyOfRange(array, command[0]-1, command[1]);
            Arrays.sort(copy);
            answer[index] = copy[command[2] - 1];
        }
    }



}
