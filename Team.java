public class Team {
    private String name;
    private int rating;
    private Person[] members;

    Team(String name) {
        this.name = name;
        rating = 0;
        for (int i = 0; i < members.lenght; i++) {
            rating += members[i].getSkill();
        }
    }
    /**
     * @return the members
     */
    public Person[] getMembers() {
        return members;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }
    
    public void addMember(Person p) {
        if (members.lenght < 3) {
            Person[] temp = new Person[members.lenght];
            temp[members.lenght] = p;
            for (int j = 0; j < members.lenght; j ++) {
                temp[i] = members[i];
            }
            members = temp;
        }
    }
    
}