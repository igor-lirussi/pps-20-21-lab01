package lab01.tdd;

public class StrategyFactoryImpl implements StrategyFactory {
    @Override
    public EqualsStrategy createEqualsStrategy(int num) {
        return new EqualsStrategy(num);
    }

    @Override
    public EvenStrategy createEvenStrategy() {
        return new EvenStrategy();
    }

    @Override
    public MultipleOfStrategy createMultipleOfStrategy(int num) {
        return new MultipleOfStrategy(num);
    }
}
