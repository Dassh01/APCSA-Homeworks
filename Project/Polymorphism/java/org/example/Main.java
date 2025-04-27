package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<PolyProcessors.Processor> processors = new ArrayList<>();

        processors.add(new PolyProcessors.CentralProcessor(
                15, 200, 3000,
                PolyProcessors.CentralProcessor.Architecure.TRICORE
        ));
        processors.add(new PolyProcessors.GraphicsProcessor(
                1600, 500, 350, true
        ));
        processors.add(new PolyProcessors.CentralProcessor(
                15, 200, 3000,
                PolyProcessors.CentralProcessor.Architecure.TRICORE
        ));

        for (PolyProcessors.Processor processor : processors) {
            System.out.println(processor + "\n");
            processor.additiveFLOP(100f, 200f);
        }

        System.out.println("Comparing processors:");
        System.out.println("CPU 1 vs GPU 1: " +
                processors.get(0).equals(processors.get(1))); // Expected: False
        System.out.println("CPU 1 vs CPU 2: " +
                processors.get(0).equals(processors.get(2))); // Expected: True
    }
}