package strategies;

public interface Strategy<T> {

    void call(T value);

    String getCalculateResult();

}
