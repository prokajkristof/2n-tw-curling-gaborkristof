import java.util.Random;

public class Simulator{
    Simulation simulation;
    Logger logger;
    public Simulator(Simulation simulation, Logger logger){
        this.simulation = simulation;
        this.logger = logger;
    }
    public void run(){
        
    }
    public static Team getResult(Team team1, Team team2, boolean win) {
        Random random = new Random();
        Team winner = team1;
        Team losser = team2;
        int team1Score = random.nextInt(60) + 1 + team1.getRating();
        int team2Score = random.nextInt(60) + 1 + team2.getRating();
        if (team1Score < team2Score) {
            winner = team2;
            losser = team1;
        }
        else if (team1Score == team2Score) {
            if (random.nextInt(2) == 1) {
                winner = team2;
                losser = team1;
            }
        }

        if (win) {
            return winner;
        }
        else {
            return losser;
        }
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