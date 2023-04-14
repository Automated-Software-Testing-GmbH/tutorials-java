package util.sideeffects;

public class SideEffect {

    private int steps;

    public SideEffect(int initialSteps) {
        this.steps = initialSteps;
    }

    public void addSteps(int steps) {
        this.steps += steps;
    }

}
