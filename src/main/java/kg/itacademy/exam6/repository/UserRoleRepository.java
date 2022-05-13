package kg.itacademy.exam6.repository;

import kg.itacademy.exam6.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
    @Query(value = "select * from user_roles", nativeQuery = true)
    List<UserRoleEntity> findAll ();
}
