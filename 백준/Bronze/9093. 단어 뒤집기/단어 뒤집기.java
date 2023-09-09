import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        int testCaseNumber = user.nextInt();
        
        user.nextLine();
        
        for (int i = 0; i < testCaseNumber; i++) {
            String request = user.nextLine();
            System.out.println(response(request));
        }
        
    }
    
    private static String response(String request) {
        String[] words = request.split(" ");
        StringBuilder response = new StringBuilder();
        
        for (String word: words) {
            response
                .append(reverseToken(word))
                .append(" ");
        }
        return response.toString().trim();
    }
    
    private static String reverseToken(String token) {
        StringBuilder reverseBuilder = new StringBuilder(token);
        return reverseBuilder
            .reverse()
            .toString();
    }
}