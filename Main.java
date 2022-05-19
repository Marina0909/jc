package Lesson1;

public class Main {
    public static void main(String[] args) {

        double maxTime = 3000; // максимальное время прохождения дистанции

        Animal cat1 = new Cat("Барсик", "белый", 4, 1, 2);

        //Cat cat2 = new Cat("Морис", "black", 3, 2, 1);

        Wolf wolf = new Wolf("Тревор", "Серый", 6, 10, 3);

        Turtle turtle = new Turtle("Тортилла", "Болотный", 77, 0.3 ,0.1);

        Beaver beaver = new Beaver("Борис", "серый", 5, 10);

        Animal[] athletes = new Animal[] {cat1, wolf, turtle, beaver};
        Team team = new Team("NumberOne", athletes);
        System.out.println(team);

        Pool pool1 = new Pool("Малый бассейн", 25);
        Pool pool2 = new Pool("Большой бассейн", 50);
        Stadium stadium = new Stadium("Центральный стадион",400);
        Obstacle[] obstacles= new Obstacle[]{pool1, stadium, pool2};
        Course course = new Course(obstacles);
        System.out.println(course);

        course.doIt(team);

        team.showResults(2000, obstacles.length); //максимальное время прохождения дистанции, количество препятствий для зачета
        team.showResults(5000, 2);
    }
}

