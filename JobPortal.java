
import java.util.Scanner;

public class JobPortal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Available job postings
        String[] jobs = {
            "Java Developer",
            "Python Developer",
            "Web Developer"
        };

        // Required skills for each job
        String[][] requiredSkills = {
            {"Java", "SQL"},
            {"Python", "Machine Learning"},
            {"HTML", "CSS"}
        };

        System.out.println("================================");
        System.out.println("       JOB PORTAL SYSTEM");
        System.out.println("================================");

        // Display jobs and required skills
        System.out.println("\nAvailable Job Postings:");

        for (int i = 0; i < jobs.length; i++) {

            System.out.println("\n" + (i + 1) + ". " + jobs[i]);

            System.out.println("   Required Skills: ");

            for (int j = 0; j < requiredSkills[i].length; j++) {
                System.out.println("   - " + requiredSkills[i][j]);
            }
        }

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

        // Select a job
        System.out.print("\nEnter job number to apply: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= jobs.length) {

            int match = 0;

            // Compare candidate skills with job skills
            if (skill1.equalsIgnoreCase(requiredSkills[choice - 1][0])
                    || skill2.equalsIgnoreCase(requiredSkills[choice - 1][0])) {
                match++;
            }

            if (skill1.equalsIgnoreCase(requiredSkills[choice - 1][1])
                    || skill2.equalsIgnoreCase(requiredSkills[choice - 1][1])) {
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

            System.out.println("Selected Job: " + jobs[choice - 1]);

            System.out.println("Required Skills: "
                    + requiredSkills[choice - 1][0] + ", "
                    + requiredSkills[choice - 1][1]);

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
