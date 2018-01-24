public class Simulation {


    private MatchResult[] storage = new MatchResult[0];

    public void generateData() {
        String[] data = new String[storage.length];
        String line;
        int i = 0;
        for (MatchResult match : storage) {
            line = match.getTeamA().getName() + "," + match.getTeamB().getName() + "," + match.getMatchWinner().getName();
            data[i] = line;
            i++;
        }
        Data.writeData(data, "simulation.csv");
    }

    public static Simulation load() {
        Simulation result = new Simulation();
        Team[] teams = Data.getTeams("simulation.csv");
        for (int i = 0; i < teams.length; i+=3) {
            MatchResult match = new MatchResult(teams[i], teams[i+1], teams[i+2]);
            result.add(match);
        }
        return result;
    }
    

    public void add(MatchResult o) {
        int num = storage.length;
        MatchResult[] temp = new MatchResult[num + 1];
        for (int i = 0; i < storage.length; i++) {
            temp[i] = storage[i];
        }
        temp[num] = o;
        storage = temp;
    }

    public MatchResult[] getStorage() {
        return storage;
    }
    
}