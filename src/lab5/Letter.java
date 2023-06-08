package lab5;

import java.util.Objects;

public class Letter {
    private char symbol;

    public Letter(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return symbol == letter.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }
}
