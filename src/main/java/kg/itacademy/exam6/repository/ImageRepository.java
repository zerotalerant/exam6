package kg.itacademy.exam6.repository;

import kg.itacademy.exam6.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    @Query(value = "select * from images", nativeQuery = true)
    List<ImageEntity> findAll ();

    @Query(value = "select c.* from countries c where c.country_name = :countryName", nativeQuery = true)
    ImageEntity getByName ( String countryName );
}
