package OOPs;

public class Encapsulation {
    public static void main(String[] args) {
        Student s1=new Student("Roy"); //constructor call
        s1.setAge(21);
        System.out.println(s1.getAge());
        System.out.println(s1.name);//constructor called
    }
}
class Student {
    public String name;
    private int age;

    //constructor
    Student(String name){

        this.name=name;
    }

    public void setAge(int a) {

        age = a;
    }

    public int getAge() {

        return age;
    }
}

//class Student{
//    String name;
//    int age;
//    float percentage;
//
//    void setPercentage(int phy, int che, int math){
//        percentage=(phy+che+math)/3;
//    }
//}

