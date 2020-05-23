package org.bmc.tdd;

public class BowlingGame {

    public int getScore(String points) {
        String [] separatedPoints = points.split(",");
        int sum = 0;
        boolean shouldMultiplePoints = false;
        int bonusNumber = 0;
        boolean twoStrikesInRow = false;
        for (String separatedPoint : separatedPoints) {
            if(separatedPoint.equals("X")){
                bonusNumber = 0;
                if (shouldMultiplePoints) {
                    twoStrikesInRow = true;
                    separatedPoint = "10";
                } else {
                    shouldMultiplePoints = true;
                    sum += 10;
                    continue;
                }
            }
            int parsedPoints = Integer.parseInt(separatedPoint);

            if(shouldMultiplePoints){
                if (bonusNumber < 2) {
                    parsedPoints = 2*parsedPoints;
                }
                ++bonusNumber;
            }
            sum += parsedPoints;
            twoStrikesInRow = false;
        }
        return sum;
    }
}
