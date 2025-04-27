
public class Processors {
    /*
    Project outline:
    Superclass: Processor
    Subclasses: Central Processor, Graphics Processor
    Unique fields: Architecture (Enum), Supports raytracing (Boolean)
     */

    //Define the polymorphism classes
    public class Processor extends beaUtils {
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
            halt(500); //Default processor wait times
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
            x86("x86"),
            ARM("ARM"),
            POWERPC("POWERPC"),
            TRICORE("TRICORE"),
            MIPS("MIPS"),
            COLDFIRE("COLDFIRE");

            private final String architectureName;

            Architecure(String architectureName) { this.architectureName = architectureName; }
        }

        private Architecure architecture = null;

        public CentralProcessor(int cores, int wattageMax, int clockSpeed, Architecure architecture) {
            super(cores,wattageMax,clockSpeed);
            this.architecture = architecture;
        }

        public Architecure getArchitecture() {
            return architecture;
        }

        @Override
        public float additiveFLOP(float a, float b) {
            halt(1000);
            return a + b;
        }

        @Override
        public String toString() {
            return "Cores: " + super.getCores() +
                    "Wattage Max: " + super.getWattageMax() +
                    "Clock Speed: " + super.getClockSpeed() +
                    "Architecture: " + architecture;
        }

        @Override
        public boolean equals(Object hopefullyAnotherCentralProcessorInstancedObject) {
            if (hopefullyAnotherCentralProcessorInstancedObject instanceof CentralProcessor otherCentralProcessor) {
                return super.equals(otherCentralProcessor) && architecture.equals(otherCentralProcessor.getArchitecture());
            }
            return false;
        }

    }

    public class GraphicsProcessor extends Processor {
        boolean supportsRaytracing;

        public GraphicsProcessor(int cores, int wattageMax, int clockSpeed, boolean supportsRaytracing) {
            super(cores,wattageMax,clockSpeed);
            this.supportsRaytracing = supportsRaytracing;
        }

        public boolean supportsRaytracing() {
            return supportsRaytracing;
        }

        @Override
        public float additiveFLOP(float a, float b) {
            halt(100);
            return a + b;
        }

        @Override
        public String toString() {
            return "Cores: " + super.getCores() +
                    "Wattage Max: " + super.getWattageMax() +
                    "Clock Speed: " + super.getClockSpeed() +
                    "Supports Raytracing?: " + supportsRaytracing;
        }

        @Override
        public boolean equals(Object hopefullyAnotherGraphicsProcessorInstancedObject) {
            if (hopefullyAnotherGraphicsProcessorInstancedObject instanceof GraphicsProcessor otherGraphicsProcessor) {
                return super.equals(otherGraphicsProcessor) && supportsRaytracing == otherGraphicsProcessor.supportsRaytracing();
            }
            return false;
        }
    }
}
