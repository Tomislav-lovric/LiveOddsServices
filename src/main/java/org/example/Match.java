package org.example;

import java.time.LocalDateTime;

public class Match implements Comparable<Match> {

    private final Team homeTeam;
    private final Team awayTeam;
    private int homeScore;
    private int awayScore;
    private final LocalDateTime startTime;

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
        this.startTime = LocalDateTime.now();
    }

    /**
     * Updates score of the match, ensuring scores can't be negative, can't be the same as the already are
     * and ensuring scores can't be decreased
     */
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

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore + " - " + awayTeam + " " + awayScore;
    }


    /**
     * Compares matches based on their total score, the ones with higher total score go first, if they have the same
     * total score the matches will be returned ordered by the most recently started match
     */
    @Override
    public int compareTo(Match o) {
        int result = Integer.compare(o.getTotalScore(), this.getTotalScore());

        if (result == 0) {
            result = o.getStartTime().compareTo(this.startTime);
        }

        return result;
    }
}
