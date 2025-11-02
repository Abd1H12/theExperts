import java.util.LinkedHashMap;
import java.util.Map;

public class Questions {

    public static Map<String, String> getFoodQuestions() {
        Map<String, String> foodQuiz = new LinkedHashMap<>();
        foodQuiz.put("1. Which country is famous for sushi?\nA. China\nB. Thailand\nC. Japan\nD. South Korea", "C");
        foodQuiz.put("2. What is the main ingredient in guacamole?\nA. Tomato\nB. Avocado\nC. Cucumber\nD. Onion", "B");
        foodQuiz.put("3. Which of these is a type of pasta?\nA. Penne\nB. Naan\nC. Couscous\nD. Baguette", "A");
        foodQuiz.put("4. What is the national dish of Italy?\nA. Sushi\nB. Tacos\nC. Pizza\nD. Croissant", "C");
        foodQuiz.put("5. Which fruit is known as the “king of fruits”?\nA. Apple\nB. Banana\nC. Mango\nD. Grape", "C");
        return foodQuiz;
    }

    public static Map<String, String> getSportsQuestions() {
        Map<String, String> sportsQuiz = new LinkedHashMap<>();
        sportsQuiz.put("1. How many players are there in a football (soccer) team on the field?\nA. 9\nB. 10\nC. 11\nD. 12", "C");
        sportsQuiz.put("2. In which sport is the term “love” used?\nA. Cricket\nB. Badminton\nC. Tennis\nD. Basketball", "C");
        sportsQuiz.put("3. The Olympic Games are held every how many years?\nA. 2\nB. 4\nC. 5\nD. 6", "B");
        sportsQuiz.put("4. Which country won the FIFA World Cup in 2022?\nA. Germany\nB. Brazil\nC. Argentina\nD. France", "C");
        sportsQuiz.put("5. Who is known as the “Fastest Man Alive”?\nA. Usain Bolt\nB. Michael Phelps\nC. Lionel Messi\nD. Roger Federer", "A");
        return sportsQuiz;
    }

    public static Map<String, String> getGeographyQuestions() {
        Map<String, String> geographyQuiz = new LinkedHashMap<>();
        geographyQuiz.put("1. What is the capital of France?\nA. Paris\nB. Rome\nC. Madrid\nD. Berlin", "A");
        geographyQuiz.put("2. The capital of Australia is:\nA. Sydney\nB. Melbourne\nC. Canberra\nD. Perth", "C");
        geographyQuiz.put("3. What is the capital of Canada?\nA. Toronto\nB. Ottawa\nC. Vancouver\nD. Montreal", "B");
        geographyQuiz.put("4. Which city is the capital of Japan?\nA. Tokyo\nB. Osaka\nC. Kyoto\nD. Nagoya", "A");
        geographyQuiz.put("5. What is the capital of South Africa?\nA. Pretoria\nB. Johannesburg\nC. Cape Town\nD. Durban", "A");
        return geographyQuiz;
    }
}
