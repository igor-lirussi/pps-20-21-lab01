package lab01.tdd;

public class EqualsStrategy implements SelectStrategy {
    int number;

    public EqualsStrategy(int number) {
        this.number=number;
    }
    @Override
    public boolean apply(int element) {
        return element == number;
    }
}
