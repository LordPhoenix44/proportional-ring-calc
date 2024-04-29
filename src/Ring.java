import java.util.Scanner;

public class Ring {
    private int radius; //in mm
    private int width; //in mm, usually 5
    private int[] segments; //each in degs
    private Scanner scan = new Scanner(System.in);

    public Ring(int radius, int numosegs) {
        this.radius = radius;
        this.segments = new int[numosegs];
    }

    public int getRadius() {return this.radius;}
    public int getWidth() {return this.width;}
    public int[] getSegments() {return this.segments;}

    public void setWidth(int width) {this.width = width;}
    public void setSegments(boolean abs) {
        for(int i=0; i<segments.length; i++) {
            System.out.println("Größe von Segment "+(i+1)+": ");
            int rawin = scan.nextInt();
            int segdegs = 0;
            if(abs == true) {
            } else {
                segdegs = (int)(rawin * 3.6);
            }
            this.segments[i] = segdegs;
        }
    }
}
