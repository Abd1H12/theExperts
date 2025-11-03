import java.util.Timer; //Importen för timern classen
import java.util.TimerTask;





public class QuizTimer {
    private int timeLimit; // 
    private boolean timeUp; // 
    private Timer timer; // 




    public QuizTimer(int timeLimit) {
        this.timeLimit = timeLimit;
        this.timeUp = false;
    }

    public void start(Runnable onTimeUp) {
        timeUp = false;
        timer = new Timer();
            TimerTask task = new TimerTask() {
                int timeRemaining = timeLimit;





            @Override
            public void run() {
                if (timeRemaining > 0) {
                    if (timeRemaining % 10 == 0 || timeRemaining <= 5) { 
                        System.out.println("Time left: " + timeRemaining + " seconds");
                    }
                    timeRemaining--;
                } else {
                    timeUp = true;
                    onTimeUp.run(); 
                    timer.cancel(); 
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); 
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public boolean isTimeUp() { //Hade hjälp av Stack overflow för att få till timern
        return timeUp;
    }
}
    

