package kg.itacademy.exam6.repository;

import kg.itacademy.exam6.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<ReportEntity, Long> {

    ReportEntity saveReport ( ReportEntity report );
}
