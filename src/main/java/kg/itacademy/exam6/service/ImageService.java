package kg.itacademy.exam6.service;

import kg.itacademy.exam6.entity.ImageEntity;
import org.apache.http.entity.FileEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
    ImageEntity saveImage ( FileEntity entityVideos );

    Boolean deleteImage(Long countryId);

    ImageEntity getByName (String countryName);

    List<ImageEntity> getAllImages ();

}
