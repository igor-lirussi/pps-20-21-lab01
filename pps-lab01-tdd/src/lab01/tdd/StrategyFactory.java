package lab01.tdd;

public interface StrategyFactory {

    EqualsStrategy createEqualsStrategy(int num);

    EvenStrategy createEvenStrategy();

    MultipleOfStrategy createMultipleOfStrategy(int num);

}
