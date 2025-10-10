
/**
 * Represents a span of time in hours and minutes.
 */
public class TimeSpan2 {
    /** The number of minutes in one hour. */
    private static final int MINUTES_PER_HOUR = 60;

    /** The number of whole hours in the time span. */
    private int hours;

    /** The number of minutes in the time span, from 0 to 59. */
    private int minutes;

    /** Constructs a TimeSpan object with 0 hours and 0 minutes. */
    public TimeSpan2() {
        this(0, 0);
    }

    /** Constructs a TimeSpan object with the given minutes. */
    public TimeSpan2(int minutes) {
        this(minutes / MINUTES_PER_HOUR, minutes % MINUTES_PER_HOUR);
    }

    /** Constructs a TimeSpan object with the given hours and minutes. */
    public TimeSpan2(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            final int totalMinutes = hours * MINUTES_PER_HOUR + minutes;
            this.hours = totalMinutes / MINUTES_PER_HOUR;
            this.minutes = totalMinutes % MINUTES_PER_HOUR;
        }
    }

    /** Constructs a TimeSpan object by copying another TimeSpan. */
    public TimeSpan2(TimeSpan2 other) {
        if (other == null) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = other.hours;
            this.minutes = other.minutes;
        }
    }

    /** Gets the hours part of the time span. */
    public int getHours() {
        return this.hours;
    }

    /** Gets the minutes part of the time span. */
    public int getMinutes() {
        return this.minutes;
    }

    /**
     * Adds the specified amount of time to this time span.
     * @param hours The number of hours to add.
     * @param minutes The number of minutes to add.
     */
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            return;
        }
        final int totalMinutes = this.getTotalMinutes() + hours * MINUTES_PER_HOUR + minutes;
        this.hours = totalMinutes / MINUTES_PER_HOUR;
        this.minutes = totalMinutes % MINUTES_PER_HOUR;
    }

    /**
     * Adds the specified number of minutes to this time span.
     * @param minutes The number of minutes to add.
     */
    public void add(int minutes) {
        this.add(0, minutes);
    }

    /**
     * Adds another TimeSpan to this one.
     * @param other The TimeSpan object to add.
     */
    public void add(TimeSpan2 other) {
        if (other != null) {
            this.add(other.hours, other.minutes);
        }
    }

    /**
     * Subtracts the specified amount of time from this time span.
     * @param hours The number of hours to subtract.
     * @param minutes The number of minutes to subtract.
     */
    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            return;
        }
        final int totalMinutes = this.getTotalMinutes() - (hours * MINUTES_PER_HOUR + minutes);
        if (totalMinutes < 0) {
            return;
        }
        this.hours = totalMinutes / MINUTES_PER_HOUR;
        this.minutes = totalMinutes % MINUTES_PER_HOUR;
    }

    /**
     * Subtracts the specified number of minutes from this time span.
     * @param minutes The number of minutes to subtract.
     */
    public void subtract(int minutes) {
        this.subtract(0, minutes);
    }

    /**
     * Subtracts another TimeSpan from this one.
     * @param other The TimeSpan object to subtract.
     */
    public void subtract(TimeSpan2 other) {
        if (other != null) {
            this.subtract(other.hours, other.minutes);
        }
    }

    /**
     * Gets the total time span in minutes.
     * @return The total number of minutes.
     */
    public int getTotalMinutes() {
        return this.hours * MINUTES_PER_HOUR + this.minutes;
    }

    /**
     * Gets the total time span as a fractional number of hours.
     * @return The total hours as a double.
     */
    public double getTotalHours() {
        return this.hours + (this.minutes / (double) MINUTES_PER_HOUR);
    }

    @Override
    public String toString() {
        return this.hours + " hours, " + this.minutes + " minutes";
    }
}