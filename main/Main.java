package main;
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
        }
        Simulator sim = new Simulator(result, new Logger(true));
        Result asd = sim.run();
        System.out.println(asd.getWinner().getName());
        System.out.println(asd.getProbability());
        
        
    }

    public static Simulation generateSimulation(int round) {
        Team[] teams = Data.getTeams("csv/teams.csv");
        Simulation result = new Simulation();
        Team[] competitors = Simulator.getRandomTeams(teams);
        for (int i = 0; i < round; i++) {
            Team winner = Simulator.getWinner(competitors[0], competitors[1]);
            MatchResult match = new MatchResult(competitors[0], competitors[1], winner);
            result.add(match);
        }
        return result;
    }
}