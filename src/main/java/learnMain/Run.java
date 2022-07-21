package learnMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Run{
    public static void main(String[] args) {
        Greetings greet = name ->"HEllO " + name;
        System.out.println(greet.greetings("Meenu"));

        Lang l = lang -> "Language: " + lang;
        System.out.println(l.language("English"));

        List<String> names = Arrays.asList("Meenu", "Love", "Jyoti");//List

        Consumer <String> consumer = t-> System.out.println(t); //1
        names.forEach(consumer);

        names.forEach(t-> System.out.println(t));//2

        names.forEach(System.out::println);//3

        names.sort((s1,s2) -> s1.length() - s2.length()); //sort
        System.out.println(names);

        Function<String,Integer> mapper = String::length;
        System.out.println((mapper.apply("MALIK")));

        Supplier<String> name = ()->"HELLLLLLLOOOOOOOOOOOOOOOO"; //supplier
        System.out.println(name.get());
    }



    public String doSomething(String name){
        return "Hello "+ name;
    }
}
