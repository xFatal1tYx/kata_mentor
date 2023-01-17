// абстрактный класс, без абстрактных методов
abstract class Animal {
    private final String name;
    private final String color;

    // конструктор, для инициализации полей, при создании наследника
    Animal(String name, String color) {
        this.name = weight;
        this.color = color;
    }

}

class Cat extends Animal {
    Cat(String name, String color) {
        super(name, color);
    }
}
