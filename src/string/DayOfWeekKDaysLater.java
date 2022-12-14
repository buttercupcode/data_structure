package string;

public class DayOfWeekKDaysLater {

    public static void main(String[] args) {
        DayOfWeekKDaysLater d = new DayOfWeekKDaysLater();

        System.out.println(d.getDayOfWeek(WeekDay.TUESDAY.name(), 101));
    }

    public String getDayOfWeek(String s, int k) {
        WeekDay day = WeekDay.valueOf(s);
        if (k < 0) k = k + 7;

        int i = (day.ordinal() + k) % 7;
        return (WeekDay.getWeekday(i)).name();
    }

    enum WeekDay {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;
        public final static WeekDay[] values = WeekDay.values();

        public static WeekDay getWeekday(int ordinal) {
            return values[ordinal];
        }

    }
}
