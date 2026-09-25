import java.util.*;

/** Run: java design-patterns/examples/MediatorDemo.java  Colleagues talk to a mediator, not to each other. */
public class MediatorDemo {
    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        User ann = new User("ann", room), bob = new User("bob", room), cy = new User("cy", room);
        ann.say("hi all");
        bob.say("hello ann");
        System.out.println("each user knows only the room, not the other " + (room.userCount() - 1) + " users");
    }
}
class ChatRoom {                                                   // the mediator centralizes the interaction rules
    private final List<User> users = new ArrayList<>();
    void join(User u) { users.add(u); }
    void broadcast(User from, String msg) { for (User u : users) if (u != from) u.receive(from.name, msg); }
    int userCount() { return users.size(); }
}
class User {
    final String name; private final ChatRoom room;
    User(String name, ChatRoom room) { this.name = name; this.room = room; room.join(this); }
    void say(String m) { System.out.println(name + " says: " + m); room.broadcast(this, m); }
    void receive(String from, String m) { System.out.println("  " + name + " got '" + m + "' from " + from); }
}
