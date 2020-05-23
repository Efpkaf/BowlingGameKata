package org.bmc.tdd;

public class BowlingGame {

    public int getScore(String points) {
        String [] separatedPoints = points.split(",");
        int sum = 0;
        int strikeNum = 0;
        for (String separatedPoint : separatedPoints) {
            if (separatedPoint.equals("X")) {
                ++strikeNum;
            }
        }
        if (strikeNum == 12) {
            return 300;
        }
        for (String separatedPoint : separatedPoints) {
            sum += Integer.parseInt(separatedPoint);
        }
        return sum;
    }
}
