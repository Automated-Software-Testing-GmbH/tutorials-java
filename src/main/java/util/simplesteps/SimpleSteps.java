package util.simplesteps;

import java.util.Objects;

public class SimpleSteps {

    private int steps;

    public SimpleSteps(int initialSteps) {
        this.steps = initialSteps;
    }

    public void addSteps(int steps) {
        this.steps += steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleSteps that = (SimpleSteps) o;
        return steps == that.steps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }
}
