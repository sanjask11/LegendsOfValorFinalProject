package world.rules;

public interface Rule<T> {
    boolean isValid(T ctx);
    String message();
}
