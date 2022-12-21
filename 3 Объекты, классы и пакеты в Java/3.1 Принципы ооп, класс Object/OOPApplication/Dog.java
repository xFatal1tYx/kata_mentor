//НАСЛЕДОВАНИЕ
public class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    protected void sayHello() {
        System.out.printf(super.getName() + " says woof!");
    }
}
