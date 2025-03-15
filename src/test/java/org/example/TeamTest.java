package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void testEmptyTeamNameShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Team("");
        });
    }

    @Test
    void testTeamNameWithOnlySpacesShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Team("      ");
        });
    }

    @Test
    void testTeamNamesShouldBeNormalized() {
        Team team1 = new Team(" Spain  ");
        Team team2 = new Team("spaiN");

        // Spaces at the beginning and at the end should be removed, and only first letter should be capitalized
        // Which also means these two team names should be equal
        assertEquals("Spain", team1.toString());
        assertEquals("Spain", team2.toString());
        assertEquals(team1, team2);
    }

}