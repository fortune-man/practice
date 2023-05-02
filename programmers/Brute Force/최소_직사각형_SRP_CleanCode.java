package brute_force;

public class 최소_직사각형_SRP_CleanCode {

    class Solution {
        public int solution(int[][] sizes) {
            int maxWidth = getMaxWidth(sizes);
            int maxHeight = getMaxHeight(sizes);

            return maxWidth * maxHeight;
        }

        private static int getMaxWidth(int[][] sizes) {
            int maxWidth = 0;
            for (int[] size: sizes) {
                CardSize cardSize = CardSize.fromArray(size);
                int width = Math.min(cardSize.getWidth(), cardSize.getHeight());
                if (width > maxWidth) {
                    maxWidth = width;
                }
            }

            return maxWidth;
        }

        private static int getMaxHeight(int[][] sizes) {
            int maxHeight = 0;
            for (int[] size: sizes) {
                CardSize cardSize = CardSize.fromArray(size);
                int height = Math.max(cardSize.getWidth(), cardSize.getHeight());
                if (height > maxHeight) {
                    maxHeight = height;
                }
            }

            return maxHeight;
        }
    }

    class CardSize {
        private final int WIDTH;
        private final int HEIGHT;

        public CardSize(int width, int height) {
            this.WIDTH = width;
            this.HEIGHT = height;
        }

        public static CardSize fromArray(int[] size) {
            int width = size[0];
            int height = size[1];

            if (width > height) {
                return new CardSize(height, width);
            } else {
                return new CardSize(width, height);
            }
        }

        public int getWidth() {
            return WIDTH;
        }

        public int getHeight() {
            return HEIGHT;
        }
    }
}
