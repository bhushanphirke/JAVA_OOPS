
import java.io.*;

class feedbackprocessor {

    String feedback;

    public void insert1() {
        try {
            System.out.println("Enter your feedback");
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

            feedback = br.readLine();
        }
        catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }

   
    public void display(int i) {

        System.out.println("Feedback " + (i + 1) + " : " + feedback);

        int words = 0;

        if (feedback.length() > 0) {
            words = 1;

            for (int j = 0; j < feedback.length(); j++) {

                if (feedback.charAt(j) == ' ') {
                    words++;
                }
            }
        }

        System.out.println("Word Count : " + words);
    }


    public void blacklisted() {

        String[] blacklist = {"not", "never", "no"};

        String text = feedback.toLowerCase();

        for (int i = 0; i < blacklist.length; i++) {

            if (text.contains(blacklist[i])) {
                System.out.println("Blacklisted Status : True");
                return;
            }
        }

        System.out.println("Blacklisted Status : False");
    }


    public void reverseFeedbacks() {

        StringBuilder sb = new StringBuilder(feedback);

        System.out.println("Reverse : " + sb.reverse());
    }
}


public class Assignment2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter how many feedback you want to enter");
        int n = Integer.parseInt(br.readLine());

        feedbackprocessor[] feedarr =
            new feedbackprocessor[n];

        for (int i = 0; i < n; i++) {

            feedarr[i] = new feedbackprocessor();

            feedarr[i].insert1();
        }

        System.out.println("\n");

    
        for (int i = 0; i < n; i++) {

            feedarr[i].display(i);

            feedarr[i].reverseFeedbacks();

            feedarr[i].blacklisted();

            System.out.println();
        }


        long start1 = System.nanoTime();

        String report1 = "";

        for (int i = 0; i < n; i++) {

            report1 = report1 + feedarr[i].feedback + "\n";
        }

        long end1 = System.nanoTime();

        long time1 = end1 - start1;


        long start2 = System.nanoTime();

        StringBuilder report2 = new StringBuilder();

        for (int i = 0; i < n; i++) {

            report2.append(feedarr[i].feedback);
            report2.append("\n");
        }

        long end2 = System.nanoTime();

        long time2 = end2 - start2;


        System.out.println("Daily Report");

        System.out.println(report2);


        System.out.println("Time Comparison");

        System.out.println(
            "String Concatenation Time : " + time1);

        System.out.println(
            "StringBuilder Time : " + time2);
    }
}

