import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initiating Classes
        Scanner scan = new Scanner(System.in);
        Chart myChart = new Chart();

        /*//Initiating Vars
        int numorings;
        int numosegs;
        boolean absolutenums = false;
        int smallest;
        Ring[] rings;*/

        //Setting up Program //TODO: myChart-Constructor
        System.out.println("How many Rings will there be?");
        myChart.setNumorings(scan.nextInt());
        System.out.println("How many Segments will be in each ring?");
        myChart.setNumosegs(scan.nextInt());
        System.out.println("Do you want to provide the segment's size in absolute numbers instead of percents? [y/n]");
        myChart.setAbs("n");//myChart.setAbs(scan.nextLine());

        //Creating rings first Ring
        System.out.println("Please provide the absolut size of the smallest \"ring\" (circle)");
        myChart.setSmallest(scan.nextInt());
        myChart.setSmallestR(50);
        myChart.setValuePerArea();

        myChart.createRings();

        System.out.println(myChart);
    }
}