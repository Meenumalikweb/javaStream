package streamDemo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunDish {
    public static void main(String[] args) {
        List<Dish> obj = new ArrayList<>();
        addDishes(obj);
        //System.out.println(obj);

        List<Dish> vegUber = (List<Dish>) obj.stream()
                .filter(d->d.getDish() == DishType.VEG)
                .filter(d->d.getCuisine() == CuisineType.INDIAN).distinct()
                .collect(Collectors.toList());
        System.out.println(vegUber);

        List<List<String>> collect = obj.stream().map(Dish::getIngredient).collect(Collectors.toList()); //map
        System.out.println(collect);
        List<String> shoppingList = obj.stream().flatMap(dish -> dish.getIngredient().stream()).distinct().collect(Collectors.toList());//flatMap
        System.out.println(shoppingList);

        List<String> list = obj.stream().flatMap(dish -> dish.getIngredient().stream()).distinct().collect(Collectors.toCollection(LinkedList::new));//Collectors
        System.out.println(list);

        Map<DishType, List<Dish>> map = obj.stream().collect(Collectors.groupingBy(Dish::getDish, Collectors.toList()));//groupingBy
        System.out.println(map);

        Map<String, Dish> collect1 = obj.stream().distinct().collect(Collectors.toMap(d -> d.getName(), d ->d));
        System.out.println(collect1);

        Integer reduce = Stream.of(1,3,2,56,78).reduce(1, (a,b) -> a*b);//reduce
        System.out.println(reduce);

        String s = obj.stream().flatMap(dish -> dish.getIngredient().stream()).distinct().collect(Collectors.joining("|"));//delimiter
        System.out.println(s);

        DoubleSummaryStatistics statistics = obj.stream().collect(Collectors.summarizingDouble(dish -> dish.getPrice()));
        System.out.println(statistics);

        IntSummaryStatistics summaryStatistics = Stream.of(1,3,2,56,78).collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics);
    }
    private static void addDishes(List<Dish>dishes){
        dishes.add(
                Dish.builder()
                        .name("Butter Chicken")
                        .cuisine(CuisineType.INDIAN)
                        .ingredient(Arrays.asList("Butter","Chicken","Spices"))
                        .dish(DishType.NONVEG)
                        .price(14.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("veg Biryani")
                        .cuisine(CuisineType.INDIAN)
                        .ingredient(Arrays.asList("Rice","veggies","Spices"))
                        .dish(DishType.VEG)
                        .price(12.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("veg Biryani")
                        .cuisine(CuisineType.INDIAN)
                        .ingredient(Arrays.asList("Rice","veggies","Spices"))
                        .dish(DishType.VEG)
                        .price(12.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("Noodles")
                        .cuisine(CuisineType.CHINESE)
                        .ingredient(Arrays.asList("Noodles","veggies","Spices"))
                        .dish(DishType.VEG)
                        .price(13.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("pasta")
                        .cuisine(CuisineType.ITALIAN)
                        .ingredient(Arrays.asList("pasta","Chicken","Spices"))
                        .dish(DishType.NONVEG)
                        .price(13.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("Dosa")
                        .cuisine(CuisineType.INDIAN)
                        .ingredient(Arrays.asList("Rice","Oil","Spices"))
                        .dish(DishType.VEGAN)
                        .price(10.99)
                        .build()
        );
    }
}
