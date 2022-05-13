package kg.itacademy.exam6.controller;

import kg.itacademy.exam6.entity.CountryEntity;
import kg.itacademy.exam6.entity.ReportEntity;
import kg.itacademy.exam6.exceptions.UserNotFoundException;
import kg.itacademy.exam6.model.CountryModel;
import kg.itacademy.exam6.service.CountryService;
import kg.itacademy.exam6.service.ImageService;
import kg.itacademy.exam6.service.ReportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1/country")
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CountryController {


    final CountryService countryService;

    final ImageService imageService;

    final ReportService reportService;

    //Создание страны
    @PostMapping(path = "/create")
    public ResponseEntity<CountryModel> createCountry ( @RequestBody CountryModel countryModel )
    {
        CountryModel createdCountry = countryService.createNewCountry ( countryModel );
        if ( createdCountry.getId () != null )
        {
            return ResponseEntity.status ( HttpStatus.CREATED ).body ( createdCountry );
        } else
        {
            return ResponseEntity
                    .status ( HttpStatus.INTERNAL_SERVER_ERROR )
                    .body ( null );
        }
    }

    //Вытащить по id
    @GetMapping(path = "/get/{countryId}")
    public ResponseEntity<CountryModel> getCountryById ( @PathVariable("countryId") Long countryId )
    {
        try
        {
            return ResponseEntity.ok ( countryService.getCountryById ( countryId ) );
        } catch (UserNotFoundException ex)
        {
            log.error ( ex.getMessage (), ex );
            return ResponseEntity
                    .status ( HttpStatus.INTERNAL_SERVER_ERROR )
                    .body ( null );
        }
    }

    //Удалить по id
    @GetMapping(path = "/delete/{countryId}")
    public ResponseEntity<Boolean> deleteCountryById ( @PathVariable("countryId") Long countryId )
    {
        try
        {
            return ResponseEntity.ok ( countryService.deleteCountryById ( countryId ) );
        } catch (UserNotFoundException ex)
        {
            log.error ( ex.getMessage (), ex );
            return ResponseEntity
                    .status ( HttpStatus.INTERNAL_SERVER_ERROR )
                    .body ( null );
        }
    }

    //Обновление
    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateCountry ( @RequestBody CountryModel countryModel )
    {
        try
        {
            countryService.updateCountry ( countryModel );
            return ResponseEntity.ok ( true );
        } catch (UserNotFoundException ex)
        {

            log.error ( ex.getMessage (), ex );
            return ResponseEntity
                    .status ( HttpStatus.INTERNAL_SERVER_ERROR )
                    .body ( null );
        }
    }

    //Вытащить всех
    @GetMapping(path = "/get/all-countries")
    public List<CountryModel> getAllCounties ()
    {
        return countryService.getAllCounties ();
    }

    @PostMapping("/search")
    public CountryEntity searchCountry ( String nameOrAlhpa )
    {
        return countryService.getByNameOrAlhpacode ( nameOrAlhpa );
    }

    @GetMapping("/reports")
    public List<ReportEntity> getAllReports ()
    {
        return reportService.showAll ();
    }

}
