package dfs;

import java.util.Arrays;
import java.util.stream.Stream;

public class FloodFill {

    public static void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;

            if (r >= 1) dfs(image, r - 1, c, color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if (c >= 1) dfs(image, r, c - 1, color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor)
            dfs(image, sr, sc, image[sr][sc], newColor);

        return image;

    }

    public static void main(String[] args) {
        int matrix[][] = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        int output[][] = floodFill(matrix,1,1,3);
        Arrays.stream(output).map(Arrays::toString).forEach(System.out::print);


    }
}
