package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;
    private final String textForCheckName;
    private final String textForCheckPrice;
    private final boolean isDebugging = false;

    public BunTest(String name, float price, String textForCheckName, String textForCheckPrice) {
        this.name = name;
        this.price = price;
        this.textForCheckName = textForCheckName;
        this.textForCheckPrice = textForCheckPrice;
    }

    @Parameterized.Parameters(name = "Булочка {0} с ценой {1}")
    public static Object[] getBunData() {
        return new Object[][]{
                {"Sweet bun", 1, "название подходит.", "цена подходит."},
                {"", 2, "название не подходит.", "цена подходит."},
                {null, 3, "название не подходит.", "цена подходит."},
                {"Check long name for bun", 4, "название не подходит.", "цена подходит."},
                {"Русское название", 5, "название не подходит.", "цена подходит."},
                {"Small", 0, "название подходит.", "цена не подходит."},
                {"Medium", -1, "название подходит.", "цена не подходит."},
                {"Big", (float) 0.1, "название подходит.", "цена не подходит."},
        };
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name,price);
        String checkedBunName = bun.getName();
        assertEquals(name, checkedBunName);
        if (isDebugging) { System.out.println("Булочка " + bun.getName()+" - "+textForCheckName); };
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(name,price);
        float checkedBunPrice = bun.getPrice();
        assertEquals(price, checkedBunPrice,0);
        if (isDebugging) { System.out.println("Стоимость " + bun.getPrice() + " - "+ textForCheckPrice);} };
}
