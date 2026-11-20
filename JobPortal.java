
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

        try {
            int jobNumber = Integer.parseInt(choice);

            if (jobNumber >= 1 && jobNumber <= jobs.length) {
                return jobs[jobNumber - 1];
            }

        } catch (NumberFormatException e) {
            // Search by job name
        }

        for (Job job : jobs) {

            if (job.jobName.equalsIgnoreCase(choice)) {
                return job;
            }
        }

        return null;
    }

    // Method to count matching skills
    public static int countMatchingSkills(Candidate candidate, Job job) {

        int match = 0;

        if (candidate.hasSkill(job.skill1)) {
            match++;
        }

        if (candidate.hasSkill(job.skill2)) {
            match++;
        }

        return match;
    }

    // Method to calculate matching percentage
    public static int calculateMatchPercentage(int matchingSkills) {

        int totalSkills = 2;

        return (matchingSkills * 100) / totalSkills;
    }

    // Method to display matched and missing skills
    public static void displaySkillDetails(Candidate candidate, Job job) {

        System.out.println("\n--- SKILL MATCHING DETAILS ---");

        System.out.println("Matched Skills:");

        boolean hasMatch = false;

        if (candidate.hasSkill(job.skill1)) {
            System.out.println("- " + job.skill1);
            hasMatch = true;
        }

        if (candidate.hasSkill(job.skill2)) {
            System.out.println("- " + job.skill2);
            hasMatch = true;
        }

        if (!hasMatch) {
            System.out.println("No matching skills found.");
        }

        System.out.println("\nMissing Skills:");

        boolean hasMissing = false;

        if (!candidate.hasSkill(job.skill1)) {
            System.out.println("- " + job.skill1);
            hasMissing = true;
        }

        if (!candidate.hasSkill(job.skill2)) {
            System.out.println("- " + job.skill2);
            hasMissing = true;
        }

        if (!hasMissing) {
            System.out.println("No missing skills!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create job objects
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

            // Count matching skills
            int match = countMatchingSkills(candidate, selectedJob);

            // Calculate matching percentage
            int percentage = calculateMatchPercentage(match);

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

            // Display matched and missing skills
            displaySkillDetails(candidate, selectedJob);

            System.out.println("\nMatching Skills: " + match + "/2");

            System.out.println("Match Percentage: " + percentage + "%");

            // Create application record
            String status;

            if (percentage >= 50) {
                status = "Applied Successfully";
            } else {
                status = "Low Skill Match";
            }

            Application application = new Application(
                    candidate.name,
                    selectedJob.jobName,
                    percentage,
                    status
            );

            // Display application tracking details
            application.displayApplication();

        } else {

            System.out.println(
                    "Job not found! Please select a valid job.");
        }

        System.out.println("\nThank you for using Job Portal!");

        sc.close();
    }
}
