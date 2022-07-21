package streamDemo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Dish {
    private String name;
    private DishType dish;
    private CuisineType cuisine;
    private List<String> ingredient;
    private Double price;
}
