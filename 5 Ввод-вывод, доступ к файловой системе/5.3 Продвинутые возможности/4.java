// При попытке сериализации выбрасывается исключение: NotSerializableException: Job

import java.io.*;

// Отсутствие implements Serializable
class Job {
    String profession;

    public Job(String profession) {
        this.profession = profession;
    }
}

class Human implements Serializable {
    int age;
    final char gender;
    String name;
    static String planet = "Earth";
    transient String status = "citizen";
    Job job;

    public Human(int age, char gender, String name, Job job) {
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Human{" +
                "planet=" + planet +
                ", status=" + status +
                ", age=" + age +
                ", gender=" + gender +
                ", name='" + name +
                ", profession='" + job.profession + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Human human = new Human(23, 'M', "Ivan", new Job("Programmer"));
        try (OutputStream outputStream = new FileOutputStream("1.txt")) {
            ObjectOutputStream stream = new ObjectOutputStream(outputStream);
            stream.writeObject(human);
        }
    }
}
