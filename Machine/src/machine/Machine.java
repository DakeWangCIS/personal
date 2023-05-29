package machine;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Machine {

    int numOfLines;
    Memory mainMem;
    CPU cpu;
    OutputDevice outDev;
    InputDevice inDev;

    public Machine(int numOfLines) {
        this.numOfLines = numOfLines;
        mainMem = new Memory(numOfLines);
        cpu = new CPU();
        outDev = new OutputDevice();
        inDev = new InputDevice();
    }

    public void load(String fileName) {
        //load the program into the memory
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            //initialize the memory, when the string is null, the program will stop
            for (int i = 0; i < numOfLines; i++) {
                String line = br.readLine();
                if (line == null)
                    break;
                mainMem.write(i, Integer.parseInt(line));
            }
//            for (int i = 0; i < mainMem.memory.length; i++) {
//                System.out.println(mainMem.memory[i].read());
//            }

        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void busRefresh() {
        if (cpu.getOutFlag()) {
            outDev.write(mainMem.read(cpu.getMAR()));
            cpu.lowerOutFlag();
        } else if (cpu.getInFlag()) {
            mainMem.write(cpu.getMAR(), inDev.read());
            cpu.lowerInFlag();
        } else if (cpu.getStoreFlag()) {
            mainMem.write(cpu.getMAR(), cpu.getMDR());
            cpu.lowerStoreFlag();
        } else if (cpu.getKillFlag()) {
            System.exit(0);
        } else {
            cpu.setMDR(mainMem.read(cpu.getMAR()));
        }
    }

    public void run() {
        // run the program
        while (true) {
//            System.out.println(mainMem);
//            System.out.println(cpu);
            cpu.fetch();
//            System.out.println(cpu);
            busRefresh();
//            System.out.println(cpu);
            cpu.decode();
//            System.out.println(cpu);
            busRefresh();
//            System.out.println(cpu);
            cpu.execute();
//            System.out.println(cpu);
//            System.out.println("LOOK HERE!!!");
            busRefresh();
//            System.out.println(mainMem);
        }
    }
}
