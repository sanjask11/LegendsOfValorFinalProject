package world.rules;

import java.util.List;

public final class RuleEngine {

    private RuleEngine() {
        // utility class – prevent instantiation
    }

    public static <T> boolean validate(List<Rule<T>> rules, T context) {
        for (Rule<T> rule : rules) {
            if (!rule.isValid(context)) {
                return false;
            }
        }
        return true;
    }
}
