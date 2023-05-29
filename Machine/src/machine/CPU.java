package machine;

public class CPU{

    private PC pc;
    private ACC acc;
    private IR ir;
    private MAR mar;
    private MDR mdr;

    private boolean inFlag;
    private boolean outFlag;
    private boolean storeFlag;
    private boolean killFlag;

    public CPU() {
        pc = new PC();
        acc = new ACC();
        ir = new IR();
        mar = new MAR();
        mdr = new MDR();
    }

    public int getMAR() {
        return mar.getMAR();
    }

    public int getMDR() {
        return mdr.getMDR();
    }

    public void setMDR(int read) {
        mdr.setMDR(read);
    }

    public void fetch(){
        mar.setMAR(pc.increment());
    }

    public int decodeToOpcode(){
        int currentIR = ir.getIR();
        return ir.getOpcode(currentIR);
    }

    public int decodeToAddress(){
        int currentIR = ir.getIR();
        return ir.getAddress(currentIR);
    }

    public void decode(){
        ir.setIR(mdr.getMDR());
        mar.setMAR(decodeToAddress());
    }

    public void raiseInFlag(){
        this.inFlag = true;
    }

    public void lowerInFlag(){
        this.inFlag = false;
    }

    public void raiseOutFlag(){
        this.outFlag = true;
    }

    public void lowerOutFlag(){
        this.outFlag = false;
    }

    public void raiseStoreFlag(){
        this.storeFlag = true;
    }

    public void lowerStoreFlag(){
        this.storeFlag = false;
    }

    public void raiseKillFlag(){
        this.killFlag = true;
    }

    public boolean getOutFlag() {
        return outFlag;
    }

    public boolean getInFlag() {
        return inFlag;
    }

    public boolean getStoreFlag() {
        return storeFlag;
    }

    public boolean getKillFlag() {
            return killFlag;
    }

    public void execute() {
        int opcode = decodeToOpcode();
        switch (opcode){
            case 0: //halt
                raiseKillFlag();
                break;
            case 1: //load value
                acc.setACC(mdr.getMDR());
                break;
            case 2: //store value
                mdr.setMDR(acc.getACC());
                mar.setMAR(decodeToAddress());
                raiseStoreFlag();
                break;
            case 3: //add value
                acc.setACC(acc.getACC() + mdr.getMDR());
                break;
            case 4: //subtract value
                acc.setACC(acc.getACC() - mdr.getMDR());
                break;
            case 5: //multiply value
                acc.setACC(acc.getACC() * mdr.getMDR());
                break;
            case 6: //divide value
                acc.setACC(acc.getACC() / mdr.getMDR());
                break;
            case 7:
                raiseInFlag();
                break;
            case 8:
                raiseOutFlag();
                break;
            case 9: //jump to address
                pc.setPC(mar.getMAR());
                break;
            case 10: //jump to address if zero
                if (acc.getACC() == 0)
                    pc.setPC(mar.getMAR());
                break;
            case 11: //jump to address if positive
                if (acc.getACC() > 0)
                    pc.setPC(mar.getMAR());
                break;
        }

    }

    @Override
    public String toString() {
        return "CPU{" +
                "pc=" + pc +
                ", acc=" + acc +
                ", ir=" + ir +
                ", mar=" + mar +
                ", mdr=" + mdr +
                '}';
    }
}
