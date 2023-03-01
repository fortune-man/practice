package Hash;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 최대값을 구한다 : 배열 길이 / 2
// 중복이 제거된 값을 저장한다.
// 중복 제거된 값의 크기가 최대값보다 크면 최대값을, 아니라면 저장소의 크기를 반환하라
public class 폰켓몬 {
    public class Solution {
        public int solution(int[] nums) {
            int getMaxValue = nums.length / 2;
            int answer = 0;

            /**
             * int[] distinct = Arrays.stream(nums)
             *            .distinct()
             *            .toArray();
             *
             *        int deduplication = distinct.length;
             */

            Set<Integer> distinct = new HashSet<>();

            for (int num : nums) {
                distinct.add(num);
            }
            int deduplication = distinct.size();

            if (getMaxValue > deduplication) {
                answer = getMaxValue;
            }

            else { answer = deduplication; }

            return answer;

        }

    }
}
