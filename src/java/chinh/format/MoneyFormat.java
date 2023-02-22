/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinh.format;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author tramy
 */
public class MoneyFormat {

    public String formatMoney(int price) {

        Locale locale = new Locale("vi", "VN");

        DecimalFormat format= (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);

        DecimalFormatSymbols formatSymbols= new DecimalFormatSymbols();
        
        formatSymbols.setGroupingSeparator('.');
        formatSymbols.setCurrencySymbol("VND");
        format.setDecimalFormatSymbols(formatSymbols);
        
        String afterString= format.format(price);
        return afterString;
    }
    public String formatMoney2(double price) {

        Locale locale = new Locale("vi", "VN");

        DecimalFormat format= (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);

        DecimalFormatSymbols formatSymbols= new DecimalFormatSymbols();
        
        formatSymbols.setGroupingSeparator('.');
        formatSymbols.setCurrencySymbol("VND");
        format.setDecimalFormatSymbols(formatSymbols);
        
        String afterString= format.format(price);
        return afterString;
    }

    public static void main(String[] args) {
        MoneyFormat fm = new MoneyFormat();
        String foString = fm.formatMoney(131000);
        System.out.println(foString);
    }
}
