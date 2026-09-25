/** Run: java design-patterns/examples/BridgeDemo.java  Two independent hierarchies (abstraction x implementation) instead of a class explosion. */
public class BridgeDemo {
    public static void main(String[] args) {
        Device tv = new Tv(), radio = new Radio();
        Remote basic = new Remote(tv), advanced = new AdvancedRemote(radio);
        basic.togglePower();
        advanced.togglePower();
        ((AdvancedRemote) advanced).mute();
        System.out.println("2 remote types x 2 device types = 4 combinations from 4 classes; a third device adds ONE class, not two");
    }
}
interface Device { boolean isOn(); void setOn(boolean on); void setVolume(int v); String name(); }   // implementation side
class Tv implements Device { boolean on; public boolean isOn() { return on; } public void setOn(boolean o) { on = o; } public void setVolume(int v) {} public String name() { return "TV"; } }
class Radio implements Device { boolean on; public boolean isOn() { return on; } public void setOn(boolean o) { on = o; } public void setVolume(int v) {} public String name() { return "Radio"; } }
class Remote {                                                    // abstraction side, holds a reference to the implementation
    protected final Device device;
    Remote(Device d) { device = d; }
    void togglePower() { device.setOn(!device.isOn()); System.out.println(getClass().getSimpleName() + " toggled " + device.name() + ", on=" + device.isOn()); }
}
class AdvancedRemote extends Remote {
    AdvancedRemote(Device d) { super(d); }
    void mute() { device.setVolume(0); System.out.println("AdvancedRemote muted " + device.name()); }
}
