import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SecondTask {
    public static String MostFreeTime(String[] strArr) throws ParseException {
        List<String> listOfTime = new ArrayList<>();


        for (int i = 0; i < strArr.length; i++) {
            String[] parts = strArr[i].split("-");
            listOfTime.add(i, changeFormat(parts[0]));
            listOfTime.add(i, changeFormat(parts[1]));
        }

        Collections.sort(listOfTime);

        long max = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        for (int i = 1; i < listOfTime.size() - 1; i += 2) {
            if (Math.abs(sdf.parse(listOfTime.get(i + 1)).getTime() - sdf.parse(listOfTime.get(i)).getTime()) > max) {
                max = (Math.abs(sdf.parse(listOfTime.get(i + 1)).getTime() - sdf.parse(listOfTime.get(i)).getTime()));
            }
        }

        long t = TimeUnit.MINUTES.convert(max, TimeUnit.MILLISECONDS);

        long hours = t / 60;
        long min = t % 60;
        if (min < 10 || hours < 10) {
            if (min < 10 && hours < 10) {
                return "0" + hours + ":" + "0" + min;
            } else if (min < 10) {
                return hours + ":" + "0" + min;
            } else return "0" + hours + ":" + min;
        }
        return t / 60 + ":" + t % 60;
    }

    public static String changeFormat(String part) {
        DateFormat df = new SimpleDateFormat("hh:mmaa");
        DateFormat outputformat = new SimpleDateFormat("HH:mm");

        Date date = null;
        try {
            date = df.parse(part);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return outputformat.format(date);
    }

    public static void main(String[] args) throws ParseException {
        String[] str = {"12:15PM-02:00PM", "09:00AM-12:11PM", "02:02PM-04:00PM"};
        System.out.print(MostFreeTime(str));
    }
}
