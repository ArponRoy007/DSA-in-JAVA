package OOPs;

public class GetSet {
    public static void main(String[] args) {
        Penn p1=new Penn();//created pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.color);//set
        System.out.println(p1.getColor());//get
        p1.setTip(5);
        System.out.println(p1.tip);//set
        System.out.println(p1.getTip());//get
    }
}


class Penn{
    String color;
    int tip;

    //getter
    String getColor(){
        return this.color;
    }
    int getTip(){
        return this.tip;
    }

    //setters
    void setColor(String newColor){
        color=newColor;
    }
    void setTip(int newTip){
        tip=newTip;
    }
}
