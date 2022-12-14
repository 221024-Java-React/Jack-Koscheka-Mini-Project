package com.revature.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private void formatItem(String item)
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Character.toUpperCase(item.charAt(0)));

        for (int index = 1; index < item.length(); index++)
            stringBuilder.append(Character.toLowerCase(item.charAt(index)));

        final int lastIndex = item.length() - 1;

        if (stringBuilder.charAt(lastIndex) == 's')
            stringBuilder.deleteCharAt(lastIndex);
        
        item = stringBuilder.toString();
    }

    @GetMapping("/add/{item}")
    public String getStatusMessage(@PathVariable String item, @RequestParam(required = false) String quantity)
    {
        formatItem(item);

        int amount;

        try {
            amount = Integer.parseInt(quantity);
        } catch (Exception e) {
            amount = 1;
        }

        return "Adding " + amount + " " + item + ((amount > 1) ? "s" : "") + " to list";
    }
    
}
