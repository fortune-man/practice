package challenge;

import java.util.Arrays;

public class LeetCode_1672 {


    public int maximumWealthByLoopAndStream(int[][] accounts) {
        int max = 0;
        for (int[] customer : accounts) {
            max = Math.max(max, Arrays.stream(customer).sum());
        }
        return max;
    }

    // fastest
    public int maximumWealthByLoop(int[][] accounts) {
        int max = 0;

        for (int[] customer : accounts) {
            int wealth = 0;

            for (int account: customer) {
                wealth += account;
            }

            max = Math.max(max, wealth);
        }
        return max;
    }

    public int maximumWealthByStream(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(customer -> Arrays.stream(customer).sum())
                .max()
                .getAsInt();
    }


}
