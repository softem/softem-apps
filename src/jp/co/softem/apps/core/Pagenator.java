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

    public Pagenator(int total, int recordCount, int currentPage, int limit,
            String basePath) {
        if (limit < 1) {
            throw new IllegalArgumentException(
                "Please specify the number of pages is greater than 1.");
        }
        this.total = total;

        BigDecimal b = new BigDecimal(total).divide(new BigDecimal(limit));
        int count = b.setScale(0, RoundingMode.CEILING).intValue();
        this.pageCount = (count < 1) ? 1 : count;

        int page = (currentPage < 1) ? 1 : currentPage;
        if (page > this.pageCount) {
            this.currentPage = this.pageCount;
        } else {
            this.currentPage = page;
        }
        this.navigation = createNavigation(basePath);

        int start = ((this.currentPage - 1) * limit + 1);
        this.label =
            total + "件中 " + start + " - " + (recordCount + start - 1) + "件";
    }

    public String createNavigation(String basePath) {
        int start = (currentPage > 5) ? currentPage - 5 : 1;
        StringBuffer sb = new StringBuffer("<ul class=\"navigation\">");
        int count = 0;
        for (int i = start; i < pageCount + 1; i++) {
            String link =
                "<a href=\"" + basePath + "index/" + i + "\">" + i + "</a>";
            if (currentPage == i) {
                link =
                    "<span class=\"active\">" + String.valueOf(i) + "</span>";
            }
            sb.append("<li>").append(link).append("</li>");
            count++;
            if (count >= 10) {
                break;
            }
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
