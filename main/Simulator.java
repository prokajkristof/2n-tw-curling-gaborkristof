import java.util.Random;

public class Simulator{
    Simulation simulation;
    Logger logger;
    Result result;
    public Simulator(Simulation simulation, Logger logger){
        this.simulation = simulation;
        this.logger = logger;
    }
    public Result run(){
        float winPercentage;
        int countA = 0;
        int countB = 0;
        MatchResult[] storage = simulation.getStorage();
        Result result;
        for (MatchResult matchResult : storage) {
            if (matchResult.getTeamA().equals(matchResult.getMatchWinner())) {
                countA++;
            }
            else {
                countB++;
            }
        }
        if (countA > countB) {
            winPercentage = (float) countA / (float) storage.length * 100;
            result = new Result(storage[0].getTeamA(), storage[0].getTeamB(), winPercentage);
        }
        else {
            winPercentage = (float) countB / (float) storage.length * 100;
            result = new Result(storage[0].getTeamB(), storage[0].getTeamA(), winPercentage);
        }
        return result;

    }
    public static Team getWinner(Team team1, Team team2) {
        Random random = new Random();
        Team winner = team1;
        int team1Score = random.nextInt(60) + 1 + team1.getRating();
        int team2Score = random.nextInt(60) + 1 + team2.getRating();
        if (team1Score < team2Score) {
            winner = team2;
        }
        else if (team1Score == team2Score) {
            if (random.nextInt(2) == 1) {
                winner = team2;
            }
        }
        return winner;
    }

    public static Team[] getRandomTeams(Team[] teams) {
        Team[] randTeams = new Team[2];
        Random random = new Random();
        int index1 = random.nextInt(teams.length);
        int index2 = 0;
        while(true) {
            index2 = random.nextInt(teams.length);
            if (index1 != index2) {
                break;
            } 
        }
        randTeams[0] = teams[index1];
        randTeams[1] = teams[index2];
        return randTeams;
    }
}