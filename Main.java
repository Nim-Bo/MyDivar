import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        HashSet<String> titles = new HashSet<String>();
        HashMap<String,User> users = new HashMap<String,User>();

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        for(int i=0;i < n;i++) {
            String thisLine = input.nextLine();
            String[] parts = thisLine.split(" ");
            String order = parts[0];

            if(order.equals("register")) {
                String username = parts[1];
                if(users.keySet().contains(username)) {
                    System.out.println("invalid username");
                }
                else {
                    User newUser = new User();
                    newUser.register(username);
                    users.put(username,newUser);
                    System.out.println("registered successfully");
                }
            }

            else if(order.equals("add_advertise")) {
                String username = parts[1];
                String title = parts[2];
                if(!users.keySet().contains(username)) {
                    System.out.println("invalid username");
                }
                else if(titles.contains(title)) {
                    System.out.println("invalid title");
                }
                else {
                    titles.add(title);
                    HashSet<String> tags = new HashSet<String>();
                    for(int j=3;j < parts.length;j++) {
                        tags.add(parts[j]);
                    }
                    User user = users.get(username);
                    user.add_advertise(title, tags);
                    users.put(username,user);
                    System.out.println("posted successfully");
                }
            }

            else if(order.equals("rem_advertise")) {
                String username = parts[1];
                String title = parts[2];
                if(!users.keySet().contains(username)) {
                    System.out.println("invalid username");
                }
                else if(!titles.contains(title)) {
                    System.out.println("invalid title");
                }
                else if(!users.get(username).list_my_advertises().contains(title)) {
                    System.out.println("access denied");
                }
                else {
                    titles.remove(title);
                    User user = users.get(username);
                    user.rem_advertise(title);
                    users.put(username,user);
                    System.out.println("removed successfully");
                }
            }

            else if(order.equals("list_my_advertises")) {
                String username = parts[1];
                if(!users.keySet().contains(username)) {
                    System.out.println("invalid username");
                }
                else {
                    User user = users.get(username);
                    HashSet<String> ads;
                    if(parts.length > 2) {
                        HashSet<String> tags = new HashSet<String>();
                        for (int j = 3; j < parts.length; j++) {
                            tags.add(parts[j]);
                        }
                        ads = user.list_my_advertises(tags);
                    }
                    else {
                        ads = user.list_my_advertises();
                    }
                    for(String ad : ads) {
                        System.out.print(ad + " ");
                    }
                    System.out.println();
                }
            }

            else if(order.equals("add_favorite")) {
                String username = parts[1];
                String title = parts[2];
                if(!users.keySet().contains(username)) {
                    System.out.println("invalid username");
                }
                else if(!titles.contains(title)) {
                    System.out.println("invalid title");
                }
                else if(users.get(username).list_favorite_advertises().contains(title)) {
                    System.out.println("already favorite");
                }
                else {
                    User user = users.get(username);
                    user.add_favorite(title);
                    users.put(username,user);
                    System.out.println("added successfully");
                }
            }

            else if(order.equals("rem_favorite")) {
                String username = parts[1];
                String title = parts[2];
                if(!users.keySet().contains(username)) {
                    System.out.println("invalid username");
                }
                else if(!titles.contains(title)) {
                    System.out.println("invalid title");
                }
                else if(!users.get(username).list_favorite_advertises().contains(title)) {
                    System.out.println("already not favorite");
                }
                else {
                    titles.remove(title);
                    User user = users.get(username);
                    user.rem_favorite(title);
                    users.put(username,user);
                    System.out.println("removed successfully");
                }
            }

            else if(order.equals("list_favorite_advertises")) {
                String username = parts[1];
                if(!users.keySet().contains(username)) {
                    System.out.println("invalid username");
                }
                else {
                    User user = users.get(username);
                    HashSet<String> favs;
                    if(parts.length > 2) {
                        HashSet<String> tags = new HashSet<String>();
                        for (int j = 3; j < parts.length; j++) {
                            tags.add(parts[j]);
                        }
                        favs = user.list_favorite_advertises(tags);
                    }
                    else {
                        favs = user.list_favorite_advertises();
                    }
                    for(String fav : favs) {
                        System.out.print(fav + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
