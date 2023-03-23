package challenge;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_412 {
    public List<String> fizzBuzz(int n) {

        List<String> answer = new ArrayList<>(n);

        for ( int i = 1; i <= n; i ++) {

            boolean divisibleBy3 = (i % 3) == 0;
            boolean divisibleBy5 = (i % 5) == 0;

            String result = "";

            if (divisibleBy3) { result += "Fizz"; }
            if (divisibleBy5) { result += "Buzz"; }
            if (result.isEmpty()) { result += String.valueOf(i); }

            answer.add(result);
        }

        return answer;

    }
}
