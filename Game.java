import java.util.*;

public class Game {
    private Player player;
    private List<Category> categories;
    private Scanner input;
    private int streak;
    private boolean isPlaying;
    private long startTime;
    private int totalQuestions;
    private int correctAnswers;
private long endTime;

    public Game(Player player, List<Category> categories){
        this.player = player;
        this.categories = categories;
        this.input = new Scanner(System.in);
        this.streak = 0;
        this.isPlaying = true;
    }

    public void startGame(){
        startTime = System.currentTimeMillis();
        System.out.println("Welcome " + player.getName() + " to the Quiz Game!");
        System.out.println("You have " + player.getLives() + " lives. Each correct answer = +10 points.");
        System.out.println("3 correct answers in a row gives a Streak. +50 bonus points!\n");
        System.out.print("Do you want to play only one category? (yes/no): "); //lade till en funktion för att välja om man vill spela en eller alla kategorier då det va ett av kraven från projektet som Tom lade upp!
    String playOneCategory = input.next().toLowerCase();
        while(isPlaying && player.isAlive()){
            showCategories();
            Category chosen = chooseCategory();
            askQuestions(chosen);
        
            if (player.isAlive()) { // nytt implement för att se om spelaren är vid liv!!,satte in för att den sade att man hade klaratkategorien även om man falerade!
                if (chosen == Category.ALL) {
                    System.out.println("You have completed all categories!");
                    break;
                }
        
                if (playOneCategory.equals("yes") && chosen != Category.ALL) {
                    System.out.println("You have completed the " + chosen.getName() + " category!");
                    break;
                }
            }
        }

        endGame();
    }

    private void showCategories() {
        System.out.println("\nAvailable categories:");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println((i + 1) + ". " + categories.get(i).getName());
        }
    }

    private Category chooseCategory(){
        System.out.print("Choose a category (1-" + categories.size() + "): ");
        int choice = input.nextInt();
        return categories.get(choice - 1);
    }

    private Map<String, String> getQuestionsForCategory(Category category) {
        switch (category) {
            case FOOD: return Questions.getFoodQuestions();
            case SPORTS: return Questions.getSportsQuestions();
            case GEOGRAPHY: return Questions.getGeographyQuestions();
            case ALL:
                Map<String, String> all = new LinkedHashMap<>();
                all.putAll(Questions.getFoodQuestions());
                all.putAll(Questions.getSportsQuestions());
                all.putAll(Questions.getGeographyQuestions());
                return all;
            default: return new LinkedHashMap<>();
        }
    }

    private void askQuestions(Category category) {
        Map<String, String> questions = getQuestionsForCategory(category);

        for (Map.Entry<String, String> entry : questions.entrySet()) {
            totalQuestions++; //slår ihopa totalt antalt frågor
            System.out.println(entry.getKey());

            QuizTimer quizTimer = new QuizTimer(40); //Timer för 40 sekunder så att den kan delas på 10 för att ej räkna varje sekund!! rör ej
            final boolean[] answered = {false};
    
            quizTimer.start(() -> {
                if (!answered[0]) {
                    System.out.println("⏰ Time's up! The correct answer was " + entry.getValue() + "\n");
                    player.looseLife();
                    streak = 0;
                    System.out.println("Lives left: " + player.getLives());
                    if (!player.isAlive()) {
                        isPlaying = false;
                    }
                }
            });

            System.out.print("Your answer: ");
            String answer = input.next().toUpperCase();
            answered[0] = true; 
            quizTimer.stop(); 

            if (answer.equals(entry.getValue())) {
                System.out.println("Correct!\n");
                player.addScore(10);
                correctAnswers++;
                streak++;
                if (streak % 3 == 0) {
                    player.addScore(50);
                    System.out.println("🔥 Streak! +50 bonus points!\n");
                }
            } else {
                System.out.println("Wrong! The correct answer was " + entry.getValue() + "\n");
                player.looseLife();
                streak = 0;
                System.out.println("Lives left: " + player.getLives());

                if (!player.isAlive()) {
                    isPlaying = false;
                    break;
                }
            }
        }
    }

    private void endGame() {
        endTime = System.currentTimeMillis(); 
        long elapsedTime = (endTime - startTime) / 1000; //slut tid minus startid för att kunna visa sluttiden
        System.out.println("\n🎮 Game Over!");
        System.out.println("Final Score: " + player.getScore());
        System.out.println("Correct Answers:" + correctAnswers + " out of " + totalQuestions);
        System.out.println("Time taken: " + elapsedTime + " seconds");
        System.out.println("Thanks for playing, " + player.getName() + "!");
    }
}
