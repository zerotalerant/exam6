package kg.itacademy.exam6.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryModel {
    private Long id;
    private String countryName;
    private String alphaCode;
    private Long countryCode;
    private String countryLanguage;
    private Long countryPopulation;
    private Boolean isActive;
}
