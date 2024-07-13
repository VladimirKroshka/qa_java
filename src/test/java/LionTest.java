import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LionTest {

    @Test
    public void testDoesHaveManeForMale() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeForFemale() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самец", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion("Самка", felineMock);
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testInvalidSexThrowsException() {
        Feline felineMock = Mockito.mock(Feline.class);
        Exception exception = assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Lion("Некорректный пол", felineMock);
            }
        });
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }
}
