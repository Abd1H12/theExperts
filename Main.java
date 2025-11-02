import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Hello! Please type your name: ");
        String name = input.nextLine();

        Player player = new Player(name);

        List<Category> categories = Arrays.asList(
                Category.FOOD,
                Category.SPORTS,
                Category.GEOGRAPHY,
                Category.ALL
        );

        Game game = new Game(player, categories);
        game.startGame();

        input.close();
    }
}
