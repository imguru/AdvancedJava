import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Utils {
    static void sort(int[] arr, Comparator<Integer> comparator) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (comparator.compare(arr[i], arr[j]) > 0) {
                    // if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static User create(String name, int age) {
        return new User(name, age);
    }

    public static List<User> users() {
        return Arrays.asList(
                User.create("Tom", 42),
                User.create("Ann", 15),
                User.create("Scott", 10)
        );
    }
}

class Example8 {
    public static void main(String[] args) {
        List<User> users = User.users();

        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        Collections.sort(users, (o1, o2) -> o1.getAge() - o2.getAge());
        Collections.sort(users, Comparator.comparing(User::getName));

        for (User u : users) {
            System.out.println(u);
        }


        int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        Utils.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });

        Utils.sort(arr, (o1, o2) -> Integer.compare(o1, o2));
        Utils.sort(arr, Integer::compare);

        for (int e : arr)
            System.out.println(e);
    }
}

