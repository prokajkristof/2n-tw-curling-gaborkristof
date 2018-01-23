public class Main {
    public static void main(String[] args) {
        Person jani = new Person("Jani", 25, 75, "sad");
        Person j2 = new Person("Jani", 25, 75, "sa");
        Person j3 = new Person("Jani", 25, 75, "s");
        Person j4 = new Person("Jani", 25, 75, "sa");
        Team[] teams = Data.getTeams("teams.csv");
        for (Team var : teams) {
            System.out.println(var.getName() + " rating: " + var.getRating());
        }
        Team[] parbaj = Simulation.getRandomTeams(teams);
        System.out.println(parbaj[0].getName() + " vs " +parbaj[1].getName());
        System.out.println(Simulation.getResult(parbaj[0], parbaj[1], true).getName());
    }
}