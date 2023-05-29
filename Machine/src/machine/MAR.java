package machine;

/**
 * @author Dake Wang
 * @date 2023-04-16 09:37
 */
public class MAR extends MemoryElement{

        public MAR(int val){
            super(val);
        }

        public MAR(){
            super();
        }

        public void setMAR(int val) {
            this.value = val;
        }

        public int getMAR() {
            return this.value;
        }

    @Override
    public String toString() {
        return "MAR{" +
                "value=" + value +
                '}';
    }
}
