package kg.itacademy.exam6.service.impl;

import kg.itacademy.exam6.entity.CountryEntity;
import kg.itacademy.exam6.exceptions.*;
import kg.itacademy.exam6.model.CountryModel;
import kg.itacademy.exam6.repository.CountryRepository;
import kg.itacademy.exam6.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;


    @Override
    public CountryModel createNewCountry ( CountryModel countryModel )
    {
        if ( countryModel == null )
        {
            throw new CountryIsNullException ( "Country is null" );
        } else if ( countryModel.getId () == null || countryModel.getId ().equals ( "" ) )
        {
            throw new IdIsNullException ( "Id is null" );
        } else if ( countryModel.getCountryName () == null || countryModel.getCountryName ().equals ( "" ) )
        {
            throw new CountryNameIsNullException ( "Country name is null" );
        } else if ( countryModel.getCountryCode () == null || countryModel.getCountryCode ().equals ( "" ) )
        {
            throw new CountryCodeIsNullException ( "Country code is null" );
        } else if ( countryModel.getAlphaCode () == null || countryModel.getAlphaCode ().equals ( "" ) )
        {
            throw new AlphaCodeIsNullException ( "Alpha code is null" );
        } else if ( countryModel.getCountryLanguage () == null || countryModel.getCountryLanguage ().equals ( "" ) )
        {
            throw new CountryLanguageIsNullException ( "Country language is null" );
        } else if ( countryModel.getCountryPopulation () == null || countryModel.getCountryPopulation ().equals ( "" ) )
        {
            throw new CountryPopulationIsNullException ( "Country population is null" );
        } else if ( countryModel.getIsActive () == null || countryModel.getIsActive ().equals ( "" ) )
        {
            throw new IsActiveIsNullException ( "Field 'isActive' is null" );
        }

        CountryEntity country = new CountryEntity ();
        country.setCountryName ( countryModel.getCountryName () );
        country.setAlphaCode ( countryModel.getAlphaCode () );
        country.setCountryCode ( countryModel.getCountryCode () );
        country.setCountryLanguage ( countryModel.getCountryLanguage () );
        country.setCountryPopulation ( countryModel.getCountryPopulation () );

        country = countryRepository.save ( country );

        countryModel.setId ( country.getId () );

        return countryModel;
    }

    @Override
    public Boolean deleteCountryById ( Long countryId )
    {
        if ( !countryRepository.existsById ( countryId ) )
        {
            throw new CountryNotFoundException ( "Country not found by id" + countryId );
        }
        countryRepository.deleteById ( countryId );

        return true;
    }

    @Override
    public CountryModel getCountryById ( Long countryId )
    {
        if ( countryId == null )
        {
            throw new IdIsNullException ( "Country id is null" );
        }

        CountryEntity countryEntity = countryRepository.getById ( countryId );

        if ( countryEntity == null )
        {
            throw new IdNotFoundException ( "Country with id " + countryId + " not found" );
        }

        CountryModel countryModel = new CountryModel ();
        countryModel.setId ( countryEntity.getId () );
        countryModel.setCountryName ( countryEntity.getCountryName () );
        countryModel.setAlphaCode ( countryEntity.getAlphaCode () );
        countryModel.setCountryCode ( countryEntity.getCountryCode () );
        countryModel.setCountryLanguage ( countryEntity.getCountryLanguage () );
        countryModel.setCountryPopulation ( countryEntity.getCountryPopulation () );

        return countryModel;
    }

    @Override
    public CountryEntity getByNameOrAlhpacode ( String nameOrAlhpacode )
    {
        CountryEntity nameOrAlhpa = countryRepository.getByNameOrAlhpacode ( nameOrAlhpacode );
        if (nameOrAlhpa != null) {
            return CountryEntity.builder ().countryName(nameOrAlhpa.getCountryName ())
                    .countryCode ( nameOrAlhpa.getCountryCode () )
                    .alphaCode ( nameOrAlhpa.getAlphaCode () )
                    .countryLanguage ( nameOrAlhpa.getCountryLanguage () )
                    .countryPopulation ( nameOrAlhpa.getCountryPopulation () ).build();
        }
        return null;
    }

    @Override
    public List<CountryModel> getAllCounties ()
    {
        List<CountryEntity> countryEntityList = countryRepository.findAll ();
        List<CountryModel> countryModelList = new ArrayList<> ();
        for (CountryEntity country : countryEntityList)
        {
            CountryModel countryModel = new CountryModel ();
            countryModel.setId ( country.getId () );
            countryModel.setCountryName ( country.getCountryName () );
            countryModel.setAlphaCode ( country.getAlphaCode () );
            countryModel.setCountryCode ( country.getCountryCode () );
            countryModel.setCountryLanguage ( country.getCountryLanguage () );
            countryModel.setCountryPopulation ( country.getCountryPopulation () );


            countryModelList.add ( countryModel );
        }
        return countryModelList;
    }

    @Override
    public Boolean updateCountry ( CountryModel countryModel )
    {
        if ( countryModel == null )
        {
            throw new CountryIsNullException ( "Country is null" );
        } else if ( countryModel.getId () == null || countryModel.getId ().equals ( "" ) )
        {
            throw new IdIsNullException ( "Country id can't be null" );
        } else if ( countryModel.getCountryName () == null || countryModel.getCountryName ().equals ( "" ) )
        {
            throw new CountryNameIsNullException ( "Country name can't be null" );
        } else if ( countryModel.getCountryCode () == null || countryModel.getCountryCode ().equals ( "" ) )
        {
            throw new CountryCodeIsNullException ( "Country code can't be null" );
        } else if ( countryModel.getAlphaCode () == null || countryModel.getAlphaCode ().equals ( "" ) )
        {
            throw new AlphaCodeIsNullException ( "Alpha code can't be null" );
        } else if ( countryModel.getCountryLanguage () == null || countryModel.getCountryLanguage ().equals ( "" ) )
        {
            throw new CountryLanguageIsNullException ( "Country language can't be null" );
        } else if ( countryModel.getCountryPopulation () == null || countryModel.getCountryPopulation ().equals ( "" ) )
        {
            throw new CountryPopulationIsNullException ( "Country population can't be null" );
        } else if ( countryModel.getIsActive () == null || countryModel.getIsActive ().equals ( "" ) )
        {
            throw new IsActiveIsNullException ( "Field 'isActive' can't be null" );
        }

        CountryEntity existCountry = countryRepository.getById ( countryModel.getId () );
        if ( existCountry == null )
        {

            throw new CountryNotFoundException ( "Country by id " + countryModel.getId () + "doesn't exist" );
        }

        existCountry.setCountryName ( countryModel.getCountryName () );
        existCountry.setAlphaCode ( countryModel.getAlphaCode () );
        existCountry.setCountryCode ( countryModel.getCountryCode () );
        existCountry.setCountryLanguage ( countryModel.getCountryLanguage () );
        existCountry.setCountryPopulation ( countryModel.getCountryPopulation () );

        existCountry = countryRepository.save ( existCountry );

        return true;
    }
}