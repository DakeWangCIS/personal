package machine;

/**
 * @author Dake Wang
 * @date 2023-04-16 09:36
 */
public class ACC extends MemoryElement{

    public ACC(int val){
            super(val);
        }

    public ACC(){
            super();
        }

    public void setACC(int val) {
        this.value = val;
    }

    public int getACC() {
        return value;
    }

    @Override
    public String toString() {
        return "ACC{" +
                "value=" + value +
                '}';
    }
}
