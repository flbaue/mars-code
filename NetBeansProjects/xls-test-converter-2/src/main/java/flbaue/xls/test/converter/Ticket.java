package flbaue.xls.test.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {

    private Date drawdate;
    private boolean s77;
    private boolean s6;
    private boolean gls;
    private boolean subscription;
    private boolean subscriptionRe;
    private int duration;
    private int ticketnumber;
    private int blocks;
    private String drawday;
    private String system;
    private String type;
    private String price;
    private final String dateFormat = "dd.MM.yyyy";
    private final SimpleDateFormat formater = new SimpleDateFormat(dateFormat);

    public Ticket() {

        drawdate = null;
        s77 = false;
        s6 = false;
        gls = false;
        subscription = false;
        subscriptionRe = false;
        duration = -1;
        ticketnumber = -1;
        blocks = -1;
        type = "normal";
        system = "";
        price = "";
        drawday = null;
    }

    public String getPrice() {

        return this.price;
    }

    public void setPrice(String price) {

        price = price.replace(",", ".");

        if (price.matches("\\d+\\.\\d{2}")) {
            this.price = price + " EUR";
        } else if (price.matches("\\d+\\.\\d")) {
            this.price = price + "0 EUR";
        } else {
            this.price = price + ".00 EUR";
        }
    }

    public String getType() {

        return this.type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getSystem() {

        return this.system;
    }

    public void setSystem(String system) {

        this.system = system;
    }

    public Date getDrawdate() {

        return drawdate;
    }

    public void setDrawdate(Date drawdate) {

        this.drawdate = drawdate;
    }

    public boolean isS77() {

        return s77;
    }

    public void setS77(boolean s77) {

        this.s77 = s77;
    }

    public boolean isS6() {

        return s6;
    }

    public void setS6(boolean s6) {

        this.s6 = s6;
    }

    public boolean isGls() {

        return gls;
    }

    public void setGls(boolean gls) {

        this.gls = gls;
    }

    public boolean isSubscription() {

        return subscription;
    }

    public void setSubscription(boolean subscription) {

        this.subscription = subscription;
    }

    public boolean isSubscriptionRe() {

        return subscriptionRe;
    }

    public void setSubscriptionRe(boolean subscriptionRe) {

        this.subscriptionRe = subscriptionRe;
    }

    public int getDuartion() {

        return duration;
    }

    public void setDuration(int runtime) {

        this.duration = runtime;
    }

    public int getTicketnumber() {

        return ticketnumber;
    }

    public void setTicketnumber(int ticketnumber) {

        this.ticketnumber = ticketnumber;
    }

    public int getBlocks() {

        return blocks;
    }

    public void setBlocks(int blocks) {

        this.blocks = blocks;
    }

    public String getDrawday() {

        return drawday;
    }

    public void setDrawday(String drawday) {

        this.drawday = drawday;
    }

    public String toString() {

        return "ticketnummer: " + getTicketnumber() + ",\n Subscription: " + isSubscription() + ",\n Subscription_RE : "
                + isSubscriptionRe() + ",\n Duration: " + getDuartion() + ",\n Drawday: " + getDrawday() + ",\n S77: " + isS77()
                + ",\n S6: " + isS6() + ",\n GLS: " + isGls() + ",\n System: " + getSystem() + ",\n Typ: " + getType() + ",\n Blocks: "
                + getBlocks() + ",\n Price: " + getPrice() + ",\n Drawdate: " + formater.format(getDrawdate()) + "\n\n";
    }
}
