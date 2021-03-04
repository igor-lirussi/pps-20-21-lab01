package lab01.tdd;

public class MultipleOfStrategy implements SelectStrategy {

    int number;

    public MultipleOfStrategy(int number) {
        this.number=number;
    }
    @Override
    public boolean apply(int element) {
        return element % number == 0;
    }
}
