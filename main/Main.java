package main;
public class Main {
    public static void main(String[] args) {
        WindowMenu.mainMenu();

        
        
    }

    public static Simulation generateSimulation(int round, Team a, Team b) {
        Team[] teams = Data.getTeams("csv/teams.csv");
        Simulation result = new Simulation();
        for (int i = 0; i < round; i++) {
            Team winner = Simulator.getWinner(a, b);
            MatchResult match = new MatchResult(a, b, winner);
            result.add(match);
        }
        return result;
    }
}