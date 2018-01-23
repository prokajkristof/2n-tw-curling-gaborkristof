public class Simulation {
    private Team[][] storage = new Team[0][];
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