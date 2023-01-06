/*
 *
 * Externilizable расширяет интерфейс Serializable и позволяет переопределить методы:
 * writeExternal() - для точечного указания, какие поля и как должны быть сериализованы
 * readExternal() - чтобы описать, как должны быть прочитаны эти поля.
 * Такой вариант сериализации более производительный, гибкий и безопасный. Он требует наличие у класса конструктора по умолчанию!
 *
 * Final поля невозможно изменить в методе при десериализации. Компилятор выдаст ошибку: Cannot assign a value to final variable
 * Externalizable позволяет сериализовывать статические поля, но делать этого не рекомендуется.
 *
 */


import java.io.*;

class Job implements Serializable {
    String profession;

    public Job(String profession) {
        this.profession = profession;
    }
}

class Human implements Externalizable {
    private int age;
    private final char gender;
    private String name;
    private static String planet = "Earth";
    private Job job;

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public static String getPlanet() {
        return planet;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Human() {
        gender = 'M';
    }

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
                ", age=" + age +
                ", gender=" + gender +
                ", name='" + name + '\'' +
                ", profession='" + job.profession + '\'' +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getAge());
        //out.writeObject(this.getGender());
        out.writeObject(this.getName());
        out.writeObject(this.getJob());
        out.writeObject(getPlanet());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        age = (int) in.readObject();
        //gender = (char) in.readObject();
        name = (String) in.readObject();
        job = (Job) in.readObject();
        planet = (String) in.readObject();
    }
}

// Вывод: Human{planet=Earth, age=23, gender=M, name='Ivan', profession='Programmer'}
// Human{planet=Earth, age=23, gender=M, name='Ivan', profession='Programmer'}
public class Main {
    public static void main(String[] args) throws IOException {
        Human human = new Human(23, 'M', "Ivan", new Job("Programmer"));
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
