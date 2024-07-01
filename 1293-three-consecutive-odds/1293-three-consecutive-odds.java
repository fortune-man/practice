// 홀수가 3번 연속되면 true를 return 하는 프로그램
// 3연속 인덱스의 홀수 검증 기능

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        final int LENGTH = arr.length-2;
        
        for (int i = 0; i < LENGTH; i++){
            if (validOdd(arr[i]) && validOdd(arr[i+1]) && validOdd(arr[i+2])) {
                return true;
            }
        }
        return false;
        
    }

    private boolean validOdd(int index) {
        return index % 2 != 0;
    }
}