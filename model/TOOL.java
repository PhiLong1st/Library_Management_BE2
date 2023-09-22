package model;

public class TOOL {
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void delay(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
