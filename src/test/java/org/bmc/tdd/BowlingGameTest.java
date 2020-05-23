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
}