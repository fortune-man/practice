// 이미 실패했는데 왜 계속하지..??
// 오늘이 내 인생 마지막이어도 이거할건가..??
class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int n = seats.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += Math.abs(seats[i]-students[i]);
        }
        return sum;
    }
}