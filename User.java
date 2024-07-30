import java.util.HashSet;
import java.util.LinkedList;

public class User implements Ads {
    private String username;
    private HashSet<String> ads = new HashSet<String>();

    public void register(String u) {
        username = u;
    }

    @Override
    public void add_advertise(String t) {
        ads.add(t);
    }

    @Override
    public void rem_advertise(String t) {
        ads.remove(t);
    }

    @Override
    public HashSet<String> list_my_advertises() {
        return ads;
    }
}
