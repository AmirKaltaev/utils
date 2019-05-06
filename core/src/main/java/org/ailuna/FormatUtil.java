package org.ailuna;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatUtil {

    public static String capitalizeFirstLetter(String string){
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

    public static String formatAmountString(double amount, @NonNull String currencyCode){
        return formatAmount(amount) + " " + formatCurrency(currencyCode);
    }

    public static String formatAmountString(@NonNull BigDecimal amount, @NonNull String currencyCode){
        return formatAmount(amount.doubleValue()) + " " + formatCurrency(currencyCode);
    }

    public static String formatAmountString(@NonNull BigDecimal amount){
        return formatAmount(amount.doubleValue());
    }

    public static String formatPercentString(float value){
        return value + "%";
    }

    private static String formatCurrency(String currencyCode){
        if (currencyCode.toLowerCase().equals(BasicConstans.CurrencyCode.USD))
            return "\u0024";
        else if (currencyCode.toLowerCase().equals(BasicConstans.CurrencyCode.EUR))
            return "\u20AC";
        else if (currencyCode.toLowerCase().equals(BasicConstans.CurrencyCode.KZT))
            return "\u20B8";
        else if (currencyCode.toLowerCase().equals(BasicConstans.CurrencyCode.RUB))
            return "\u20BD";
        else if (currencyCode.toLowerCase().equals(BasicConstans.CurrencyCode.GBP))
            return "\u00A3";
        else
            return currencyCode;
    }

    private static String formatAmount(double amount) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);

        return formatter.format(amount);
    }
}
