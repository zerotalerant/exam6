package kg.itacademy.exam6.repository;

import kg.itacademy.exam6.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    @Query(value = "select * from countries", nativeQuery = true)
    List<CountryEntity> findAll ();


    CountryEntity getByNameOrAlhpacode ( String nameOrAlhpacode );
}
