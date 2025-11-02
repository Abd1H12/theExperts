import java.util.*;

public class Game {
    private Player player;
    private List<Category> categories;
    private Scanner input;
    private int streak;
    private boolean isPlaying;

    public Game(Player player, List<Category> categories){
        this.player = player;
        this.categories = categories;
        this.input = new Scanner(System.in);
        this.streak = 0;
        this.isPlaying = true;
    }

    public void startGame(){
        System.out.println("Welcome " + player.getName() + " to the Quiz Game!");
        System.out.println("You have " + player.getLives() + " lives. Each correct answer = +10 points.");
        System.out.println("3 correct answers in a row gives a Streak. +50 bonus points!\n");

        while(isPlaying && player.isAlive()){
            showCategories();
            Category chosen = chooseCategory();
            askQuestions(chosen);
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
            System.out.println(entry.getKey());
            System.out.print("Your answer: ");
            String answer = input.next().toUpperCase();

            if (answer.equals(entry.getValue())) {
                System.out.println("Correct!\n");
                player.addScore(10);
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
        System.out.println("\n🎮 Game Over!");
        System.out.println("Final Score: " + player.getScore());
        System.out.println("Thanks for playing, " + player.getName() + "!");
    }
}
