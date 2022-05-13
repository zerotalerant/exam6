package kg.itacademy.exam6.service;

import kg.itacademy.exam6.entity.CountryEntity;
import kg.itacademy.exam6.model.CountryModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryService {

    CountryModel createNewCountry ( CountryModel countryModel );

    Boolean deleteCountryById ( Long countryId );

    CountryModel getCountryById ( Long countryId );

    CountryEntity getByNameOrAlhpacode ( String nameOrAlhpacode );

    List<CountryModel> getAllCounties ();

    Boolean updateCountry ( CountryModel countryModel );

}
