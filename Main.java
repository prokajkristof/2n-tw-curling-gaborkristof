public class Main {
    public static void main(String[] args) {
        Person jani = new Person("Jani", 25, 75, "sad");
        Person j2 = new Person("Jani", 25, 75, "sa");
        Person j3 = new Person("Jani", 25, 75, "s");
        Person j4 = new Person("Jani", 25, 75, "sa");
        Team[] teams = Data.getTeams("teams.csv");
        System.out.println(teams[1].getRating());
        Data.writeTeamstoFile("teams2.csv", teams);
    }
}