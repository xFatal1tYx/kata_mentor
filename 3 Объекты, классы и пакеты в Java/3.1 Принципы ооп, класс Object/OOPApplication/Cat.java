//НАСЛЕДОВАНИЕ
public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    protected void sayHello() {
        System.out.println(super.getName() + " says meow!");
    }
}
