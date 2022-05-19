package Lesson1;

import java.util.Arrays;

public class Course  {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }

    public void setObstacles(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    @Override
    public String toString() {
        return "Course{" +
                "obstacles=" + Arrays.toString(obstacles) +
                '}';
    }

    public void doIt(Team team) {
        Animal[] athletes = team.getAthletes();
        for (Animal athlete : athletes) {
            athlete.setResult(0);
        }
        for (Animal athlete : athletes) {
            Obstacle[] obstacles = this.getObstacles();
            for (Obstacle obstacle : obstacles) {
                if (obstacle instanceof Pool) {
                    Pool p = (Pool) obstacle;
                    if (athlete instanceof Cat) {
                        Cat a = (Cat) athlete;
                        a.setResult(a.getResult() + p.getTimeToOvercomePool(a));
                    }else if(athlete instanceof Beaver) {
                        Beaver a = (Beaver) athlete;
                        a.setResult(a.getResult() + p.getTimeToOvercomePool(a));
                    }else if(athlete instanceof Turtle) {
                        Turtle a = (Turtle) athlete;
                        a.setResult(a.getResult() + p.getTimeToOvercomePool(a));
                    }else if(athlete instanceof Wolf) {
                        Wolf a = (Wolf) athlete;
                        a.setResult(a.getResult() + p.getTimeToOvercomePool(a));
                    }
                }
                else if (obstacle instanceof Stadium) {
                    Stadium s = (Stadium) obstacle;
                    if(athlete instanceof Cat){
                        Cat a = (Cat) athlete;
                        a.setResult(a.getResult() + s.getTimeToOvercomeStadium(a));
                    //}else if(athlete instanceof Beaver) {
                        //CanRun a = (Beaver) athlete;
                        //s.getTimeToOvercomeStadium(a);
                    }else if(athlete instanceof Turtle) {
                        Turtle a = (Turtle) athlete;
                        a.setResult(a.getResult() + s.getTimeToOvercomeStadium(a));
                    }else if(athlete instanceof Wolf) {
                        Wolf a = (Wolf) athlete;
                        a.setResult(a.getResult() + s.getTimeToOvercomeStadium(a));
                    }
                }
            }
        }
    }
}
