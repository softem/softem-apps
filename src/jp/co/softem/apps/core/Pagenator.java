package jp.co.softem.apps.core;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pagenator {

    public String create(int perPage, int totalPages) {
        if (perPage < 1) {
            throw new IllegalArgumentException(
                "Please specify the number of pages is greater than 1.");
        }
        BigDecimal b = new BigDecimal(totalPages / perPage);
        b.setScale(1, RoundingMode.CEILING);
        return null;
    }

}
