import java.util.Objects;

public class Job {
    private String title;
    private double salary;
    private String position;

    public Job(String title, double salary, String position) {
        this.title = title;
        this.salary = salary;
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Job{" +
                "title='" + title + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return Double.compare(job.getSalary(), getSalary()) == 0 && Objects.equals(getTitle(), job.getTitle()) && Objects.equals(getPosition(), job.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSalary(), getPosition());
    }
}
