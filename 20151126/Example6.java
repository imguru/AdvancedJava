import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static User create(String name, int age) {
        return new User(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<User> filterUsersByName(List<User> users, String name) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.name.equals(name))
                // if (user.equals("Tom"))
                result.add(user);
        }

        return result;
    }

    public static List<User> filterTeenager(List<User> users) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (user.age >= 10 && user.age < 20)
                result.add(user);
        }

        return result;
    }

    public static List<User> filterUsers(List<User> users, UserPredicate predicate) {
        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user))
                result.add(user);
        }

        return result;
    }
}


interface UserPredicate {
    boolean test(User user);
}


class NamePredicate implements UserPredicate {
    private String name;
    public NamePredicate(String name) {
        this.name = name;
    }

    @Override
    public boolean test(User user) {
        return user.getName().equals(name);
    }
}

class TeenagerPredicate implements UserPredicate {
    @Override
    public boolean test(User user) {
        return user.getAge() >= 10 && user.getAge() <= 20;
    }
}


class Example6 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(User.create("Tom", 42));
        users.add(User.create("Ann", 18));
        users.add(User.create("Scott", 15));

        users = User.filterUsers(users, new NamePredicate("Tom"));
        users = User.filterUsers(users, new TeenagerPredicate());

        // users = User.filterUsersByName(users, "Tom");
        // users = User.filterTeenager(users);

        for (User u : users)
            System.out.println(u);
    }
}


