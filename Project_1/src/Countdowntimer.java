import java.util.Timer;
import java.util.TimerTask;

public class Countdowntimer {
    private Timer timer;
    private int timeLeft; 

    public Countdowntimer() {
        this.timer = new Timer();
        this.timeLeft = 40; 
    }

    public void start(Runnable onTimeUp) {
        System.out.println("Du har 40 sekunder att svara på frågan.");

        // Tiden kvar är där för uträkningen av poängförlusten.
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (timeLeft > 0) {
                    System.out.println("Time reamining: " + timeLeft + " seconds");
                    timeLeft--;
                } else {
                    System.out.println("Tiden är slut, Vi går vidare.");
                    onTimeUp.run(); 
                    timer.cancel(); 
                }
            }
        };

        
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void stop() {
        timer.cancel();
        System.out.println("Nästa Fråga.");
    }
}
