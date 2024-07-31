import java.util.HashSet;
import java.util.LinkedList;

public class User implements Ads , Fav {
    private String username;
    private HashSet<String> ads = new HashSet<String>();
    private HashSet<String> favs = new HashSet<String>();

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

    @Override
    public void add_favorite(String t) {
        favs.add(t);
    }

    @Override
    public void rem_favorite(String t) {
        favs.remove(t);
    }

    @Override
    public HashSet<String> list_favorite_advertises() {
        return favs;
    }
}
