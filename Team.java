package Lesson1;

import java.util.Arrays;

public class Team {
    private String teamName;
    private Animal[] athletes;


    public Team(String teamName, Animal[] athletes) {
        this.teamName = teamName;
        this.athletes = athletes;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Animal[] getAthletes() {
        return athletes;
    }

    public void setAthletes(Animal[] athletes) {
        this.athletes = athletes;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", athletes=" + Arrays.toString(athletes) +
                '}';
    }
    public void showResults(double maxTime, int passed) {
        System.out.println("Команда: "+ teamName + " Время результата < " + maxTime + "  Пройдено препятствий: "+ passed);
        for (Animal athlete : athletes) {
            if(athlete.getResult() < maxTime && athlete.getPassed() >= passed){
                System.out.println("Атлет: " + athlete.getClass().getSimpleName() + " " +athlete.getName() +
                        "  Цвет: " + athlete.getColor() + "  Возраст: " + athlete.getAge() + "  Результат: " +
                        athlete.getResult() + "  Препятствий: " + athlete.getPassed());
            }
        }
    }
}
