package org.example;

import org.junit.jupiter.api.Test;

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

}