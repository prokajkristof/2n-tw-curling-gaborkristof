import java.io.FileNotFoundException;
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
}