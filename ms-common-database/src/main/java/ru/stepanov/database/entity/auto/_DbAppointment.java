package ru.stepanov.database.entity.auto;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import ru.stepanov.database.entity.DbAddress;
import ru.stepanov.database.entity.DbAppointmentServices;

/**
 * Class _DbAppointment was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DbAppointment extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<String> COMMENT = Property.create("comment", String.class);
    public static final Property<LocalDateTime> CREATED_DATE = Property.create("createdDate", LocalDateTime.class);
    public static final Property<LocalDateTime> DATE = Property.create("date", LocalDateTime.class);
    public static final Property<LocalDateTime> DELETED_DATE = Property.create("deletedDate", LocalDateTime.class);
    public static final Property<Integer> DURATION_MIN = Property.create("durationMin", Integer.class);
    public static final Property<LocalDateTime> MODIFIED_DATE = Property.create("modifiedDate", LocalDateTime.class);
    public static final Property<Integer> PRICE = Property.create("price", Integer.class);
    public static final Property<DbAddress> APPOINTMENT_TO_ADDRESS = Property.create("appointmentToAddress", DbAddress.class);
    public static final Property<List<DbAppointmentServices>> APPOINTMENT_TO_APPOINTMENT_SERVICES = Property.create("appointmentToAppointmentServices", List.class);

    public void setComment(String comment) {
        writeProperty("comment", comment);
    }
    public String getComment() {
        return (String)readProperty("comment");
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        writeProperty("createdDate", createdDate);
    }
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime)readProperty("createdDate");
    }

    public void setDate(LocalDateTime date) {
        writeProperty("date", date);
    }
    public LocalDateTime getDate() {
        return (LocalDateTime)readProperty("date");
    }

    public void setDeletedDate(LocalDateTime deletedDate) {
        writeProperty("deletedDate", deletedDate);
    }
    public LocalDateTime getDeletedDate() {
        return (LocalDateTime)readProperty("deletedDate");
    }

    public void setDurationMin(int durationMin) {
        writeProperty("durationMin", durationMin);
    }
    public int getDurationMin() {
        Object value = readProperty("durationMin");
        return (value != null) ? (Integer) value : 0;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        writeProperty("modifiedDate", modifiedDate);
    }
    public LocalDateTime getModifiedDate() {
        return (LocalDateTime)readProperty("modifiedDate");
    }

    public void setPrice(int price) {
        writeProperty("price", price);
    }
    public int getPrice() {
        Object value = readProperty("price");
        return (value != null) ? (Integer) value : 0;
    }

    public void setAppointmentToAddress(DbAddress appointmentToAddress) {
        setToOneTarget("appointmentToAddress", appointmentToAddress, true);
    }

    public DbAddress getAppointmentToAddress() {
        return (DbAddress)readProperty("appointmentToAddress");
    }


    public void addToAppointmentToAppointmentServices(DbAppointmentServices obj) {
        addToManyTarget("appointmentToAppointmentServices", obj, true);
    }
    public void removeFromAppointmentToAppointmentServices(DbAppointmentServices obj) {
        removeToManyTarget("appointmentToAppointmentServices", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<DbAppointmentServices> getAppointmentToAppointmentServices() {
        return (List<DbAppointmentServices>)readProperty("appointmentToAppointmentServices");
    }


}
