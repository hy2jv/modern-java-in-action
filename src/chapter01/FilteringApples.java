package chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public static void main(String... args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red")
        );

        /* 메서드 호출 */
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println("FilteringApples::isGreenApple");
        System.out.println(greenApples+"\n");

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println("FilteringApples::isHeavyApple");
        System.out.println(heavyApples+"\n");

        /* 람다 함수 사용 */
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println("filterApples(inventory, (Apple a) -> \"green\".equals(a.getColor()))");
        System.out.println(greenApples2+"\n");

        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println("filterApples(inventory, (Apple a) -> a.getWeight() > 150)");
        System.out.println(heavyApples2+"\n");

        List<Apple> redApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || "red".equals(a.getColor()));
        System.out.println("filterApples(inventory, (Apple a) -> a.getWeight() < 80 || \"red\".equals(a.getColor()))");
        System.out.println(redApples);
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        /* 자바 8 이전 구현, 색상이 녹색인 사과 필터링 */
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        /* 자바 8 이후 */
        return "green".equals(apple.getColor());
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        /* 자바 8 이전 구현, 무게가 150그램 이상인 사과 필터링 */
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isHeavyApple(Apple apple) {
        /* 자바 8 이후 */
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        /* "predicate"란?
         * 수학에서는 인수로 값을 받아 true 혹은 false를 반환하는 함수를 프레디케이트라고 한다. */
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static class Apple {

        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
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

        @SuppressWarnings("boxing")
        @Override
        public String toString() {
            return String.format("Apple{color='%s', weight=%d}", color, weight);
        }

    }
}


