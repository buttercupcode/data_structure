package javaCore;


import java.util.Comparator;

public class Apple {
    private int weight;
    private String color;

    public Apple() {

    }

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        Comparator<Apple> salaryComparator = Comparator.comparing(Apple::getWeight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}


