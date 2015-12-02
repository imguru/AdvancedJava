import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Example3 {
    public static void main(String[] args) {
        List<Task> tasks = Task.getTasks();

        List<Task> readingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == TaskType.READING) {
                readingTasks.add(task);
            }
        }

        Collections.sort(readingTasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getTitle().length() - o2.getTitle().length();
            }
        });

        for (Task task : readingTasks) {
            System.out.println(task.getTitle());
        }
    }
}


enum TaskType {
    READING, CODING
}


class Task {
    private final String title;
    private final TaskType type;
    private LocalDate createdOn;
    private Set<String> tags = new HashSet<>();

    public Task(String title, TaskType type, LocalDate date) {
        this.title = title;
        this.type = type;
        this.createdOn = date;
    }

    public Task addTag(String tag) {
        tags.add(tag);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public TaskType getType() {
        return type;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public Set<String> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if (!(o instanceof Task))
            return false;

        Task task = (Task) o;
        return Objects.equals(title, task.title) &&
                Objects.equals(type, task.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type);
    }

    public static List<Task> getTasks() {
        Task task1 = new Task("Effective Java", TaskType.READING, LocalDate.of(2015, Month.DECEMBER, 30))
                .addTag("Effective Java").addTag("Books");
        Task task2 = new Task("Java8 in Action", TaskType.READING, LocalDate.of(2015, Month.DECEMBER, 25))
                .addTag("Java").addTag("Books");
        Task task3 = new Task("Android App", TaskType.CODING, LocalDate.of(2015, Month.DECEMBER, 24))
                .addTag("Android");
        Task task4 = new Task("Android Framework", TaskType.CODING, LocalDate.of(2015, Month.DECEMBER, 22))
                .addTag("Android Framework");

        return Stream.of(task1, task2, task3, task4).collect(Collectors.toList());
    }
}
