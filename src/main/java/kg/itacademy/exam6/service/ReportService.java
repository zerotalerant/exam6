package kg.itacademy.exam6.service;

import kg.itacademy.exam6.entity.ReportEntity;
import kg.itacademy.exam6.model.ReportModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {
    ReportEntity saveReport ( ReportEntity entity );

    List<ReportModel> showAll ();
}
