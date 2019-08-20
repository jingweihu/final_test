package com.laioffer.recyclerview;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataService {
    private static String STEAM = "STEAM";
    private static String EBAY = "EBAY";
    private static String AMAZON = "AMAZON";

    public static List<Item> generateFakeData(int number) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Item item;
            if (i % 3 == 0) {
                item = new Item();
                item.setShopName(STEAM);
                item.setItemName("game " + i / 3);
                item.setPrice(getRandomPrice());
                item.setSponsorType(SponsorType.STEAM);
            } else if (i % 3 == 1) {
                item = new Item();
                item.setShopName(EBAY);
                item.setItemName("product " + i / 3);
                item.setPrice(getRandomPrice());
                item.setSponsorType(SponsorType.EBAY);
            } else {
                item = new Item();
                item.setShopName(AMAZON);
                item.setItemName("food " + i / 3);
                item.setPrice(getRandomPrice());
                item.setSponsorType(SponsorType.AMAZON);
            }
            items.add(item);
        }
        Collections.shuffle(items);
        return items;
    }

    private static double getRandomPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        String formatResult = decimalFormat.format(Math.random() * 100);
        return Double.parseDouble(formatResult);
    }

}
