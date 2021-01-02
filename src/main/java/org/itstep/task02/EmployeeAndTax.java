package org.itstep.task02;

import org.itstep.PaymentTypes;
import org.itstep.task01.Employee;

public class EmployeeAndTax extends Employee {

    protected int tax;

    public EmployeeAndTax(String fullName, String paymentType, double payment) {
        super(fullName, paymentType, payment);
        setPaymentType(paymentType);
    }

    public double getPaymentWithTax() {
        return getPayment() - getPayment()*tax/100.0;
    }

    @Override
    public void setPaymentType(String paymentType) {
        super.setPaymentType(paymentType);
        if (PaymentTypes.JOB_PRICE.equals(paymentType)){
            tax = 15;
        } else {
            tax = 20;
        }
    }

    public int getTax() {
        return tax;
    }
    @Override
    public String toString() {
        return  String.format(" %7s | %6d%% | %11s | %g", getFullName(), getTax(), getPayment(), getPaymentWithTax());
    }
}
