package org.bmc.tdd;

public class BowlingGame {

    public int getScore(String points) {
        String [] separatedPoints = points.split(",");
        if (separatedPoints.length == 1) {
            return Integer.parseInt(separatedPoints[0]);
        } else {
            int sum = 0;
            for (String separatedPoint : separatedPoints) {
                sum += Integer.parseInt(separatedPoint);
            }
            return sum;
        }
    }
}
