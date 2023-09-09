import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNumber = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        
        for (int i = 0; i < testCaseNumber; i++) {
            String sentence = scanner.nextLine();
            String[] words = sentence.split(" "); // 공백을 기준으로 단어 분리
            
            StringBuilder reversedSentence = new StringBuilder();
            
            for (String word : words) {
                String reversedWord = reverseWord(word);
                reversedSentence.append(reversedWord).append(" ");
            }
            
            System.out.println(reversedSentence.toString().trim()); // 마지막 공백 제거 후 출력
        }
    }
    
    private static String reverseWord(String word) {
        StringBuilder reversed = new StringBuilder(word);
        return reversed.reverse().toString();
    }
}
