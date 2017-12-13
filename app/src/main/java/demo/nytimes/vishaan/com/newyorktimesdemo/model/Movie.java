package demo.nytimes.vishaan.com.newyorktimesdemo.model;

/**
 * Created by vishaantiwarie on 12/10/17.
 */

public class Movie {
    private String display_title;
    private String headline;
    private String summary_short;
    private Image multimedia;

    public String getDisplayTitle() {
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

    public Image getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Image multimedia) {
        this.multimedia = multimedia;
    }
}
