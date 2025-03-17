# Football Scoreboard - README

## Overview
This project implements a simple **football scoreboard** to track live matches, update scores, and provide a sorted summary of ongoing games.

## Features
- **Start a match** between two teams.
- **Update the score** while the match is ongoing.
- **Finish a match** and remove it from the scoreboard.
- **View a summary** of matches sorted by total score and recency.

## Assumptions & Notes
1. **Team Name Normalization:**
   - Team names are case-insensitive and trimmed of extra spaces (e.g., " CROATIA " and "croatia" are treated as the same team).
   
2. **Preventing Duplicate Matches:**
   - A team **cannot participate in multiple matches at the same time**.
   
3. **Score Updates:**
   - Scores **must be non-negative**.
   - **Score updates** do not allow reducing scores.

4. **Sorting Logic for Summary:**
   - Matches are sorted **first by total score**.
   - If scores are equal, matches are sorted by **most recent start time**.
   
5. **Exception Handling:**
   - If an operation is invalid (e.g., starting a match with the same team or updating a finished match), an **exception is thrown**.

## How to Use
1. **Start a Match:**
   ```java
   Scoreboard scoreboard = new Scoreboard();
   scoreboard.startMatch("Croatia", "Germany");
   ```
   
2. **Update the Score:**
   ```java
   scoreboard.updateScore("Croatia", "Germany", 3, 1);
   ```

   
3. **Finish a Match:**
   ```java
   scoreboard.finishMatch("Croatia", "Germany");
   ```
   
4. **Get Summary:**
   ```java
   List<String> summary = scoreboard.getSummary();
   for (String match : summary) {
       System.out.println(match);
   }
   ```
