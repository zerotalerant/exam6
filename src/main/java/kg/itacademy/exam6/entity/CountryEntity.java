package kg.itacademy.exam6.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity extends BaseEntity {

    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;

    @Column(name = "alpha_code", nullable = false, unique = true)
    private String alphaCode;

    @Column(name = "country_code", nullable = false, unique = true)
    private Long countryCode;

    @Column(name = "country_language", nullable = false)
    private String countryLanguage;

    @Column(name = "country_population", nullable = false)
    private Long countryPopulation;

}
