package org.example;


import java.util.Objects;

/**
 * Class that represents a football team
 */
public class Team {

    private final String name;

    public Team(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name can't be empty!");
        }

        // make team name lower cased, so in the future it will be easier to avoid duplicate team names
        this.name = name.trim().toLowerCase();
    }

    /**
     * Added only getter, because I do not want user to change team name after it's creation because it could lead
     * to unwanted results, like allowing matches to have two or more of the same teams
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
