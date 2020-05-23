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
        boolean shouldMultiplePoints = false;
        for (String separatedPoint : separatedPoints) {
            if(separatedPoint.equals("X")){
                shouldMultiplePoints = true;
                sum += 10;
                continue;
            }
            int parsedPoints = Integer.parseInt(separatedPoint);

            if(shouldMultiplePoints){
                parsedPoints = 2*parsedPoints;
            }
            sum += parsedPoints;
        }
        return sum;
    }
}
