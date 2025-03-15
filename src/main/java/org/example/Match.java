package org.example;

public class Match {

    private final Team homeTeam;
    private final Team awayTeam;
    private int homeScore;
    private int awayScore;

    /**
     * Create new match between two teams with score 0 - 0
     */
    public Match(Team homeTeam, Team awayTeam) {
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("One team can't play against itself");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public void updateScore(int homeScore, int awayScore) {
        if (homeScore < 0 || awayScore < 0) {
            throw  new IllegalArgumentException("Scores can't be negative numbers");
        }

        if (this.homeScore == homeScore && this.awayScore == awayScore) {
            throw new IllegalArgumentException("Can't update match score with the same score");
        }

        if (this.homeScore > homeScore || this.awayScore > awayScore) {
            throw new IllegalArgumentException("Can't rolleback scores");
        }

        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore + " - " + awayTeam + " " + awayScore;
    }
}
