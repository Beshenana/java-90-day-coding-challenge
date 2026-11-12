
package edu.haramaya.cosc3053.Day11;

public class Box<T> {

    private T content;

    // Store a value inside the box
    public void set(T content) {
        this.content = content;
    }

    // Retrieve the value from the box
    public T get() {
        return content;
    }

    // Check whether the box is empty
    public boolean isEmpty() {
        return content == null;
    }

    public static void main(String[] args) {

        Box<String> strBox = new Box<>();

        strBox.set("Haramaya University");

        System.out.println("Box Value: " + strBox.get());
    }
}
