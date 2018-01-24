public class Result {
    private Team winner;
    private Team looser;
    private float probability;

    Result(Team winner, Team looser, float probability) {
        this.winner = winner;
        this.looser = looser;
        this.probability = probability;
    }

    /**
     * @return the looser
     */
    public Team getLooser() {
        return looser;
    }
    /**
     * @return the probability
     */
    public float getProbability() {
        return probability;
    }
    /**
     * @return the winner
     */
    public Team getWinner() {
        return winner;
    }
    /**
     * @param looser the looser to set
     */
    public void setLooser(Team looser) {
        this.looser = looser;
    }
    /**
     * @param probability the probability to set
     */
    public void setProbability(float probability) {
        this.probability = probability;
    }
    /**
     * @param winner the winner to set
     */
    public void setWinner(Team winner) {
        this.winner = winner;
    }
}