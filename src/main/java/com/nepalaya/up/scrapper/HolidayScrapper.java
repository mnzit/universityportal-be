package com.nepalaya.up.scrapper;

import com.nepalaya.up.model.Holiday;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class HolidayScrapper {

    public static List<Holiday> scrapHoliday() throws IOException, ParseException {
        List<Holiday> holidays = new ArrayList<>();
        String month;
        String day;
        String holidayName;
        Holiday holiday;
        Document doc = Jsoup.connect("https://english.hamropatro.com").get();
        Elements elements = doc.select("div.eachMonth");
        String[] s = doc.select("div.date > span.nep").text().split(" ");
        String year = s[2].replace(",", "");
        for (Element element : elements) {
            month = element.select("div.monthNameHome").text();
            switch (month) {
                case "Baishakh":
                    month = "1";
                    break;
                case "Jestha":
                    month = "2";
                    break;
                case "Aashadha":
                    month = "3";
                    break;
                case "Shrawan":
                    month = "4";
                    break;
                case "Bhadra":
                    month = "5";
                    break;
                case "Ashwin":
                    month = "6";
                    break;
                case "Kartik":
                    month = "7";
                    break;
                case "Mangsir":
                    month = "8";
                    break;
                case "Paush":
                    month = "9";
                    break;
                case "Magh":
                    month = "10";
                    break;
                case "Falgun":
                    month = "11";
                    break;
                case "Chaitra":
                    month = "12";
                    break;
            }
            Elements eventDetails = element.select("div.eventDetails");
            for (Element eventDetail : eventDetails) {
                List<String> events = eventDetail.select("span").stream().filter(e -> !e.text().isBlank()).map(e -> e.text()).collect(Collectors.toList());
                if (events.size() > 1) {
                    day = events.get(0);
                    holidayName = events.get(1);
                    String stringDate = new StringBuilder(year).append("-").append(month).append("-").append(day).toString();
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
                    holiday = new Holiday(holidayName, date);
                    holidays.add(holiday);
                }
            }
        }
        return holidays;
    }
}
