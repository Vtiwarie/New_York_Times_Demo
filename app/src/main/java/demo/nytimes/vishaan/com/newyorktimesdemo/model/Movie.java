package demo.nytimes.vishaan.com.newyorktimesdemo.model;

/**
 * Created by vishaantiwarie on 12/10/17.
 */

public class Movie {
    private String display_title;
    private String headline;
    private String summary_short;
    private Image link;

    public String getDisplay_title() {
        return display_title;
    }

    public void setDisplay_title(String display_title) {
        this.display_title = display_title;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary_short() {
        return summary_short;
    }

    public void setSummary_short(String summary_short) {
        this.summary_short = summary_short;
    }

    public Image getLink() {
        return link;
    }

    public void setLink(Image link) {
        this.link = link;
    }
}
