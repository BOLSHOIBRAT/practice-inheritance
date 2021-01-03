package org.itstep.task05;

import org.itstep.PaymentTypes;
import org.itstep.task04.EmployeeAndTugrik;

public class EmployeeAndOffshore extends EmployeeAndTugrik {

    private boolean inOffshore;

    public EmployeeAndOffshore(String fullName, String paymentType, double payment) {
        super(fullName, paymentType, payment);
    }

    public EmployeeAndOffshore(String fullName, String paymentType, double payment, boolean hasChild) {
        this(fullName, paymentType, payment, false, false);
    }

    public EmployeeAndOffshore(String fullName, String paymentType, double payment, boolean hasChild, boolean inOffshore) {
        super(fullName, paymentType, payment, false);
        setInOffshore(inOffshore);
    }

    public boolean isInOffshore() {
        return inOffshore;
    }

    public void setInOffshore(boolean inOffshore) {
        this.inOffshore = inOffshore;
        if (inOffshore == true) {
            tax = 0;
        } else tax = 20;
    }

    @Override
    public String toString() {
        if (PaymentTypes.HOURLY.equals(getPaymentType())) {
            double halfPayment = getPaymentWithTax() / 2;
            return String.format(" %7s | %6d%% | %11s | %g / %g", getFullName(), getTax(), getPayment(), halfPayment, halfPayment / getTugrikExchange());
        } else
            return super.toString();
    }
}