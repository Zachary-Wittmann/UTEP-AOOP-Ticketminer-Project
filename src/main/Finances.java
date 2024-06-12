package main;
/**
 * Description: This class is a child class of the abstract parent class (Event). This class will inherit the attributes and method from the parent.
 * This class will be used to create appropriate objects (Festival) to hold specific data.
 * @author ESDT LLC
 * @since 11/15/2023
 */
public class Finances {
    
    //! Hold 
    private double salesTax = 0.0825;
    private double discount = 0.1;
    private double totalTax;
    private double subtotal;
    private double total;
    
    //! Holds set fee. 
    private double convenienceFee = 2.50;
    private double serviceFee = .005;
    private double charityFee = .0075;

    //! Holds the fee cost for each.
    private double totalConvenienceFee;
    private double totalServiceFee;
    private double totalCharityFee;
    private double totalFees;

    //! Holds discounted and taxed money.
    private double totalDiscounted;
    private double totalTaxed; 

    //! Store total fees for all events.
    private static double totalFeesForAllEvent;
    private static double totalCharityFeeForAllEvents;
    private static double totalServiceFeeForAllEvents;
    private static double totalConvenienceFeeForAllEvents;

    /**
     * Description: Default, Constructor for SalesTax class
     */
    public Finances() {
    }

    /**
     * Description: Get the SalesTax
     * @return The salesTax
     */
    public double getSalesTax() {
        return this.salesTax;
    }

    /**
     * Description: Set the SalesTax
     * @param salesTax Holds salesTax.
     */
    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    /**
     * Description: Get the Discount
     * @return The Discount.
     */
    public double getDiscount() {
        return this.discount;
    }

    /**
     * Description: Set the Discount
     * @param discount HOlds discount.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Description: Get the tax total.
     * @return The totalTax
     */
    public double getTotalTax() {
        return this.totalTax;
    }

    /**
     * Description: Set the tax total. 
     * @param totalTax Holds total tax.
     */
    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    /**
     * Description: Get the sub total
     * @return The subtotal
     */
    public double getSubtotal() {
        return this.subtotal;
    }

    /**
     * Description: Set the sub total
     * @param subtotal Holds sub total.
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Description: Get the total
     * @return The total
     */
    public double getTotal() {
        return this.total;
    }

    /**
     * Description: Set the total
     * @param total Holds total.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Description: Get the convenienceFee 
     * @return the convenienceFee 
     */
    public double getConvenienceFee() {
        return this.convenienceFee;
    }

    /**
     * Description: Set the convenienceFee 
     * @param convenienceFee Holds convenience fee amount
     */
    public void setConvenienceFee(double convenienceFee) {
        this.convenienceFee = convenienceFee;
    }

    /**
     * Description: get the service fee
     * @return the service fee
     */
    public double getServiceFee() {
        return this.serviceFee;
    }

    /**
     * Description: Set the service fee
     * @param serviceFee Holds service fee amount
     */
    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    /**
     * Description: Get the charity fee
     * @return the charity fee
     */
    public double getCharityFee() {
        return this.charityFee;
    }

    /**
     * Description: Set the charity fee
     * @param charityFee Holds charity fee amount
     */
    public void setCharityFee(double charityFee) {
        this.charityFee = charityFee;
    }

    /**
     * Description: Get the total convenience fee
     * @return the total convenience fee
     */
    public double getTotalConvenienceFee() {
        return this.totalConvenienceFee;
    }

    /**
     * Description: Set the total totalConvenienceFee 
     * @param totalConvenienceFee Holds total convenience fee amount
     */
    public void setTotalConvenienceFee(double totalConvenienceFee) {
        this.totalConvenienceFee = totalConvenienceFee;
    }

    /**
     * Description: Get the total service fee
     * @return the total service fee
     */
    public double getTotalServiceFee() {
        return this.totalServiceFee;
    }

    /**
     * Description: Set the total service fee
     * @param totalServiceFee holds total service fee amount
     */
    public void setTotalServiceFee(double totalServiceFee) {
        this.totalServiceFee = totalServiceFee;
    }
    
    /**
     * Description: Get the total charity fee
     * @return the total charity fee
     */
    public double getTotalCharityFee() {
        return this.totalCharityFee;
    }
    /**
     * Description: Set the total charity fee.
     * @param totalCharityFee holds total charity amount
     */
    public void setTotalCharityFee(double totalCharityFee) {
        this.totalCharityFee = totalCharityFee;
    }

    /**
     * Description: Get the total fee.
     * @return the total fee
     */
    public double getTotalFees() {
        return this.totalFees;
    }

