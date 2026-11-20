
import java.util.Scanner;

public class JobPortal {

    // Method to display all available jobs
    public static void displayJobs(Job[] jobs) {

        System.out.println("\nAvailable Job Postings:");

        for (int i = 0; i < jobs.length; i++) {
            System.out.println("\nJob " + (i + 1));
            jobs[i].displayJobRequirements();
        }
    }

    // Method to register a candidate
    public static Candidate registerCandidate(Scanner sc) {

        System.out.println("\n--- Candidate Registration ---");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.print("Enter your first skill: ");
        String skill1 = sc.nextLine();

        System.out.print("Enter your second skill: ");
        String skill2 = sc.nextLine();

        Candidate candidate =
                new Candidate(name, email, skill1, skill2);

        System.out.println("\nCandidate registered successfully!");

        return candidate;
    }

    // Method to select a job using number or name
    public static Job selectJob(Scanner sc, Job[] jobs) {

        System.out.print("\nEnter job number or job name: ");
        String choice = sc.nextLine().trim();

        // Check if the input is a job number
        try {
            int jobNumber = Integer.parseInt(choice);

            if (jobNumber >= 1 && jobNumber <= jobs.length) {
                return jobs[jobNumber - 1];
            }

        } catch (NumberFormatException e) {
            // Input is not a number, so search by job name
        }

        // Search for job by name
        for (Job job : jobs) {

            if (job.jobName.equalsIgnoreCase(choice)) {
                return job;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create job objects with descriptions
        Job[] jobs = {

            new Job("Java Developer", "Java", "SQL",
                    "Develop and maintain Java-based applications."),

            new Job("Python Developer", "Python", "Machine Learning",
                    "Build Python applications and machine learning models."),

            new Job("Web Developer", "HTML", "CSS",
                    "Design and develop attractive websites.")
        };

        System.out.println("================================");
        System.out.println("       JOB PORTAL SYSTEM");
        System.out.println("================================");

        // Display available jobs
        displayJobs(jobs);

        // Register candidate
        Candidate candidate = registerCandidate(sc);

        // Select job
        Job selectedJob = selectJob(sc, jobs);

        if (selectedJob != null) {

            int match = 0;

            // Check candidate skills
            if (candidate.hasSkill(selectedJob.skill1)) {
                match++;
            }

            if (candidate.hasSkill(selectedJob.skill2)) {
                match++;
            }

            // Calculate matching percentage
            int percentage = match * 50;

            // Display application details
            System.out.println("\n================================");
            System.out.println("       APPLICATION DETAILS");
            System.out.println("================================");

            candidate.displayCandidate();

            System.out.println("Selected Job: " + selectedJob.jobName);

            System.out.println("Job Description: "
                    + selectedJob.description);

            System.out.println("Required Skills: "
                    + selectedJob.skill1 + ", "
                    + selectedJob.skill2);

            System.out.println("Matching Skills: " + match + "/2");

            System.out.println("Match Percentage: " + percentage + "%");

            if (percentage >= 50) {
                System.out.println(
                        "Application Status: Applied Successfully");
            } else {
                System.out.println(
                        "Application Status: Low Skill Match");
            }

        } else {
            System.out.println(
                    "Job not found! Please select a valid job.");
        }

        System.out.println("\nThank you for using Job Portal!");

        sc.close();
    }
}
