public class Main {
    public static void main(String[] args) {
        Simulation result;
        if (args.length != 0) {
            result = generateSimulation(Integer.parseInt(args[0]));
            result.generateData();
        }
        else {
            result = Simulation.load();
        }
        for (MatchResult winner : result.getStorage()) {
            System.out.println(winner.getMatchWinner().getName());
        }
        
        
    }

    public static Simulation generateSimulation(int round) {
        Team[] teams = Data.getTeams("teams.csv");
        Simulation result = new Simulation();
        for (int i = 0; i < round; i++) {
            Team[] competitors = Simulator.getRandomTeams(teams);
            Team winner = Simulator.getWinner(competitors[0], competitors[1]);
            MatchResult match = new MatchResult(competitors[0], competitors[1], winner);
            result.add(match);
        }
        return result;
    }
}