    /**
     * Description: Set the total fee
     * @param totalFees holds total fees
     */
    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    /**
     * Description: Get the total discounted
     * @return the total discounted
     */
    public double getTotalDiscounted(){
        return this.totalDiscounted;
    }

    /**
     * Description: Set the total discounted
     * @param totalDiscounted Holds total discounted
     */
    public void setTotalDiscounted(double totalDiscounted){
        this.totalDiscounted = totalDiscounted;
    }

    /**
     * Description: Get the total taxed
     * @return the total taxed
     */
    public double getTotalTaxed(){
        return this.totalTaxed;
    }

    /**
     * Description: Set the total taxed
     * @param totalTaxed holds total taxed.
     */
    public void setTotalTaxed(double totalTaxed){
        this.totalTaxed = totalTaxed;
    }

    /**
     * Description: Get the total fees for all events
     * @return the total fees for all events
     */
    public static double getTotalFeesForAllEvent() {
        return totalFeesForAllEvent;
    }

    /**
     * Description: Set the total fees for all events
     * @param totalFeesForAllEvent holds total fees all together
     */
    public static void setTotalFeesForAllEvent(double totalFeesForAllEvent) {
        Finances.totalFeesForAllEvent = totalFeesForAllEvent;
    }

    /**
     * Description: Get the total charity fee for all events
     * @return the total charity fee for all events
     */
    public static double getTotalCharityFeeForAllEvents() {
        return totalCharityFeeForAllEvents;
    }

    /**
     * Description: Set the total charity fee for all events
     * @param totalCharityFeeForAllEvents holds total charity fees all together
     */
    public static void setTotalCharityFeeForAllEvents(double totalCharityFeeForAllEvents) {
        Finances.totalCharityFeeForAllEvents = totalCharityFeeForAllEvents;
    }

    /**
     * Description: Get the total service fee for all events
     * @return the total service fee for all events
     */
    public static double getTotalServiceFeeForAllEvents() {
        return totalServiceFeeForAllEvents;
    }

    /**
     * Description: Set the total service fee for all events
     * @param totalServiceFeeForAllEvents Holds total service fees all together
     */
    public static void setTotalServiceFeeForAllEvents(double totalServiceFeeForAllEvents) {
        Finances.totalServiceFeeForAllEvents = totalServiceFeeForAllEvents;
    }

    /**
     * Description: Get the total convenience fee for all events
     * @return the total convenience fee for all events
     */
    public static double getTotalConvenienceFeeForAllEvents() {
        return totalConvenienceFeeForAllEvents;
    }

    /**
     * Description: Set the total convenience fee for all events
     * @param totalConvenienceFeeForAllEvents holds total convenience fees all together
     */
    public static void setTotalConvenienceFeeForAllEvents(double totalConvenienceFeeForAllEvents) {
        Finances.totalConvenienceFeeForAllEvents = totalConvenienceFeeForAllEvents;
    }


    ///////////////
    /// METHODS///
    //////////////

    /**
     * Description: Calculate total.
     * @return The total = subtotal * (1 + salesTax)
     */
    public void calculateTotal() {
        this.total = this.subtotal * (1 + this.salesTax);
    }

    /**
     * Description: Calculate the total tax.
     * @return The totalTax += total - subtotal
     */
    public void calculateTotalTax() {
        this.totalTax += this.total - this.subtotal;
    }
    /**
     * Description: Calculate the charity fee.
     * @param ticketQuantity Holds amount of tickets.
     * @return The charity fee price.
     */
    public double calculateCharityFee(int ticketQuantity){
        return roundToTwoDecimal((ticketQuantity * (1 + getCharityFee())));
    }
    /**
     * Description: Calculate the service fee.
     * @param ticketQuantity Holds amount of tickets.
     * @return The service fee price.
     */
    public double calculateServiceFee(int ticketQuantity){
       return roundToTwoDecimal((ticketQuantity * (1 + getServiceFee())));
    }
    
    /**
     * Description: Do total, the charity fee, service, convenience fee.
     * @return The total price.
     */
    public double total() {

        double salesTotal = getSubtotal() * (1 + getSalesTax());
        setTotal(salesTotal);

        return this.total;
    }

    /**
     * Description: Do discount price.
     */
    public void discount() {
        setSubtotal(getSubtotal() * (1 - getDiscount()));
    }

    /**
     * Description: This method round the money.
     * @param value Holds the price.
     * @return The rounded price.
     */
    public double roundToTwoDecimal(double value) {
        int decimalPlaces = 2;
        double multiplier = Math.pow(10, decimalPlaces);
        return Math.ceil(value * multiplier) / multiplier;
    }
    
}
