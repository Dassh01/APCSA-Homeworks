package org.example;

public class PolyProcessors {
    /*
    Project outline:
    Superclass: Processor
    Subclasses: Central Processor, Graphics Processor
    Unique fields: Architecture (Enum), Supports raytracing (Boolean)
     */

    //Define the polymorphism classes
    public static class Processor extends beaUtils { //Superclass
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

        /**
         * Performs a floating point addition operation between params a & b
         * with a delay of 500ms
         * @param a To be added to b
         * @param b To be added to a
         * @return a + b
         */
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

    public static class CentralProcessor extends Processor { //Subclass 1
        public enum Architecure { //Description of cpu structure
            x86("x86"),
            ARM("ARM"),
            POWERPC("POWERPC"),
            TRICORE("TRICORE"),
            MIPS("MIPS"),
            COLDFIRE("COLDFIRE");

            private final String architectureName;

            Architecure(String architectureName) { this.architectureName = architectureName; }

            public String toString() {
                return architectureName;
            }
        }

        private Architecure architecture = null;

        public CentralProcessor(int cores, int wattageMax, int clockSpeed, Architecure architecture) {
            super(cores,wattageMax,clockSpeed);
            this.architecture = architecture;
        }

        public Architecure getArchitecture() {
            return architecture;
        }

        /**
         * Performs a floating point addition operation between params a & b
         * with a delay of 1000ms
         * @param a To be added to b
         * @param b To be added to a
         * @return a + b
         */
        @Override
        public float additiveFLOP(float a, float b) {
            halt(1000);
            return a + b;
        }

        @Override
        public String toString() {
            return "Cores: " + super.getCores() +
                    "\nWattage Max: " + super.getWattageMax() +
                    "\nClock Speed: " + super.getClockSpeed() +
                    "\nArchitecture: " + architecture;
        }

        @Override
        public boolean equals(Object hopefullyAnotherCentralProcessorInstancedObject) {
            if (hopefullyAnotherCentralProcessorInstancedObject instanceof CentralProcessor otherCentralProcessor) {
                boolean superEquals = super.equals(otherCentralProcessor);
                boolean architectureEquals = ((otherCentralProcessor.getArchitecture().toString().equals(architecture.toString())));
                return superEquals && architectureEquals;
            }
            return false;
        }

    }

    public static class GraphicsProcessor extends Processor { //Subclass 2
        boolean supportsRaytracing;

        public GraphicsProcessor(int cores, int wattageMax, int clockSpeed, boolean supportsRaytracing) {
            super(cores,wattageMax,clockSpeed);
            this.supportsRaytracing = supportsRaytracing;
        }

        public boolean supportsRaytracing() {
            return supportsRaytracing;
        }

        /**
         * Performs a floating point addition operation between params a & b
         * with a delay of 100ms
         * @param a To be added to b
         * @param b To be added to a
         * @return a + b
         */
        @Override
        public float additiveFLOP(float a, float b) {
            halt(100);
            return a + b;
        }

        @Override
        public String toString() {
            return "Cores: " + super.getCores() +
                    "\nWattage Max: " + super.getWattageMax() +
                    "\nClock Speed: " + super.getClockSpeed() +
                    "\nSupports Raytracing?: " + supportsRaytracing;
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
