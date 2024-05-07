// 스스로 해결하라..
// 왜 투포인터인데

// 정수 배열의 중복을 제거하면서 순서를 보장하는 배열로 재생성후 크기를 return
import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        
        // 배열이 empty 일 경우 바로 리턴
        if (nums.length == 0) return 0;
        
        // i = 포인터 1
        // j = 포인터 2
        int i=0;
        for (int j=1; j<nums.length; j++) {
            // 포인터 1과 2가 가리키는 숫자가 다를 경우 i+1 인덱스에 포인터 2가 가리키는 숫자 삽입
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        // i는 zero 베이스이기 때문에 1을 더한 값을 리턴
        return i + 1;
    }
}
