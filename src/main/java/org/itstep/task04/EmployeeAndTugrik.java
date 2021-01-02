package org.itstep.task04;

import org.itstep.PaymentTypes;
import org.itstep.task03.EmployeeAndChild;

public class EmployeeAndTugrik extends EmployeeAndChild {

    private int tugrikExchange;

    public EmployeeAndTugrik(String fullName, String paymentType, double payment) {
        super(fullName, paymentType, payment);
    }

    public EmployeeAndTugrik(String fullName, String paymentType, double payment, boolean hasChild) {
        super(fullName, paymentType, payment, hasChild);
    }

    public int getTugrikExchange() {
        return tugrikExchange;
    }

    public void setTugrikExchange(int tugrikExchange) {
        this.tugrikExchange = tugrikExchange;
    }

    @Override
    public String toString() {
        if (PaymentTypes.HOURLY.equals(getPaymentType())){
            double halfPayment = getPaymentWithTax()/2;
            return  String.format(" %7s | %6d%% | %11s | %g / %g", getFullName(), getTax(), getPayment(), halfPayment, halfPayment/getTugrikExchange());
        } else
        return super.toString();
    }
}
