package model.entities;

import model.execptions.DomainExecption;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Date checkOut, Date checkIn, Integer roomNumber) {

        if (!checkOut.after(checkIn)) {
            throw new DomainExecption("Check-out date must be after Check-in date");
        }
        this.checkOut = checkOut;
        this.checkIn = checkIn;
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getcheckIn() {
        return checkIn;
    }

    public Date getcheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || (checkOut.before(now))) {
            throw new DomainExecption("Reservation dates for update must be future dates");
        }
        if (!checkOut.after(checkIn)) {
            throw new DomainExecption("Check-out date must be after Check-in date");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

    }


    @Override
    public String toString() {
        return "Reservation: " + "Room = " + roomNumber + ", checkIn = " + sdf.format(checkIn) + ", checkOut = " + sdf.format(checkOut) + ", " + duration() + " nights";
    }
}

