
// final может быть у неабстрактного класса и метода, а также у сразу инициализированной переменной
public final class Main  {

    final Integer a = 10;

    final void justFunction(final String a) {
        final String b = a;
    }
  
    // Variable might not have been initialized
    final Integer b;

    // Modifier 'final' not allowed here
    final Main() {}

    // Modifier 'final' not allowed here
    final interface JustInterface {}

}

// Illegal combination of modifiers
final abstract class JustClass() {

    // Illegal combination of modifiers
    final abstract void justFunction();

}
