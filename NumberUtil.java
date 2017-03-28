package com.migu.reconciliation.utils;

import java.math.BigDecimal;

public class NumberUtil {
	public static double round(Double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = (null == v ? new BigDecimal("0.0") : new BigDecimal(Double.toString(v)));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
	
	public static int compareTo(BigDecimal budget,int divisor,BigDecimal _compareValue){
		if(divisor==0){
			divisor = 1;
		}
		return budget.divide(new BigDecimal(divisor),2, BigDecimal.ROUND_HALF_EVEN).compareTo(_compareValue);
	}
	
	public static void main(String[] args) {
		int it = NumberUtil.compareTo(new BigDecimal(5000000), 1, new BigDecimal(5000000));
		System.out.println(it);
	}
	
}
