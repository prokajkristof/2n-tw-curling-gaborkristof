

public class Person{

    private String name;
    private int age;
    private int skill;
    private String team;

    Person(String name, int age, int skill, String team){
        this.name = name;
        this.age = age;
        this.skill = skill;
        this.team = team;
    }

    void setName(String name){
        this.name = name;
    }

    String getName() {
        return name;
    }


    void setAge(int age) {
        this.age = age;
    }

    int getAge(){
        return age;
    }

    void setSkill(int skill){
        if (skill < 100 && skill > 0) {
            this.skill = skill;
        }
    }

    public int getSkill() {
        return skill;
    }
}
