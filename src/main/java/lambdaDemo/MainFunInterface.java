package lambdaDemo;

public class MainFunInterface {
    public static void main(String[] args) {
        FunInterface1 add = (a, b) -> a + b;
        MainFunInterface main = new MainFunInterface();
        main.operate(7,9, add);
        FunInterface2 msg = name -> System.out.println("Hello" + name);
        msg.message("World");

    }

    private void operate(int a, int b, FunInterface1 add) {
        System.out.println(add.addition(a, b));
    }

    interface FunInterface1 {
        int addition(int a, int b);
    }

    interface FunInterface2 {
        void message(String name);
    }
}

