
// static может быть у вложенных классов/интерфейсов/enum, нелокальных переменных и неабстрактных методов класса (в т.ч. final)
public class Main  {

    final static Integer a = 10;
    static Integer b;

    static interface JustInterface {}

    static class JustClass {}
  
    static enum JustEnum {}

    static void justFunction() {
        // Modifier 'static' not allowed here
        static String c;
    }

    // Modifier 'static' not allowed here
    static Main() {}

}

// Modifier 'static' not allowed here
static class JustAbstractClass() {

    // Illegal combination of modifiers
    static abstract void justFunction();

}

// Modifier 'static' not allowed here
static enum JustEnum {}

// Modifier 'static' not allowed here
static interface JustInterface {}
