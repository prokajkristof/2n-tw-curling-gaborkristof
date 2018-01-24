public class Team {
    private String name;
    private int rating;
    private Person[] members;

    Team(String name) {
        this.name = name;
        members = new Person[0];
        rating = 0;
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
        if (members.length  < 3) {
            Person[] temp = new Person[members.length + 1];
            temp[members.length] = p;
            for (int j = 0; j < members.length; j ++) {
                temp[j] = members[j];
            }
            members = temp;
            rating += p.getSkill();
        }
    }
    public boolean equals(Team a) {
        if(this.name.equals(a.getName())) {
            return true;
        }
        return false;
    }
    
}