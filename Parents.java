class Parent {
    void display() {
        System.out.println("Parent's display method");
    }

    void print(int num) {
        System.out.println("Parent's print method with int parameter: " + num);
    }
}

class Child extends Parent {
    @Override
    void display() {
        System.out.println("Child's display method");
    }

    // Overloading the print method
    void print(String text) {
        System.out.println("Child's print method with String parameter: " + text);
    }
}

public class Parents {
    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.display(); // Calls Parent's display method
        parent.print(10); // Calls Parent's print method with int parameter

        Child child = new Child();
        child.display(); // Calls Child's display method
        child.print("Hello"); // Calls Child's print method with String parameter

        // Upcasting: Parent reference pointing to a Child object
        Parent polymorphicReference = new Child();
        polymorphicReference.display(); // Calls Child's display method (Polymorphism)
        polymorphicReference.print(20); // Calls Parent's print method with int parameter
        //polymorphicReference.print("Hi"); // This line will cause a compilation error because print(String text) is not available in Parent class
    }
}