import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Lab 1 variant 10: formula solver and current date printer
 * */
public class Formula {
    private double x;
    private double y;
    private double z;

    private double c;
    private double f;

    public Formula() {
    }

    public Formula(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        calculateAll();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double calculateC(){
        this.c = Math.abs(Math.pow(x, y / x) - Math.pow(y / x, 1 / 3));
        return this.c;
    }

    public double calculateF(){
        this.f = (y - x) * (y - z) / (y - x) / (1 + Math.pow((y - x), 2));
        return this.f;
    }

    public void calculateAll(){
        calculateC();
        calculateF();
    }

    public double getC() {
        return c;
    }

    public double getF() {
        return f;
    }

    public void printAllToStdOut(){
//        System.out.printf("x = %f\ny = %f\nz = %f\n\nResult:\nc = %f\nf = %f\n",
//                getX(), getY(), getZ(), getC(), getF());
        System.out.printf("x = %f\ny = %f\nz = %f\n\nResult:\n",
                getX(), getY(), getZ());
        printResultsToStdOut();
    }

    public void printResultsToStdOut(){
        System.out.printf("c = %f\nf = %f\n", getC(), getF());
    }

    public static void printCurrentTime(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm\tdd-MM-yy");
        System.out.println(dateFormat.format(date));
    }

    public void readAndPrint(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter x value:");
            setX(scanner.nextDouble());
            System.out.println("Enter y value:");
            setY(scanner.nextDouble());
            System.out.println("Enter z value:");
            setZ(scanner.nextDouble());
        }
        catch (InputMismatchException mismatchException){
            System.out.println("You've entered wrong floating number. Probably, you should try to write floating number with comma, instead of dot.");
            throw mismatchException;
        }
        catch (Exception e){
            System.out.println("Error occured while entering data.");
            throw e;
        }
        System.out.printf("\nResult:\nc = %f\nf = %f", calculateC(), calculateF());
    }

    public static void main(String argc[]){
        Formula.printCurrentTime();
        Formula formula1 = new Formula(1.825, 18.225, -3.298);
        formula1.printResultsToStdOut();
        Formula formula2 = new Formula();
        formula2.readAndPrint();
    }
}
