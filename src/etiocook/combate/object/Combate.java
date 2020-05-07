package etiocook.combate.object;

public class Combate {

    private String name;
    private long delay;

    public Combate(String name, long delay) {
        this.name = name;
        this.delay = delay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

}
