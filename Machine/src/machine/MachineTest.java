package machine;

public class MachineTest {
    public static void main(String[] args) {
        Machine myPC = new Machine(100);
        myPC.load("finalLab.txt");
        myPC.run();
    }
}
