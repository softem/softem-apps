package jp.co.softem.apps.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Pagenator implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int pageCount;

    private final int total;

    private final int currentPage;

    private final String navigation;

    private final String label;

    public Pagenator(int total, int recordCount, int currentPage, int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException(
                "Please specify the number of pages is greater than 1.");
        }
        this.total = total;

        BigDecimal b = new BigDecimal(total / limit);
        int count = b.setScale(0, RoundingMode.CEILING).intValue();
        this.pageCount = (count < 1) ? 1 : count;

        int page = (currentPage < 1) ? 1 : currentPage;
        if (page > this.pageCount) {
            this.currentPage = this.pageCount;
        } else {
            this.currentPage = page;
        }
        this.navigation = createNavigation();

        int start = ((this.currentPage - 1) * limit + 1);
        this.label =
            total + "件中 " + start + " - " + (recordCount + start - 1) + "件";
    }

    public String createNavigation() {
        StringBuffer sb = new StringBuffer("<ul class=\"navigation\">");
        for (int i = 0; i < pageCount; i++) {
            String link =
                "<a href=\"" + (i + 1) + "\">" + (i + 1) + "</a>";
            if (currentPage == (i + 1)) {
                link = String.valueOf(i + 1);
            }
            sb.append("<li>").append(link).append("</li>");
        }
        sb.append("</ul>");
        return String.valueOf(sb);
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getTotal() {
        return total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public String getNavigation() {
        return navigation;
    }

    public String getLabel() {
        return label;
    }

}
