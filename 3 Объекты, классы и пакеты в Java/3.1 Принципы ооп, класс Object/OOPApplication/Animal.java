public abstract class Animal {

    //ИНКАПСУЛЯЦИЯ
    private final String name;
    private final int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //АБСТРАКЦИЯ
    protected abstract void sayHello();
}
