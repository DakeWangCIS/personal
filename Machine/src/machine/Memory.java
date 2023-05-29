package machine;

public class Memory{

     MemoryElement[] memory;

    public Memory(int size){
        memory = new MemoryElement[size];
        for (int i = 0; i < memory.length; i++) {
            memory[i] = new MemoryElement();
        }
    }

    public void write(int address, int value){
        memory[address].write(value);
    }

    public int read(int address){
        return memory[address].read();
    }

    public String toString(){
        String s = new String();
        s += memory[99] + " ";
        s += memory[98] + " ";
        s += memory[97];
        return s;
    }

}
