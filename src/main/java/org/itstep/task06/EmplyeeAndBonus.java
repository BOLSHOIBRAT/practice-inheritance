package org.itstep.task06;

import org.itstep.PaymentTypes;
import org.itstep.task04.EmployeeAndTugrik;

public class EmplyeeAndBonus extends EmployeeAndTugrik {

    private  int workHours;
    private double payment;

    public EmplyeeAndBonus(String fullName, String paymentType, double payment) {
        super(fullName, paymentType, payment);
    }

    public EmplyeeAndBonus(String fullName, String paymentType, double payment, boolean hasChild, int workHours) {
        super(fullName, paymentType, payment, hasChild);
        setWorkHours(getWorkHours());
        setHasChild(isHasChild());
    }

    public int getWorkHours() {
        return workHours;
    }

    public int setWorkHours(int workHours) {
        this.workHours = workHours;
        if (workHours >= 200) {
            payment = payment + (payment * 0.2);
        }
        return workHours;
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
