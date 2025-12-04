package OOPs;

public class Polymorphism {
    public static void main(String[] args) {
//        Calculator c1 = new Calculator();
//        System.out.println(c1.sum(23, 34));       // int, int
//        System.out.println(c1.sum(1.5, 2.5));     // double, double
//        System.out.println(c1.sum(1, 2, 3));      // int, int, int

        Deer d=new Deer();
        d.eats();
    }
}

//Method/Function OverLoading
//class Calculator {
//    int sum(int a, int b) {
//        return a + b;
//    }
//
//    double sum(double a, double b) {
//        return a + b;
//    }
//
//    int sum(int a, int b, int c) {
//        return a + b + c;
//    }
//}

//Method Overriding
class Animall{
    void eats(){
        System.out.println("Eat anything");
    }
}
class Deer extends Animall{
    void eats(){
        System.out.println("eats grass");
    }
}