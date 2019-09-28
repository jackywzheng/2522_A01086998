package ca.bcit.comp2522.labs.lab03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Plantation {
    public static final int PLANT_TREE_GENERATOR_MAXIMUM = 991;
    public static final int PLANT_TREE_GENERATOR_MINIMUM = 10;
    public static final int TRUNK_CIRCUMFERENCE_MAXIMUM = 91;

    private ArrayList<Tree> trees = new ArrayList<>();
    private Random randomNumberGenerator = new Random();

    public int add(Tree tree) {
        trees.add(tree);
        return trees.size();
    }

    public int size() {
        return trees.size();
    }

    public int seed() {
        int numberOfTreesToPlant =
                randomNumberGenerator.nextInt(PLANT_TREE_GENERATOR_MAXIMUM)
                + PLANT_TREE_GENERATOR_MINIMUM;
        for (int i = 0; i < numberOfTreesToPlant; i++) {
            int treeAge = randomNumberGenerator.nextInt(
                    PLANT_TREE_GENERATOR_MAXIMUM
                    + PLANT_TREE_GENERATOR_MINIMUM);
            int trunkCircumference = randomNumberGenerator.nextInt(
                    TRUNK_CIRCUMFERENCE_MAXIMUM
                            + PLANT_TREE_GENERATOR_MINIMUM);
            int treeType = randomNumberGenerator.nextInt(
                    Tree.Species.values().length);
            Tree.Species species = Tree.Species.values()[treeType];
            Tree tree = new Tree(species, treeAge, trunkCircumference);
            trees.add(tree);
        }
        return numberOfTreesToPlant;
    }

    public ArrayList<Tree> harvest(double cutOffCircumference) {
        ArrayList<Tree> harvestedTrees = new ArrayList<>();
        Iterator<Tree> it = trees.iterator();
        while (it.hasNext()) {
            Tree tree = it.next();
            if (tree.getTrunkCircumferenceInCentimetres()
                    >= cutOffCircumference) {
                harvestedTrees.add(tree);
                it.remove();
            }
        }
        return harvestedTrees;
    }

    public ArrayList<Tree> tabulate() {
        ArrayList<Tree> sortedTrees = new ArrayList<>();
        Iterator<Tree> it = trees.iterator();
        int tracker = 0;
        while (it.hasNext()) {
            Tree tree = it.next();
            if (tree.getType() == Tree.Species.MAPLE) {
                sortedTrees.add(0, tree);
                tracker++;
            } else if (tree.getType() == Tree.Species.ARBUTUS) {
                sortedTrees.add(tracker, tree);
            } else {
                sortedTrees.add(tree);
            }
        }
        // Test
        Iterator<Tree> it2 = sortedTrees.iterator();
        while (it2.hasNext()) {
            Tree tree = it2.next();
            System.out.println(tree.getType());
        }
        return sortedTrees;
    }
}
