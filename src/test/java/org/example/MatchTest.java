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

}