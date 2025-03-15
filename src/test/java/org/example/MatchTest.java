package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    @Test
    void testMatchInitialization() {
        Team homeTeam = new Team("  crOatia ");
        Team awayTeam = new Team("  Germany");
        Match match = new Match(homeTeam, awayTeam);

        // Home and Away team names should be normalized
        assertEquals("Croatia", match.getHomeTeam().toString());
        assertEquals("Germany", match.getAwayTeam().toString());

        // Score should be 0 - 0
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    void testUpdateScoreShouldUpdateScoreCorrectly() {
        Team homeTeam = new Team("Croatia");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        match.updateScore(3, 2);
        assertEquals(3, match.getHomeScore());
        assertEquals(2, match.getAwayScore());
    }

    @Test
    void testUpdateScoreWithNegativeHomeScoreShouldThrowIllegalArgumentException() {
        Team homeTeam = new Team("Croatia");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        assertThrows(IllegalArgumentException.class, () -> match.updateScore(-1, 2));
    }
    @Test
    void testUpdateScoreWithNegativeAwayScoreShouldThrowIllegalArgumentException() {
        Team homeTeam = new Team("Croatia");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        assertThrows(IllegalArgumentException.class, () -> match.updateScore(2, -2));
    }

    @Test
    void testUpdateTestScoreWithTheSameScoreShouldThrowIllegalArgumentException() {
        Team homeTeam = new Team("Croatia");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);
        match.updateScore(2, 2);

        assertThrows(IllegalArgumentException.class, () -> match.updateScore(2, 2));
    }

    @Test
    void testSameTeamsShouldThrowIllegalArgumentException() {
        Team homeTeam = new Team("Croatia");
        Team awayTeam = new Team("Croatia");

        assertThrows(IllegalArgumentException.class, () -> new Match(homeTeam, awayTeam));
    }

    @Test
    void testRollbackHomeTeamScoreShouldThrowIllegalArgumentException() {
        Team homeTeam = new Team("Croatia");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);
        match.updateScore(2, 2);

        assertThrows(IllegalArgumentException.class, () -> match.updateScore(1, 2));
    }

    @Test
    void testRollbackAwayTeamScoreShouldThrowIllegalArgumentException() {
        Team homeTeam = new Team("Croatia");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);
        match.updateScore(2, 2);

        assertThrows(IllegalArgumentException.class, () -> match.updateScore(2, 1));
    }

}