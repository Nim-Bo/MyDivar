import java.util.HashSet;

public interface Ads {
    public void add_advertise(String title);
    public void add_advertise(String title, HashSet<String> tags);
    public void rem_advertise(String title);
    public HashSet<String> list_my_advertises();
    public HashSet<String> list_my_advertises(HashSet<String> tags);
}
