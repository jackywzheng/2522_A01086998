package ca.bcit.comp2522.assignments.A1;

import java.util.ArrayList;

public class Ecosystem {
    private ArrayList<Pool> pools;

    public Ecosystem() {
        pools = new ArrayList<Pool>();
    }

    public void addPool(Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    public void reset() {
        pools.clear();
    }

}
