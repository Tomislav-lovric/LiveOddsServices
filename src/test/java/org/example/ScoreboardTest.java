package org.example;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {

    @Test
    void testStartMatchShouldStartCorrectly() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Croatia", "Germany");

        assertEquals(1, scoreboard.getSummary().size());
        assertEquals("Croatia 0 - Germany 0", scoreboard.getSummary().get(0));
    }

    @Test
    void testStartMatchWithTeamNameThatIsAlreadyInAMatchShouldThrowIllegalArgumentException() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Croatia", "Germany");

        assertThrows(IllegalArgumentException.class, () -> scoreboard.startMatch("Croatia", "Spain"));
    }

    @Test
    void testFindMatchCorrectly() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Croatia", "Germany");

        assertNotNull(scoreboard.findMatch("Croatia", "Germany"));
    }

    @Test
    void testFindMatchShouldThrowNoSuchElementExceptio() {
        Scoreboard scoreboard = new Scoreboard();

        assertThrows(NoSuchElementException.class, () -> scoreboard.findMatch("Croatia", "Germany"));
    }

    @Test
    void testUpdateScoreCorrectly() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Croatia", "Germany");
        scoreboard.updateScore("Croatia", 1, "Germany", 0);

        assertEquals("Croatia 1 - Germany 0", scoreboard.getSummary().get(0));
    }

    @Test
    void testUpdateScoreShouldThrowNoSuchElementException() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Croatia", "Germany");

        assertThrows(NoSuchElementException.class, () -> scoreboard.updateScore("Croatia", 1, "Spain", 0));
    }

    @Test
    void testSummaryShouldReturnHighestScoreCorrectly() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Croatia", "Germany");
        scoreboard.updateScore("Croatia", 3, "Germany", 1);
        scoreboard.startMatch("Spain", "France");
        scoreboard.updateScore("Spain", 3, "France", 4);

        assertEquals("Croatia 3 - Germany 1", scoreboard.getSummary().get(1));
        assertEquals("Spain 3 - France 4", scoreboard.getSummary().get(0));
    }

    @Test
    void testSummaryShouldReturnEqualScoresCorrectly() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Croatia", "Germany");
        scoreboard.updateScore("Croatia", 3, "Germany", 1);
        scoreboard.startMatch("Spain", "France");
        scoreboard.updateScore("Spain", 3, "France", 4);
        scoreboard.startMatch("England", "Austria");
        scoreboard.updateScore("England", 3, "Austria", 1);

        assertEquals("Croatia 3 - Germany 1", scoreboard.getSummary().get(2));
        assertEquals("Spain 3 - France 4", scoreboard.getSummary().get(0));
        assertEquals("England 3 - Austria 1", scoreboard.getSummary().get(1));
    }

}