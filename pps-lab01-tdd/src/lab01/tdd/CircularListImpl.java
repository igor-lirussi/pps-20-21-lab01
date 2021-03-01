package lab01.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    protected List<Integer> list = new LinkedList<Integer>();
    protected int index = 0;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (list.isEmpty())
            return Optional.empty();
        else
            index++;
            index = index % list.size();
            return Optional.ofNullable(list.get(index));
    }

    @Override
    public Optional<Integer> previous() {
        if (list.isEmpty())
            return Optional.empty();
        else
            index--;
            if (index<0)
                index= list.size()-1;
            return Optional.ofNullable(list.get(index));
    }

    @Override
    public void reset() {

    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
