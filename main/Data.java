import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;



public class Data{

    public static Person[] getPersons(String playersCsv){
        Person[] players = new Person[0];
        try{
            File path = new File(playersCsv);
            Scanner input = new Scanner(path);
            input.useDelimiter(",|\n");
            int i = 0;
            while(input.hasNext()) {
                Person[] tempPlayers = new Person[i+1];
                for (int j = 0; j < tempPlayers.length - 1; j++) {
                    tempPlayers[j] = players[j];
                }
                players = tempPlayers;
                String name = input.next();
                int age = Integer.parseInt(input.next());
                int skill = Integer.parseInt(input.next());
                String team = input.next();
                players[i] = new Person(name, age, skill, team);
                i++;
            }
            input.close();
        }
        catch (FileNotFoundException o) {}
        return players;
    }
    public static Team[] getTeams(String teamCsv){
        Team[] teams = new Team[0];
        try{
            File path = new File(teamCsv);
            Scanner input = new Scanner(path);
            input.useDelimiter(",|\n");
            int i = 0;
            while(input.hasNext()) {
                Team[] tempTeams = new Team[i+1];
                for (int j = 0; j < tempTeams.length - 1; j++) {
                    tempTeams[j] = teams[j];
                }
                teams = tempTeams;
                String name = input.next();
                teams[i] = new Team(name);
                i++;
            }
            input.close();
        }
        catch (FileNotFoundException o) {}
        Person[] players = getPersons("players.csv");
        for (int i = 0; i < teams.length; i++) {
            for (Person player : players) {
                if (player.getTeam().equals(teams[i].getName())) {
                    teams[i].addMember(player);
                }
            }
        }
        return teams;
    }

    static void writeTeamstoFile(String path, Team[] teams) {
        try {
            PrintWriter writer = new PrintWriter(path);
            for (Team team : teams) {
                writer.println(team.getName());
            }
            
            writer.close();
        }
        catch (FileNotFoundException o) {};
    }

    static void writePlayerstoFile(String path, Person[] players) {
        try {
            PrintWriter writer = new PrintWriter(path);
            for (Person player : players) {
                writer.println(player.getName() + "," + player.getAge() + "," + player.getSkill() + "," + player.getTeam());
            }
            
            writer.close();
        }
        catch (FileNotFoundException o) {};
    }
    public static void writeData(String[] data, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (String line : data) {
                writer.println(line);                  
            }
            writer.close();
        }
        catch (FileNotFoundException o) {};
    }
}