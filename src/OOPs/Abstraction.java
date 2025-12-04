package OOPs;

public class Abstraction {
    public static void main(String[] args) {
        Horse h=new Horse();
        h.eatt();
        h.walk();
        Chiken c=new Chiken();
        c.eatt();
        c.walk();
    }
}

abstract class Animaal{
    void eatt(){
        System.out.println("animal eats");
    }
    abstract void walk();
}
class Horse extends Animaal{
    void walk(){
        System.out.println("walk on four legs");
    }
}
class Chiken extends Animaal{
    void walk(){
        System.out.println("walks on two legs");
    }
}