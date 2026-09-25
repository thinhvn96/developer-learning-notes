/** Run: java oop/examples/OverridingVsHiding.java  Instance methods override; static methods and fields hide. */
public class OverridingVsHiding {
    public static void main(String[] args) {
        Animal a = new Dog();                    // static type Animal, runtime type Dog
        System.out.println("instance method : " + a.sound());          // Dog's version (override)
        System.out.println("static method   : " + Animal.kind() + " / " + Dog.kind());
        System.out.println("static via ref  : " + a.staticKind());     // chosen by the STATIC type: Animal's
        System.out.println("field           : " + a.name + " (static type) vs " + ((Dog) a).name + " (cast)");
        System.out.println("covariant return: " + a.self().getClass().getSimpleName());
    }
}
class Animal {
    String name = "animal";
    String sound() { return "..."; }
    static String kind() { return "Animal.kind"; }
    String staticKind() { return kind(); }
    Animal self() { return this; }
}
class Dog extends Animal {
    String name = "dog";                         // hides the field, does not override it
    @Override String sound() { return "woof"; }  // @Override: compile error if the signature does not match
    static String kind() { return "Dog.kind"; }  // hides Animal.kind()
    @Override Dog self() { return this; }        // covariant return type: a subtype of Animal
}
