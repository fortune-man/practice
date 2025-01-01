// 0과 1 문자열, 2개의 하위 문자열로 분할 후 최대 점수 return (null x)
// 문자열 분할 점수란? 왼쪽 하위 문자열 0의 개수, 오른쪽 하위 문자열의 1의 개수
// 
class Solution {
    public int maxScore(String s) {
        int ans = 0;

        for (int i = 0; i < s.length()-1; i++) {
            int curr = 0;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j)=='0') {
                    curr++;
                }
            }

            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    curr++;
                }
            }

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}