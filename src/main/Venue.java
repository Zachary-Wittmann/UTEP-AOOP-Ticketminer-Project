package main;

/**
 * @author Zachary Wittmann
 * @since October 8, 2023
 * CS 3331
 * Dr. Mejia
 * Programming Assignment 2
 * Description: The Venue.java file is used to create Venue objects.
 * Honesty Statement: All code written in this file was done by Zachary Wittmann
 * without any help from outside sources apart from the instructor and his assistants.
 */
public abstract class Venue {
    /**
     * These are the attributes
     */
    private String venueName;
    private int pctSeatsUnavailable;
    private String venueType;
    private int venueCapacity;
    private double venueCost;
    private int vipPct;
    private int goldPct;
    private int silverPct;
    private int bronzePct;
    private int generalPct;
    private int reservedExtraPct;
    private boolean fireworksPlanned;
    private double fireworksCost;

    /**
     * Description: This creates an empty instance of Venue
     */
    public Venue() {

    }

    /**
     * Description: Get the venue name.
     * @return The venue name.
     */
    public String getVenueName() {
        return this.venueName;
    }

    /**
     * Description: Set the venue name.
     * @param venueName Holds venue name.
     */
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    /**
     * Description: Get the PCT unavailable.
     * @return the PCT unavailable.
     */
    public int getPctSeatsUnavailable() {
        return this.pctSeatsUnavailable;
    }

    /**
     * Description: Set the PCT unavailable.
     * @param pctSeatsUnavailable HOlds PCT unavailable.
     */
    public void setPctSeatsUnavailable(int pctSeatsUnavailable) {
        this.pctSeatsUnavailable = pctSeatsUnavailable;
    }

    /**
     * Description: Get the venue type.
     * @return The venue type
     */
    public String getVenueType() {
        return this.venueType;
    }

    /**
     * Description: Set the venue type.
     * @param venueType Holds venue type.
     */
    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    /**
     * Description: Get the venue capacity.
     * @return the venue capacity.
     */
    public int getVenueCapacity() {
        return this.venueCapacity;
    }

    /**
     * Description: Set the venue type.
     * @param venueCapacity Holds venue capacity.
     */
    public void setVenueCapacity(int venueCapacity) {
        this.venueCapacity = venueCapacity;
    }

    /**
     * Description: Get the venue cost.
     * @return teh venue cost.
     */
    public double getVenueCost() {
        return this.venueCost;
    }

    /**
     * Description: Set the venue cost.
     * @param venueCost Holds venue cost.
     */
    public void setVenueCost(double venueCost) {
        this.venueCost = venueCost;
    }

    /**
     * Description: Get the vip pct.
     * @return the vip pct
     */
    public int getVipPct() {
        return this.vipPct;
    }

    /**
     * Description: Set the vip pct.
     * @param vipPct Holds vip pct.
     */
    public void setVipPct(int vipPct) {
        this.vipPct = vipPct;
    }

    /**
     * Description: Get the vip pct.
     * @return The vip pct.
     */
    public int getGoldPct() {
        return this.goldPct;
    }

    /**
     * Description: Set the gold pct.
     * @param goldPct Holds gold pct
     */
    public void setGoldPct(int goldPct) {
        this.goldPct = goldPct;
    }

    /**
     * Description: Get the gold pct.
     * @return The gold pct.
     */
    public int getSilverPct() {
        return this.silverPct;
    }

    /**
     * Description: Set the silver pct.
     * @param silverPct Holds silver pct
     */
    public void setSilverPct(int silverPct) {
        this.silverPct = silverPct;
    }

    /**
     * Description: Get the silver pct.
     * @return The silver pct.
     */
    public int getBronzePct() {
        return this.bronzePct;
    }

    /**
     * Description: Get the bronze pct.
     * @param bronzePct holds bronze pct.
     */
    public void setBronzePct(int bronzePct) {
        this.bronzePct = bronzePct;
    }

    /**
     * Description: Get the bronze pct.
     * @return The bronze pct.
     */
    public int getGeneralPct() {
        return this.generalPct;
    }

    /**
     * Description: Set the PCT for general seats. From Walter and Zachary.
     * @param generalPct Holds the PCT amount.
     */
    public void setGeneralPct(int generalPct) {
        this.generalPct = generalPct;
    }

    /**
     * Description: Get the PCT for Reserved seats. From Walter and Zachary.
     * @return The PCT for Reserved.
     */
    public int getReservedExtraPct() {
        return this.reservedExtraPct;
    }

    /**
     * Description: Set the reserved extra pct.
     * @param reservedExtraPct Holds the reserved extra pct
     */
    public void setReservedExtraPct(int reservedExtraPct) {
        this.reservedExtraPct = reservedExtraPct;
    }

    /**
     * Description: Get the fireworks planned.
     * @return The fireworks planned.
     */
    public boolean getFireworksPlanned() {
        return this.fireworksPlanned;
    }

    /**
     * Description: Set the fireworks planned.
     * @param fireworksPlanned Holds fireworks planned.
     */
    public void setFireworksPlanned(boolean fireworksPlanned) {
        this.fireworksPlanned = fireworksPlanned;
    }

    /**
     * Description: Get the fireworks cost.
     * @return The fireworks cost.
     */
    public double getFireworksCost() {
        return this.fireworksCost;
    }

    /**
     * Description: Set the fireworks cost.
     * @param fireworksCost Holds the fireworks cost.
     */
    public void setFireworksCost(double fireworksCost) {
        this.fireworksCost = fireworksCost;
    }
}
