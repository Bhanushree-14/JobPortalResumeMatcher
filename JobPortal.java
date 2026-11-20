
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

        // Create candidate object
        Candidate candidate =
                new Candidate(name, email, skill1, skill2);

        System.out.println("\nCandidate registered successfully!");

        return candidate;
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

        // Job selection
        System.out.print("\nEnter job number to apply: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= jobs.length) {

            int match = 0;

            // Check candidate skills
            if (candidate.hasSkill(jobs[choice - 1].skill1)) {
                match++;
            }

            if (candidate.hasSkill(jobs[choice - 1].skill2)) {
                match++;
            }

            // Calculate matching percentage
            int percentage = match * 50;

            // Display application details
            System.out.println("\n================================");
            System.out.println("       APPLICATION DETAILS");
            System.out.println("================================");

            candidate.displayCandidate();

            System.out.println("Selected Job: "
                    + jobs[choice - 1].jobName);

            System.out.println("Job Description: "
                    + jobs[choice - 1].description);

            System.out.println("Required Skills: "
                    + jobs[choice - 1].skill1 + ", "
                    + jobs[choice - 1].skill2);

            System.out.println("Matching Skills: " + match + "/2");

            System.out.println("Match Percentage: " + percentage + "%");

            // Application status
            if (percentage >= 50) {
                System.out.println(
                        "Application Status: Applied Successfully");
            } else {
                System.out.println(
                        "Application Status: Low Skill Match");
            }

        } else {
            System.out.println("Invalid Job Number!");
        }

        System.out.println("\nThank you for using Job Portal!");

        sc.close();
    }
}
