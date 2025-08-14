package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Date checkout, Date checkin, Integer roomNumber) {
        this.checkout = checkout;
        this.checkin = checkin;
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration() {
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkin, Date checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }


    @Override
    public String toString() {
        return "Reservation: "
                + "Room = "
                + roomNumber
                + ", checkin = "
                + sdf.format(checkin) +
                ", checkout = "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights";
    }
}

