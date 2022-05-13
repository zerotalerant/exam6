package kg.itacademy.exam6.service.impl;

import kg.itacademy.exam6.entity.ReportEntity;
import kg.itacademy.exam6.model.ReportModel;
import kg.itacademy.exam6.repository.ReportsRepository;
import kg.itacademy.exam6.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    ReportsRepository reportsRepository;

    @Override
    public ReportEntity saveReport ( ReportEntity entity )
    {
        if ( entity == null )
        {
            throw new RuntimeException ( "Reports are null" );
        } else if ( entity.getReports () == null )
        {
            throw new RuntimeException ( "Reports can't be null" );
        }
        ReportEntity report = new ReportEntity ();
        report.setReports ( entity.getReports () );

        report = reportsRepository.saveReport ( report );

        entity.setId ( report.getId () );

        return entity;
    }

    @Override
    public List<ReportModel> showAll ()
    {
        List<ReportEntity> reportList = reportsRepository.findAll ();
        List<ReportModel> reportModelList = new ArrayList<> ();
        for (ReportEntity report : reportList)
        {
            ReportModel reportModel = new ReportModel ();
            reportModel.setReportId ( report.getId () );
            reportModel.setReportName ( report.getReports () );
            reportModelList.add ( reportModel );
        }
        return reportModelList;
    }
}
