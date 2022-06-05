package org.example;

public class Main {
    public static void main(String[] args) {
        Editor e = new Editor(825, 720);
        e.setController(new Pointer());
        e.init();
        e.setTitle("Editor");
        e.setVisible(true);
    }
}