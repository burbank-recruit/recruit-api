package com.burbank.recruit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class CatalogueController {

    @GetMapping(path = "/catalogue")
    public @ResponseBody List<CatalogueItem> getCatalogueItems() {
        return Arrays.asList(
                new CatalogueItem("Front End Developer", "Lead Front End Developer"),
                new CatalogueItem("Front End Developer", "Senior Front End Developer"),
                new CatalogueItem("Front End Developer", "Associate Front End Developer"),
                new CatalogueItem("Business Analyst", "Lead Business Analyst"),
                new CatalogueItem("Business Analyst", "Senior Business Analyst"));
    }

}
