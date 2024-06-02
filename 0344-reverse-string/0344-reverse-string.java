// 기능 목록 정의
// 스택을 생성한다
// 스택에 배열의 요소를 추가한다
// 스택의 가장 최근 추가된 데이터를 pop
class Solution {
    public void reverseString(char[] s) {
        Stack<Character> stack = new Stack();
        
        for (char element : s) {
            stack.push(element);
        }
        
        for (int i = 0; i < s.length; i++) {
            s[i] = stack.remove(stack.size() - 1);
        }
        
        System.out.println(s);
        
    }
}