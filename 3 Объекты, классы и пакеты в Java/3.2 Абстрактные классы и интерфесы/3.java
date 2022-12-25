enum Wishes {
    RESPECTFULLY, SINCERELY, GRATITUDE, WISHES
}

interface Printable {

    //final public static поле
    String signature = "@Author";

    //abstract public метод
    void print();

    //static метод
    static String getWishes(Wishes wish) {
        return switch (wish) {
            case RESPECTFULLY -> "\n\nRespectfully yours ";
            case SINCERELY -> "\n\nSincerely yours ";
            case GRATITUDE -> "\n\nWith gratitude ";
            case WISHES -> "\n\nBest wishes ";
        };
    }

    //default public метод с реализацией
    default String printCaption() {
        return "=== Caption ===\n\n";
    }

}

class DefaultText implements Printable {
    @Override
    public void print() {
        System.out.print(printCaption());
        System.out.print("Body text");
        System.out.print(Printable.getWishes(Wishes.SINCERELY) + Printable.signature);
    }
}

public class Main  {
    public static void main(String[] args) {
        DefaultText text = new DefaultText();
        text.print();
    }
}
