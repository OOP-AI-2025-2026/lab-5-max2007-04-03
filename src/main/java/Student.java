public class Student extends Person {
    private int group;
    private int studentIdNumber;

    // Конструктор
    public Student(String lastName, String firstName, int age, int group, int studentIdNumber) {
        super(lastName, firstName, age); // Виклик конструктора батьківського класу
        this.group = group;
        this.studentIdNumber = studentIdNumber;
    }

    // Геттери та сетери для нових полів
    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getStudentIdNumber() {
        return studentIdNumber;
    }

    public void setStudentIdNumber(int studentIdNumber) {
        this.studentIdNumber = studentIdNumber;
    }

    // Перевизначений метод toString()
    @Override
    public String toString() {
        return "Студент групи " + group + ", " + getLastName() + " " + getFirstName() +
                ", вік: " + getAge() + ". Номер студентського квитка: " + studentIdNumber;
    }
}