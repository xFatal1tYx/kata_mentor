// Вывод: Human{planet=Earth, status=citizen, age=23, gender=M, name='Ivan'}
// Human{planet=Earth, status=null, age=23, gender=M, name='Ivan'}

import java.io.*;

class Human implements Serializable {
    int age;

    // final поля сериализуются через Serializable
    final char gender;

    String name;
    // Статические поля не сериализуется через Serializable, поскольку они принадлежат классу
    static String planet = "Earth";

    // transient помечаются поля, если ме не хотим их сериализовать
    transient String status = "citizen";

    public Human(int age, char gender, String name) {
        this.age = age;
        this.gender = gender;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "planet=" + planet +
                ", status=" + status +
                ", age=" + age +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Human human = new Human(23, 'M', "Ivan");
        System.out.println(human);
        try (OutputStream outputStream = new FileOutputStream("1.txt")) {
            ObjectOutputStream stream = new ObjectOutputStream(outputStream);
            stream.writeObject(human);
        }

        Human restoredHuman;
        try (InputStream inputStream = new FileInputStream("1.txt")) {
            ObjectInputStream stream = new ObjectInputStream(inputStream);
            restoredHuman = (Human) stream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(restoredHuman);
    }
}
