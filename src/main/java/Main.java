public class Main {
    public static void main(String[] args) {

        // 1. Створюємо об'єкти
        Person person = new Person("Петренко", "Петро", 35);
        Student student = new Student("Іваненко", "Іван", 20, 121, 12345678);
        Lecturer lecturer = new Lecturer("Сидоренко", "Марія", 42, "Комп'ютерних наук", 25000.0);

        // 2. Створюємо та заповнюємо масив
        Person[] people = new Person[3];
        people[0] = student;
        people[1] = lecturer;
        people[2] = person;

        // 3. Виводимо інформацію з масиву за допомогою циклу
        System.out.println("--- Інформація з масиву ---");
        for (Person p : people) {
            System.out.println(p); // .toString() викликається автоматично
        }
    }
}