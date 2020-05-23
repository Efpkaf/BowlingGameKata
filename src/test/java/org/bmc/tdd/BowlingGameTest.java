package org.bmc.tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BowlingGameTest {

    BowlingGame theGame = new BowlingGame();

    @Test
    public void shouldScoreOneWhenRolledOneWithAssertJ() {
        Assertions.assertThat(theGame.getScore("1")).isEqualTo(1);
    }

    @Test
    void shouldReturnZeroForZeroScoredPoints() {
        assertEquals(0, theGame.getScore("0,0,0,0,0,0,0,0,0,0"));
    }

    @Test
    void shouldReturnSumOfDifferentPoints() {
        assertEquals(1, theGame.getScore("0,1"));
    }

    @Test
    void shouldReturnMaximumAmountOfPoints() {
        assertEquals(300, theGame.getScore("X,X,X,X,X,X,X,X,X,X,X,X"));
    }

    @Test
    void shouldAddBonusWhenFirstStrike() {
        assertEquals(16, theGame.getScore("X,1,2"));
    }

    @Test
    void shouldAddBonusOnlyForTwoNextValues() {
        assertEquals(17, theGame.getScore("X,1,2,1"));
    }

    @Test
    void shouldReturnAmountOfPointsWithDoubleBonus() {
        assertEquals(60, theGame.getScore("X,X,X,0,0"));
    }

    @Test
    void shouldReturnMaximumAmountOfPointsWithoutBonusShoots() {
        assertEquals(270, theGame.getScore("X,X,X,X,X,X,X,X,X,X,0,0"));
    }
}