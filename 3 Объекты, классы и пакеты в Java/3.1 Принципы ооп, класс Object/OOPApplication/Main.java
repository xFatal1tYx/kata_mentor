public class Main {

    public static void main(String[] args) {
        //ПОЛИМОРФИЗМ
        Animal cat = new Cat("Barsik", 3);
        Animal dog = new Dog("Sharik", 5);

        System.out.println("I have a two pets with ages: " + cat.getAge() + " and " + dog.getAge() +
                "! Guys, say hello!");
        cat.sayHello();
        dog.sayHello();
    }

}