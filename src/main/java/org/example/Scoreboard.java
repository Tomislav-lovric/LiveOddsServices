package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {

    private final List<Match> matches = new ArrayList<>();

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

    public List<String> getSummary() {
        List<Match> sortedMatches = new ArrayList<>(matches);
        List<String> summary = new ArrayList<>();

        sortedMatches.sort(null);

        for (Match match : sortedMatches) {
            summary.add(match.toString());
        }

        return summary;
    }

}
