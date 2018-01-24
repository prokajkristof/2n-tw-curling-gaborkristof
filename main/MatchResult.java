public class MatchResult {
    private Team teamA;
    private Team teamB;
    private Team matchWinner;

    MatchResult(Team teamA, Team teamB, Team matchWinner) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchWinner = matchWinner;
    }
    /**
     * @return the matchWinner
     */
    public Team getMatchWinner() {
        return matchWinner;
    }

    /**
     * @return the teamA
     */
    public Team getTeamA() {
        return teamA;
    }

    /**
     * @return the teamB
     */
    public Team getTeamB() {
        return teamB;
    }
}