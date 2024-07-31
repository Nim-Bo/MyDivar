import java.util.HashSet;

public interface Fav {
    public void add_favorite(String title);
    public void rem_favorite(String title);
    public HashSet<String> list_favorite_advertises();
}
