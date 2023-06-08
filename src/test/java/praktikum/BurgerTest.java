package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    int index;
    int newIndex;
    private final boolean isDebugging = true;

    @Mock
    Bun bun;
    @Mock
    List<Ingredient> ingredients;
    @Mock
    Ingredient ingredient;

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger(bun, ingredients);
        burger.addIngredient(ingredient);
        Mockito.verify(ingredients,Mockito.times(1)).add(ingredient);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger (bun, ingredients);
        burger.removeIngredient(index);
        Mockito.verify(ingredients,Mockito.times(1)).remove(index);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger(bun, ingredients);
        burger.moveIngredient(index, newIndex);
        Mockito.verify(ingredients,Mockito.times(1)).add(newIndex, ingredients.remove(index));
    }

    @Test
    public void getBurgerPriceTest(){
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger(bun, ingredients);
        Mockito.when(bun.getPrice()).thenReturn(buns.get(0).getPrice());
        assertEquals(1400, burger.getPrice(),0);
        if (isDebugging) { System.out.println("Стоимость бургера " + burger.getPrice()); };
    }

    @Test
    public void getBurgerReceiptTest() {
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        Burger burger = new Burger(bun, ingredients);
        Mockito.when(bun.getName()).thenReturn(buns.get(1).getName());
        burger.getReceipt();
        Mockito.verify(bun, Mockito.times(2)).getName();
        assertThat(burger.getReceipt(), startsWith("(==== white bun ====)"));
        assertThat(burger.getReceipt(), containsString("= sauce hot sauce ="));
        assertThat(burger.getReceipt(), containsString("= sauce sour cream ="));
        assertThat(burger.getReceipt(), containsString("= sauce chili sauce ="));
        assertThat(burger.getReceipt(), containsString("= filling cutlet ="));
        assertThat(burger.getReceipt(), containsString("= filling dinosaur ="));
        assertThat(burger.getReceipt(), containsString("= filling sausage ="));
        assertThat(burger.getReceipt(), endsWith("Price: 1200,000000\n"));
        assertEquals ("white bun", bun.getName());
        if (isDebugging) { System.out.println(burger.getReceipt()); };
    }
}
