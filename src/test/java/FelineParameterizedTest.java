import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testGetKittensWithCount(int count) {
        Feline feline = new Feline();
        assertEquals(count, feline.getKittens(count));
    }
}
