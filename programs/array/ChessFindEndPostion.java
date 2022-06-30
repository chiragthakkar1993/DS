package array;

public class ChessFindEndPostion {


    public static String run(String startPosition, int R, int C) {
        int startRow = Integer.parseInt(String.valueOf(startPosition.charAt(0)));
        int startColumn = startPosition.charAt(1) - 'a' + 1;

        int currentRow = 0;
        int currentColumn = 0;
        //calculation for row
        if ((startRow + R) > 8) {
            int extraStepsForRow = 8 - startRow;
            int remainingStepsForRow = (R - extraStepsForRow);
            currentRow = remainingStepsForRow > 8 ? (remainingStepsForRow % 8) : remainingStepsForRow;
        } else {
            currentRow = startRow + R;
        }

        if ((startColumn + R) > 8) {
            //calculation for column
            int extraStepsForColumn = 8 - startColumn;
            int remainingStepsForColumn = (C - extraStepsForColumn);
            currentColumn = remainingStepsForColumn > 8 ? (remainingStepsForColumn % 8) : remainingStepsForColumn;
        } else {
            currentColumn = startColumn + C;
        }
        return currentRow + String.valueOf((char) ('a' + currentColumn - 1));
    }

    public static void main(String[] args) {
        System.out.println(run("5h", 11, 25));

    }
}
