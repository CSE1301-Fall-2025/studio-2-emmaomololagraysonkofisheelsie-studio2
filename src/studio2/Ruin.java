import java.util.Scanner;
import java.lang.Math;

public class Ruin {
    public static void main(String[] arcs)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Start amount: ");
        int startAmount = scanner.nextInt();

        System.out.print("Win chance (integer): ");
        double winChance = scanner.nextInt();

        System.out.print("Win limit: ");
        int winLimit = scanner.nextInt();

        int wins = 0;
        int losses = 0;
        int totalRuns = 0;

        double ruinRate = 0.0;
        double expectedRuinRate = 0.0;
        double a = (1-winChance)/winChance;
        
        while(wins <= winLimit)
        {
            if(Math.random()>0.49)
            {
                wins++;
                totalRuns++;
                System.out.println("Simulation " + totalRuns + ": WIN");
            }
            else
            {
                losses++;
                totalRuns++;
                System.out.println("Simulation " + totalRuns + ": LOSS");
            }

        }

        if(winChance == 0.5)
        {
            expectedRuinRate = 1-(startAmount/winLimit);
        }
        else
        {
            expectedRuinRate = (Math.pow(a, startAmount) - Math.pow(a, winLimit))/1-Math.pow(a, winLimit);
        }

        ruinRate = losses/totalRuns;

        System.out.println("Losses: " + losses);
        System.out.println("Simulations: " + totalRuns);
        System.out.println("Ruin rate from simulation: " + ruinRate + "Expected ruin rate: " + expectedRuinRate);

        scanner.close();
    }
}
