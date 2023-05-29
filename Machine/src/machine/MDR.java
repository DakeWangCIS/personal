package machine;

/**
 * @author Dake Wang
 * @date 2023-04-16 09:38
 */
public class MDR extends MemoryElement{

    public MDR(int val){
        super(val);
    }

    public MDR(){
        super();
    }

    public int getMDR() {
        return this.value;
    }

    public void setMDR(int val) {
        this.value = val;
    }

    @Override
    public String toString() {
        return "MDR{" +
                "value=" + value +
                '}';
    }
}
