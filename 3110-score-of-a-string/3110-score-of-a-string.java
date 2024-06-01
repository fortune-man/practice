
class Solution {
    public int scoreOfString(String s) {
        int ascii = 0;
        
        for(int i = 0; i < s.length()-1; i++){
            ascii += Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        
        return ascii;
    }
}