package machine;

/**
 * @author Dake Wang
 * @date 2023-04-16 09:35
 */
public class IR extends MemoryElement{

        public IR(int val){
            super(val);
        }

        public IR(){
            super();
        }

        public void setIR(int val){
            this.value = val;
        }

        public int getIR(){
            return this.value;
        }

        public int getOpcode(int val){
            return this.value / 100;
        }

        public int getAddress(int val){
            return this.value % 100;
        }

    @Override
    public String toString() {
        return "IR{" +
                "value=" + value +
                '}';
    }
}
