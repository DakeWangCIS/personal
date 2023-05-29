package machine;

import java.util.Scanner;

public class InputDevice{

    public InputDevice() {}

    public int read() {
        // read from keyboard
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        return scanner.nextInt();
    }
}
