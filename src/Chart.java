import java.util.Scanner;

public class Chart {
    private int numorings;
    private int numosegs;
    private boolean absolutenums;
    private int smallest;
    private int smallest_r;
    private int valuePerArea;
    private Ring[] rings;
    private Scanner scan = new Scanner(System.in);

    public void setNumorings(int numorings) {
        this.numorings = numorings;
        this.rings = new Ring[numorings];
    }

    public void setNumosegs(int numosegs) {this.numosegs = numosegs;}

    public void setAbs(String yn) {
        if(yn.equalsIgnoreCase("y")) {
            this.absolutenums = true;
        } else {
            this.absolutenums = false;
        }
    }

    public void setSmallest(int smallest) {this.smallest = smallest;}

    public void setSmallestR(int smallest_r) {
        this.smallest_r = smallest_r;
    }

    public void setValuePerArea() {
        this.valuePerArea = (int)(this.smallest / ((22.0/7.0) * this.smallest_r * this.smallest_r));
    }

    public void createRings() {
        this.rings[0] = new Ring(this.smallest_r, this.numosegs);
        this.rings[0].setSegments(this.absolutenums);
        this.rings[0].setWidth(50);
        for(int i = 1; i < this.numorings; i++) {
            System.out.println("Please provide the Value of the next Circle: ");
            int Size = scan.nextInt();
            this.rings[i] = new Ring(this.absRadCalc(Size), this.numosegs);
            this.rings[i].setSegments(this.absolutenums);
            this.rings[i].setWidth(50);
        }
    }

    public int absRadCalc(int Size) { //for rings with hard ring-width
        float wantedArea = (float)((Size * this.smallest_r * this.smallest_r * (22.0/7.0)) / this.smallest);
        return (int)(((wantedArea / (22.0 / 7.0)) + (this.smallest_r * this.smallest_r)) / (2 * this.smallest_r));
        //return (int)((((Size/this.smallest)-1.0)*this.smallest_r)/2.0);
    }

    @Override
    public String toString() {
        String back = "";

        for (int i = 0; i < this.numorings; i++) {
            int[] segs = this.rings[i].getSegments();
            back += "Ring " + (i+1) + ": \n";
            back += "\tÄußerer Radius: " + this.rings[i].getRadius() + "\n";
            back += "\tRingbreite: " + this.rings[i].getWidth() + "\n";
            back += "\tSegmente (" + this.numosegs + "):\n";
            for(int ii = 0; ii < this.numosegs; ii++) {
                back += "\t\tSegment " + ii + ": " + segs[ii] + "\n";
            }
        }

        return back;
    }
}
