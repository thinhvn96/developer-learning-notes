/** Run: java design-patterns/examples/FacadeDemo.java  One simple entry point in front of a complex subsystem. */
public class FacadeDemo {
    public static void main(String[] args) {
        new HomeTheaterFacade(new Amplifier(), new Projector(), new Lights()).watchMovie("Alien");
        System.out.println("---");
        new HomeTheaterFacade(new Amplifier(), new Projector(), new Lights()).endMovie();
    }
}
class Amplifier { void on() { System.out.println("amp on"); } void volume(int v) { System.out.println("amp volume " + v); } void off() { System.out.println("amp off"); } }
class Projector { void on() { System.out.println("projector on"); } void play(String m) { System.out.println("playing " + m); } void off() { System.out.println("projector off"); } }
class Lights { void dim(int p) { System.out.println("lights dim " + p + "%"); } void full() { System.out.println("lights full"); } }
class HomeTheaterFacade {                                   // client calls 1 method instead of orchestrating 6 calls
    private final Amplifier amp; private final Projector proj; private final Lights lights;
    HomeTheaterFacade(Amplifier a, Projector p, Lights l) { amp = a; proj = p; lights = l; }
    void watchMovie(String m) { lights.dim(10); amp.on(); amp.volume(7); proj.on(); proj.play(m); }
    void endMovie() { proj.off(); amp.off(); lights.full(); }
}
