package org.bmc.tdd;

public class BowlingGame {

    public int getScore(String points) {
        String [] separatedPoints = points.split(",");
        int sum = 0;
        boolean shouldMultiplePoints = false;
        int bonusNumber = 0;
        boolean twoStrikesInRow = false;
        for (String separatedPoint : separatedPoints) {
            int multipland = 2;
            if(separatedPoint.equals("X")){
                bonusNumber = 0;
                if (shouldMultiplePoints) {
                    multipland = getMultipland(twoStrikesInRow);
                    twoStrikesInRow = true;
                    separatedPoint = "10";
                } else {
                    shouldMultiplePoints = true;
                    sum += 10;
                    continue;
                }
            } else {
                twoStrikesInRow = false;
            }
            int parsedPoints = Integer.parseInt(separatedPoint);

            if(shouldMultiplePoints){
                if (bonusNumber < 2) {
                    parsedPoints = multipland*parsedPoints;
                } else {
                    shouldMultiplePoints = false;
                }
                ++bonusNumber;
            }
            sum += parsedPoints;
        }
        return sum;
    }

    private int getMultipland(boolean twoStrikesInRow) {
        return twoStrikesInRow ? 3 : 2;
    }
}
