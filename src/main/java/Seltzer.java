import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.StringJoiner;

public class Seltzer {

    public enum Series {

        ORIGINAL("Original"),
        SEASONAL("Seasonal"),
        SELTZERADE("Seltzer'ade"),
        DESSERT_CART("Dessert Cart"),
        SELTZER_JR("Seltzer Jr.");

        private final String description;

        Series(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public static Series getEnumByDescription(String p_description) {
            EnumSet<Series> enumSet = EnumSet.allOf(Series.class);
            for (Series series : enumSet) {
                if (series.getDescription().equals(p_description)) {
                    return series;
                }
            }
            throw new IllegalArgumentException("No matching Series found for description: " + p_description);
        }
    }

    private String name;
    private Series series;
    private BigDecimal score;
    private String comment;

    public Seltzer(String name, Series series, BigDecimal score, String comment) {
        this.name = name;
        this.series = series;
        this.score = score;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String toCSVFormattedString(){
        StringJoiner sj = new StringJoiner(CSVDelegate.CSV_DELIMITER);
        sj.add(getName());
        sj.add(getSeries().getDescription());
        sj.add(String.valueOf(getScore()));
        sj.add(getComment());
        return sj.toString();
    }

    @Override
    public String toString(){
        StringJoiner sj = new StringJoiner(" ");
        sj.add(name);
        sj.add(series.getDescription());
        sj.add(String.valueOf(score));
        sj.add(comment);
        return sj.toString();
    }
}
