package kg.itacademy.exam6.repository;

import kg.itacademy.exam6.entity.UserEntity;
import kg.itacademy.exam6.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "select u.* from users u where u.user_login = :FindUserByLoginAndPassword or u.user_password = :FindUserByLoginAndPassword", nativeQuery = true)
    UserEntity FindUserByLoginPassword ( String findUserByLoginAndPassword );

    @Query(value = "select u.* from users u where u.user_login = :login", nativeQuery = true)
    UserEntity getUserByLogin ( String login );

    @Query(value = "select * from users", nativeQuery = true)
    List<UserModel> getAllUsers ();
}
