import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static final List<Seltzer> lstSeltzer = new ArrayList<>();
    public static final String HEADER_ROW = "Name,Series,Score,Comment";

    static {
        //TEST DATA
        Seltzer seltzer = new Seltzer("Cherry", Seltzer.Series.ORIGINAL, BigDecimal.valueOf(4.5), "Very cherry!");
        Seltzer seltzer1 = new Seltzer("Lime", Seltzer.Series.SELTZER_JR, BigDecimal.valueOf(8.2), "Refreshing and zesty!");
        Seltzer seltzer2 = new Seltzer("Berry", Seltzer.Series.DESSERT_CART, BigDecimal.valueOf(6.6), "A hint of berry, not overpowering.");
        Seltzer seltzer3 = new Seltzer("Grapefruit", Seltzer.Series.SEASONAL, BigDecimal.valueOf(4.5), "Bold and tangy, a timeless favorite!");
        Seltzer seltzer4 = new Seltzer("Mango", Seltzer.Series.SELTZER_JR, BigDecimal.valueOf(3.6), "Perfectly sweet, island vibes!");
        Seltzer seltzer5 = new Seltzer("Peach", Seltzer.Series.SELTZERADE, BigDecimal.valueOf(5.4), "Delicate flavor, but could be stronger.");
        Seltzer seltzer6 = new Seltzer("Raspberry", Seltzer.Series.DESSERT_CART, BigDecimal.valueOf(9.5), "Sweet with a tart kick!");
        Seltzer seltzer7 = new Seltzer("Pineapple", Seltzer.Series.SELTZERADE, BigDecimal.valueOf(7.1), "Tropical and vibrant!");
        Seltzer seltzer8 = new Seltzer("Cucumber", Seltzer.Series.ORIGINAL, BigDecimal.valueOf(8.6), "Subtle and crisp, an acquired taste.");
        Seltzer seltzer9 = new Seltzer("Blackberry", Seltzer.Series.ORIGINAL, BigDecimal.valueOf(7.5), "Earthy and rich flavor.");
        Seltzer seltzer10 = new Seltzer("Watermelon", Seltzer.Series.SELTZERADE, BigDecimal.valueOf(5.5), "Juicy and refreshing, summer vibes!");

        lstSeltzer.add(seltzer);
        lstSeltzer.add(seltzer1);
        lstSeltzer.add(seltzer2);
        lstSeltzer.add(seltzer3);
        lstSeltzer.add(seltzer4);
        lstSeltzer.add(seltzer5);
        lstSeltzer.add(seltzer6);
        lstSeltzer.add(seltzer7);
        lstSeltzer.add(seltzer8);
        lstSeltzer.add(seltzer9);
        lstSeltzer.add(seltzer10);
    }
}
