
// final может быть у неабстрактного и нестатического класса, неабстракт. метода, а также у сразу инициализированной переменной
public final class Main  {

    final Integer a = 10;

    final void justFunction(final String a) {
        final String b = a;
    }
    
    final static void justStaticFunction() {}
  
    // Variable might not have been initialized
    final Integer b;

    // Modifier 'final' not allowed here
    final Main() {}

    // Modifier 'final' not allowed here
    final interface JustInterface {}

}

// Illegal combination of modifiers
final abstract class JustAbstractClass() {

    // Illegal combination of modifiers
    final abstract void justFunction();

}

// Modifier 'static' not allowed here
final static class JustStaticClass() {}
