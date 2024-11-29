package sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.model;

public class Carpark {
    private Integer id;
    private String name;
    private String category;
    private String weekdayOneRate;
    private String weekdayTwoRate;
    private String saturdayRate;
    private String sundayPhRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + category + "," + weekdayOneRate + "," + weekdayTwoRate + "," + saturdayRate + "," + sundayPhRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Carpark(Integer id, String name, String category, String weekdayOneRate, String weekdayTwoRate,
            String saturdayRate, String sundayPhRate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.weekdayOneRate = weekdayOneRate;
        this.weekdayTwoRate = weekdayTwoRate;
        this.saturdayRate = saturdayRate;
        this.sundayPhRate = sundayPhRate;
    }

    public Carpark() {

    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeekdayOneRate() {
        return weekdayOneRate;
    }

    public void setWeekdayOneRate(String weekdayOneRate) {
        this.weekdayOneRate = weekdayOneRate;
    }

    public String getWeekdayTwoRate() {
        return weekdayTwoRate;
    }

    public void setWeekdayTwoRate(String weekdayTwoRate) {
        this.weekdayTwoRate = weekdayTwoRate;
    }

    public String getSaturdayRate() {
        return saturdayRate;
    }

    public void setSaturdayRate(String saturdayRate) {
        this.saturdayRate = saturdayRate;
    }

    public String getSundayPhRate() {
        return sundayPhRate;
    }

    public void setSundayPhRate(String sundayPhRate) {
        this.sundayPhRate = sundayPhRate;
    }
}
