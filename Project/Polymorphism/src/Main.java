
public class Main {

    /*
    Project outline:
    Superclass: Processor
    Subclasses: Central Processor, Graphics Processor
    Unique fields: Architecture (Enum), Supports raytracing (Boolean)
     */

    //Define the polymorphism classes
    public class Processor {
        private final int cores;
        private final int wattageMax;
        private final int clockSpeed;

        public Processor(int cores, int wattageMax, int clockSpeed) {
            this.cores = cores;
            this.wattageMax = wattageMax;
            this.clockSpeed = clockSpeed;
        }

        //Getter methods
        public int getCores() { return cores; }
        public int getWattageMax() {return wattageMax; }
        public int getClockSpeed() { return clockSpeed; }

        //Method to be overriden
        public float additiveFLOP(float a, float b) {
            return a + b;
        }

        //ToString
        @Override
        public String toString() {
            return ("Cores: " + cores +
                    "\nWattage Max: " + wattageMax +
                    "\nClock Speed: " + clockSpeed );
        }

        @Override
        public boolean equals(Object hopefullyAnotherProcessorInstancedObject) {
            if (hopefullyAnotherProcessorInstancedObject instanceof Processor comparativeProcessor) { //Avoid casting errors

                boolean coresAmountSame = (comparativeProcessor.getCores() == cores);
                boolean wattageMaxSame = (comparativeProcessor.getWattageMax() == wattageMax);
                boolean clockSpeedSame = (comparativeProcessor.getClockSpeed() == clockSpeed);

                return (coresAmountSame && wattageMaxSame && clockSpeedSame);
            }
            else { return false; }
        }

    }

    public class CentralProcessor extends Processor {
        public enum Architecure {
            x86,
            ARM,
            POWERPC,
            TRICORE,
            MIPS,
            COLDFIRE,
        }

        private Architecure architecture = null;

        public CentralProcessor(int cores, int wattageMax, int clockSpeed, Architecure architecture) {
            super(cores,wattageMax,clockSpeed);
            this.architecture = architecture;
        }

        public Architecure getArchitecture() {
            return architecture;
        }



    }
    public static void main(String[] args) {

    }
}