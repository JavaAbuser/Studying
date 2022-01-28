package ReflectionAPI.Reflection;

import java.util.Date;

public class Human {
    public String name;
    private int age;
    private Date birthDate = new Date();

    public Human(String name, int age, final Date birthDate){
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public void printInfo(){
        System.out.println(name + ", " + age + ", birth date is " + birthDate);
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
