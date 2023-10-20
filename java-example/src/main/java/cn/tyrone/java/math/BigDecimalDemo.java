package cn.tyrone.java.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalDemo {



    public static void main(String[] args) {
        BigDecimal accountBalance = new BigDecimal(100);
        BigDecimal paymentAmount = BigDecimal.TEN;

        // 加法
        BigDecimal add = accountBalance.add(paymentAmount);
        // 减法
        BigDecimal subtract = accountBalance.subtract(paymentAmount);
        // 乘法
        BigDecimal multiply = accountBalance.multiply(paymentAmount);
        // 除法
        BigDecimal divide = accountBalance.divide(paymentAmount);
        BigDecimal divide1 = accountBalance.divide(paymentAmount, 2, RoundingMode.DOWN);

        /**
         * compareTo = 1, accountBalance > paymentAmount
         * compareTo = 0, accountBalance = paymentAmount
         * compareTo = -1, accountBalance < paymentAmount
         */
        int compareTo = accountBalance.compareTo(paymentAmount);
        System.out.println(compareTo);

    }

}
