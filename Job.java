
public class Job {

    String jobName;
    String skill1;
    String skill2;

    // Constructor
    public Job(String jobName, String skill1, String skill2) {
        this.jobName = jobName;
        this.skill1 = skill1;
        this.skill2 = skill2;
    }

    // Display job details
    public void displayJob() {
        System.out.println("Job Name: " + jobName);
        System.out.println("Required Skills: " + skill1 + ", " + skill2);
    }
}
