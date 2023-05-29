package machine;

/**
 * @author Dake Wang
 * @date 2023-04-16 09:27
 */
public class PC extends MemoryElement{

        public PC(int val){
            super(val);
        }

        public PC(){
            super();
        }

        public int increment(){
            return this.value++;
        }

        public int getPC(){
            return this.value;
        }

        public void setPC(int val){
            this.value = val;
        }

    @Override
    public String toString() {
        return "PC{" +
                "value=" + value +
                '}';
    }
}
