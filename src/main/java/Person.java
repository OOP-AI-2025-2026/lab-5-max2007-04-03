public class Person {
    private String lastName;
    private String firstName;
    private int age;

    // Конструктор
    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    // Геттери
    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }

    // Сетери
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Людина " + lastName + " " + firstName + ", вік: " + age;
    }
}