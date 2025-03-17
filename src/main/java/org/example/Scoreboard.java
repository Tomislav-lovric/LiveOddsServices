package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Scoreboard {

    private final List<Match> matches = new ArrayList<>();

    /**
     * Starts new match between two teams with score 0 - 0 while ensuring team is not already in another match
     */
    public void startMatch(String homeTeamName, String awayTeamName) {
        Team homeTeam = new Team(homeTeamName);
        Team awayTeam = new Team(awayTeamName);

        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) || match.getHomeTeam().equals(awayTeam) ||
                    match.getAwayTeam().equals(homeTeam) || match.getAwayTeam().equals(awayTeam)) {
                throw new IllegalArgumentException("Teams can't play in multiple matches");
            }
        }

        matches.add(new Match(homeTeam, awayTeam));
    }

    /**
     * Returns a sorted list of match summaries based on total score or by most recently started match if total score
     * is equal
     */
    public List<String> getSummary() {
        List<Match> sortedMatches = new ArrayList<>(matches);
        List<String> summary = new ArrayList<>();

        sortedMatches.sort(null);

        for (Match match : sortedMatches) {
            summary.add(match.toString());
        }

        return summary;
    }

    /**
     * Updates the score of an ongoing match
     */
    public void updateScore(String homeTeamName, int homeScore, String awayTeamName, int awayScore) {
        Match match = findMatch(homeTeamName, awayTeamName);
        match.updateScore(homeScore, awayScore);
    }

    /**
     * Finds a match by team names or throws an exception if no match is found
     */
    public Match findMatch(String homeTeamName, String awayTeamName) {
        for (Match match : matches) {
            if (match.getHomeTeam().getName().equalsIgnoreCase(homeTeamName) &&
                    match.getAwayTeam().getName().equalsIgnoreCase(awayTeamName)) {
                return match;
            }
        }

        throw new NoSuchElementException("Match not found");
    }

    /**
     * Finishes a match, returns String Team A 0 - Team B 0 Finished, and removes it from the scoreboard
     */
    public String finishMatch(String homeTeamName, String awayTeamName) {
        Match match = findMatch(homeTeamName, awayTeamName);
        matches.remove(match);
        return match.toString() + " Finished";
    }

}
