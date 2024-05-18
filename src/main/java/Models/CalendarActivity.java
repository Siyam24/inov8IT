package Models;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class CalendarActivity {
    private String CEID;
    private ZonedDateTime event_datetime;
    private String event_details;

    public CalendarActivity(String CEID, ZonedDateTime event_datetime, String event_details) {
        this.CEID=CEID;
        this.event_datetime = event_datetime;
        this.event_details = event_details;
    }

    public String getCEID() {
        return CEID;
    }

    public ZonedDateTime getEvent_datetime() {
        return event_datetime;
    }

    public String getEvent_details() {
        return event_details;
    }

    public void setCEID(String  CEID) {
        this.CEID = CEID;
    }

    public void setEvent_datetime(ZonedDateTime event_datetime) {
        this.event_datetime = event_datetime;
    }

    public void setEvent_details(String event_details) {
        this.event_details = event_details;
    }

    @Override
    public String toString() {
        return event_details;
    }
}
