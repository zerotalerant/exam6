package kg.itacademy.exam6.repository;

import kg.itacademy.exam6.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    @Query(value = "select nr.* from roles nr where nr.name_role = :roleName", nativeQuery = true)
    RoleEntity findFirstByNameRole ( String roleName );

    @Query(value = "select * from roles", nativeQuery = true)
    List<RoleEntity> findAll ();
}
