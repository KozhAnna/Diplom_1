package praktikum;

import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][]{
            {IngredientType.SAUCE, "hot sauce", 100},
            {IngredientType.SAUCE, "sour cream", 200},
            {IngredientType.SAUCE, "chili sauce", 300},
            {IngredientType.FILLING, "cutlet", 100},
            {IngredientType.FILLING, "dinosaur", 200},
            {IngredientType.FILLING, "sausage", 300},
        };
    }

    @Test
    public void getPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float currentPrice = ingredient.getPrice();
        assertEquals(price, (float) currentPrice,0);
        System.out.println ("Ингридиент " +  ingredient.getName() + " стоит " + ingredient.getPrice());
    }

    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String currentName = ingredient.getName();
        assertEquals(name, currentName);
        System.out.println ("Ингридиент " + ingredient.getName());
    }

    @Test
    public void getIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType currentType = ingredient.getType();
        assertEquals(type, currentType);
        System.out.println ("У ингридиента " + ingredient.getName() + " тип " + ingredient.getType());
    }
}
