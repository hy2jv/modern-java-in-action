package chapter01;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import static java.awt.Color.*;
import static java.awt.Color.GREEN;

public class FilteringApples {

    public static void main(String... args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(GREEN, 100));
        inventory.add(new Apple(RED, 200));

        /* 메서드 호출 */
        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println("FilteringApples::isGreenApple");
        System.out.println(greenApples+"\n");

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println("FilteringApples::isHeavyApple");
        System.out.println(heavyApples+"\n");

        /* 람다 함수 사용 */
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));
        System.out.println("filterApples(inventory, (Apple a) -> \"green\".equals(a.getColor()))");
        System.out.println(greenApples2+"\n");

        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println("filterApples(inventory, (Apple a) -> a.getWeight() > 150)");
        System.out.println(heavyApples2+"\n");

        List<Apple> redApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 || RED.equals(a.getColor()));
        System.out.println("filterApples(inventory, (Apple a) -> a.getWeight() < 80 || \"red\".equals(a.getColor()))");
        System.out.println(redApples);
    }

    // 1.3.2 예제
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        /* 자바 8 이전 구현, 색상이 녹색인 사과 필터링 */
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        /* 자바 8 이후 */
        return GREEN.equals(apple.getColor());
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
}


