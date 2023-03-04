package brute_force;

public class 최소_직사각형 {
    private static int maxWidth = 0;
    private static int maxHeight = 0;

    public int solution(int[][] sizes) {

        for (int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];
            int height = sizes[i][1];

            updateMaxWidthAndHeight(width, height);
        }

        return maxWidth * maxHeight;
    }

    // 명함의 최대 크기를 갱신하라
    private static void updateMaxWidthAndHeight(int width, int height) {

        if (width > height) {
            conditionBranchFirst(width, height);
        }

        if (height > width) {
            conditionBranchSecond(width, height);
        }



    }

    // 조건 분기 1
    private static void conditionBranchFirst(int width, int height) {
        if ( width > maxHeight ) {
            maxHeight = width;
        }
        if ( height > maxWidth ) {
            maxWidth = height;
        }
    }

    // 조건 분기 2
    private static void conditionBranchSecond(int width, int height) {
        if ( width > maxWidth ) {
            maxWidth = width;
        }
        if ( height > maxHeight ) {
            maxHeight = height;
        }
    }

}


