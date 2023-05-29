package machine;

/**
 * @author Dake Wang
 * @date 2023-04-16 09:26
 */
public class MemoryElement {

    protected int value;

    public MemoryElement(){this.value = 0;}

    public MemoryElement(int val){this.value = val;}

    public void write(int val){this.value = val;}

    public int read(){return this.value;}

    @Override
    public String toString() {
        return "MemoryElement{" +
                "value=" + value +
                '}';
    }
}
