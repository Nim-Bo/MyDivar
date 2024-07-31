import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class User implements Ads , Fav {
    private String username;
    private HashSet<String> ads = new HashSet<String>();
    private HashSet<String> favs = new HashSet<String>();
    private HashMap<String,HashSet<String>> tags = new HashMap<String,HashSet<String>>();

    public void register(String u) {
        username = u;
    }

    @Override
    public void add_advertise(String t) {
        ads.add(t);
        HashSet<String> tag = new HashSet<String>();
        tags.put(t,tag);
    }

    @Override
    public void add_advertise(String t, HashSet<String> tag) {
        ads.add(t);
        tags.put(t,tag);
    }

    @Override
    public void rem_advertise(String t) {
        ads.remove(t);
        tags.remove(t);
    }

    @Override
    public HashSet<String> list_my_advertises() {
        return ads;
    }

    @Override
    public HashSet<String> list_my_advertises(HashSet<String> tag) {
        HashSet<String> res = new HashSet<String>();
        for(String title : ads) {
            HashSet<String> adTags = tags.get(title);
            if(adTags.contains(tag)) {
                res.add(title);
            }
        }
        return res;
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

    @Override
    public HashSet<String> list_favorite_advertises(HashSet<String> tag) {
        HashSet<String> res = new HashSet<String>();
        for(String title : favs) {
            HashSet<String> adTags = tags.get(title);
            if(adTags.contains(tag)) {
                res.add(title);
            }
        }
        return res;
    }
}
