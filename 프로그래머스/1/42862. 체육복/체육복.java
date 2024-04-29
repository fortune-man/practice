class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        
        // 체육복을 도난당한 학생들은 -1로 표시
        for (int l : lost) {
            students[l - 1]--;
        }
        
        // 체육복 여분을 가진 학생들은 +1로 표시
        for (int r : reserve) {
            students[r - 1]++;
        }
        
        // 체육복을 빌려줄 수 있는 학생들 처리
        for (int i = 0; i < n; i++) {
            if (students[i] == -1) {
                if (i > 0 && students[i - 1] == 1) {
                    students[i]++;
                    students[i - 1]--;
                } else if (i < n - 1 && students[i + 1] == 1) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }
        
        // 체육복이 있는 학생 수 계산
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (students[i] >= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
