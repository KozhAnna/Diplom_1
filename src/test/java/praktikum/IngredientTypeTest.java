package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void testSauceType() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testFillingType() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
