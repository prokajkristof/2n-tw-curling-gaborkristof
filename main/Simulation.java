public class Simulation {

    private Team[][] storage = new Team[0][];

    public void generateData() {
        String[] data = new String[storage.length];
        String line;
        int i = 0;
        for (Team[] team : storage) {
            line = team[0].getName() + "," +team[1].getName() + "," +team[2].getName();
            System.out.println(line);
            data[i] = line;
            i++;
        }
        Data.writeData(data, "simulation.csv");
    }

    public Simulation load() {
        return this;
    }
    

    public void add(Team[] o) {
        int num = storage.length;
        Team[][] temp = new Team[num + 1][];
        for (int i = 0; i < storage.length; i++) {
            temp[i] = storage[i];
        }
        temp[num] = o;
        storage = temp;
    }

    public Team[][] getStorage() {
        return storage;
    }
    
}