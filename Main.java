public class Main {
    public static void main(String[] args) {
        Simulation result = generateSimulation(Integer.parseInt(args[0]));
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            System.out.println(result.getStorage()[i][2].getName());

        }
        
    }

    public static Simulation generateSimulation(int round) {
        Team[] teams = Data.getTeams("teams.csv");
        Simulation result = new Simulation();
        for (int i = 0; i < round; i++) {
            Team[] competitors = Simulator.getRandomTeams(teams);
            Team winner = Simulator.getWinner(competitors[0], competitors[1]);
            Team[] data = new Team[3];
            data[0] = competitors[0];
            data[1] = competitors[1];
            data[2] = winner;
            result.add(data);
        }
        return result;
    }
}