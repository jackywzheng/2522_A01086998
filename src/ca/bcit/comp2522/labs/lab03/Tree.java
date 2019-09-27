package ca.bcit.comp2522.labs.lab03;

public class Tree {
    enum Species {MAPLE, ARBUTUS, BLUE_SPRUCE };
    private Species type;
    private int ageInYears;
    private int trunkCircumferenceInCentimetres;

    public Tree(final int newAgeInYears,
                final int newTrunkCircumferenceInCentimetres) {
        type = Species.MAPLE;
        ageInYears = newAgeInYears;
        trunkCircumferenceInCentimetres = newTrunkCircumferenceInCentimetres;
    }

    public Tree(Species newType, final int newAgeInYears,
                final int newTrunkCircumferenceInCentimetres) {
        type = newType;
        ageInYears = newAgeInYears;
        trunkCircumferenceInCentimetres = newTrunkCircumferenceInCentimetres;
    }

    public Species getType() {
        return type;
    }


    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(int ageInYears) {
        this.ageInYears = ageInYears;
    }

    public int getTrunkCircumferenceInCentimetres() {
        return trunkCircumferenceInCentimetres;
    }

    public void setTrunkCircumferenceInCentimetres(
            int trunkCircumferenceInCentimetres) {
        this.trunkCircumferenceInCentimetres = trunkCircumferenceInCentimetres;
    }
}