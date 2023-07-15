import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("java Job", 300, "Fresher"),
                new Job("Python Job", 400, "tester"),
                new Job("JavaScript Job", 250, "Font end"));
        Supplier<Stream<Job>> supplier = () -> jobs.stream();
        jobs.forEach(System.out::println);
        boolean isLoop = true;
        System.out.println("Please choosing option to operation :");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine();
        while (option < 10) {
            System.out.println("please type your job title you want to check: ");
            String jobTitle = scanner.next();

            switch (option) {
                case 0:
                    System.out.println("option 0 : anyMatch function to return if one job match the title input");
                    boolean isExist = supplier.get().anyMatch(job -> job.getTitle().contains(jobTitle));
                    System.out.println("anyMatch: " + isExist);
                    break;
                case 1:
                    System.out.println("option 1 : allMatch function to return value all job title match with input");
                    boolean isAllMatch = supplier.get().allMatch(job -> job.getTitle().contains(jobTitle));
                    System.out.println("All job title match:" + isAllMatch);

                    break;
                case 2:
                    System.out.println("option 2 : nonMatch function to return boolean value element match with job title");
                    boolean isNonMatch = supplier.get().noneMatch(job -> job.getTitle().contains(jobTitle));
                    System.out.println("nonMatch : " + isNonMatch);
                    break;
                case 3:
                    System.out.println("option 3 : count function to return numbers of element in stream");
                    System.out.println("Number of items in stream: " + supplier.get().count());
                    break;
                case 4:
                    System.out.println("option 4 : findAny function to return any element in stream");
                    System.out.println("Find any" + supplier.get().findAny().get());
                    break;
                case 5:
                    System.out.println("option 5 : findFirst function to return first element in stream");
                    System.out.println("Find first" + supplier.get().findFirst().get());

                    break;
                case 6:
                    System.out.println("option 6 : forEach function");
                    supplier.get().forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("option 7 : min function to return smallest salary job");
                    Job job = supplier.get().min((o1, o2) -> {
                        double value = o1.getSalary() - o2.getSalary();
                        return (int) value;
                    }).get();
                    System.out.println("Job min salary: " + job);
                    break;
                case 8:
                    System.out.println("option 8 : max function to return biggest salary job");
                    Job job2 = supplier.get().max((o1, o2) -> {
                        double value = o1.getSalary() - o2.getSalary();
                        return (int) value;
                    }).get();
                    System.out.println("Job max salary: " + job2);
                    break;

                case 9:
                    System.out.println("other: to Arrays");
                    Object[] objects = supplier.get().toArray();
                    System.out.println(objects);
                    break;
            }
        }

    }
}
