package com.revature.app.models;

import lombok.Getter;

@Getter
public class Price {
    
    private long dollars;
    private byte cents;

    Price(String amount)
    {
        int index = amount.indexOf('.');

        if (index >= 0)
            cents = Byte.parseByte(amount.substring(index + 1, amount.length()));
        else
            index = amount.length();

        dollars = Integer.parseInt(amount.substring(0, index));
    }
}
