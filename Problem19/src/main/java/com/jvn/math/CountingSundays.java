package com.jvn.math;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class CountingSundays {

  public static final LocalDate START_DATE = LocalDate.of(1901, Month.JANUARY, 1);
  public static final LocalDate END_DATE = LocalDate.of(2000, Month.DECEMBER, 31);

  public static void main(String[] args) {
    int count = 0;

    for (LocalDate date = START_DATE; date.isBefore(END_DATE); date = date.plusDays(1)) {
      DayOfWeek dayOfWeek = date.getDayOfWeek();
      int dayOfMonth = date.getDayOfMonth();

      System.out.println("Day of Week: " + dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " Day of Month: " + dayOfMonth);

      if (dayOfWeek.equals(DayOfWeek.SUNDAY) && dayOfMonth == 1) {
        count++;
      }
    }

    System.out.println(count);
  }


}
