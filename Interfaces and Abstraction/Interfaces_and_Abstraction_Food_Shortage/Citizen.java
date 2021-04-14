package DefineAnInterfacePerson;

public class Citizen implements Person,Birthable,Identifiable,Buyer {
    private String name;
    private int age;
    private String id;
    private String birthDate;
    private int food;

    public Citizen(String name,int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id=id;
        this.birthDate=birthDate;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food +=10;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
