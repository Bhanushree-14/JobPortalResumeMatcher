
import java.util.Scanner;

public class JobPortal {

    // Method to display all available jobs
    public static void displayJobs(Job[] jobs) {

        System.out.println("\nAvailable Job Postings:");

        for (int i = 0; i < jobs.length; i++) {

            System.out.println("\nJob " + (i + 1));
            jobs[i].displayJob();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create job objects
        Job[] jobs = {
            new Job("Java Developer", "Java", "SQL"),
            new Job("Python Developer", "Python", "Machine Learning"),
            new Job("Web Developer", "HTML", "CSS")
        };

        System.out.println("================================");
        System.out.println("       JOB PORTAL SYSTEM");
        System.out.println("================================");

        // Display available jobs using the method
        displayJobs(jobs);

        // Candidate registration
        System.out.println("\n--- Candidate Registration ---");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your email: ");
        String email = sc.nextLine();

        System.out.print("Enter your first skill: ");
        String skill1 = sc.nextLine();

        System.out.print("Enter your second skill: ");
        String skill2 = sc.nextLine();

        // Job selection
        System.out.print("\nEnter job number to apply: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= jobs.length) {

            int match = 0;

            // Check first required skill
            if (skill1.equalsIgnoreCase(jobs[choice - 1].skill1)
                    || skill2.equalsIgnoreCase(jobs[choice - 1].skill1)) {
                match++;
            }

            // Check second required skill
            if (skill1.equalsIgnoreCase(jobs[choice - 1].skill2)
                    || skill2.equalsIgnoreCase(jobs[choice - 1].skill2)) {
                match++;
            }

            // Calculate matching percentage
            int percentage = match * 50;

            // Display application details
            System.out.println("\n================================");
            System.out.println("       APPLICATION DETAILS");
            System.out.println("================================");

            System.out.println("Candidate Name: " + name);
            System.out.println("Email: " + email);

            System.out.println("Candidate Skills: " + skill1 + ", " + skill2);

            System.out.println("Selected Job: " + jobs[choice - 1].jobName);

            System.out.println("Required Skills: "
                    + jobs[choice - 1].skill1 + ", "
                    + jobs[choice - 1].skill2);

            System.out.println("Matching Skills: " + match + "/2");

            System.out.println("Match Percentage: " + percentage + "%");

            // Application status
            if (percentage >= 50) {
                System.out.println("Application Status: Applied Successfully");
            } else {
                System.out.println("Application Status: Low Skill Match");
            }

        } else {
            System.out.println("Invalid Job Number!");
        }

        System.out.println("\nThank you for using Job Portal!");

        sc.close();
    }
}
