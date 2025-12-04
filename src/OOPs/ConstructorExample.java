package OOPs;

public class ConstructorExample {
    int id;
    String name;

    // 1. Non-parameterized constructor
    ConstructorExample() {
        id = 0;
        name = "Unknown";
        System.out.println("Non-parameterized constructor called");
    }

    // 2. Parameterized constructor
    ConstructorExample(int i, String n) {
        id = i;
        name = n;
        System.out.println("Parameterized constructor called");
    }

    // 3. Copy constructor
    ConstructorExample(ConstructorExample obj) {
        id = obj.id;
        name = obj.name;
        System.out.println("Copy constructor called");
    }

    // Method to display values
    void display() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    // Main method
    public static void main(String[] args) {
        // Using non-parameterized constructor
        ConstructorExample c1 = new ConstructorExample();
        c1.display();

        // Using parameterized constructor
        ConstructorExample c2 = new ConstructorExample(101, "Alice");
        c2.display();

        // Using copy constructor
        ConstructorExample c3 = new ConstructorExample(c2);
        c3.display();
    }
}

