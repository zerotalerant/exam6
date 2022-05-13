package kg.itacademy.exam6.service.impl;

import com.cloudinary.Cloudinary;
import kg.itacademy.exam6.entity.ImageEntity;
import kg.itacademy.exam6.repository.ImageRepository;
import kg.itacademy.exam6.service.ImageService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.http.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageServiceImpl implements ImageService {

    static final String CLOUDINARY_URL = "cloudinary://953623852329234:f2WCsbx2_rVeTfRbaTHM67CAw-A@dattebayo";
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ImageEntity saveImage ( FileEntity imageEntity )
    {
        File file;
        try
        {
            file = Files.createTempFile ( System.currentTimeMillis () + "", imageEntity.getOriginalFilename ().
                    substring ( imageEntity.getOriginalFilename ().length () - 4 ) ).toFile ();
            imageEntity.transferTo ( file );

            Cloudinary cloudinary = new Cloudinary ( CLOUDINARY_URL );
            Map uploadResult = cloudinary.uploader ().upload ( file, emptyMap () );

            ImageEntity videos = ImageEntity.builder ()
                    .imageName ( imageEntity.getName () ).imageUrl ( ( String ) uploadResult.get ( "url" ) ).build ();

            return imageRepository.save ( videos );
        } catch (IOException e)
        {
            throw new RuntimeException ( e );
        }
    }

    @Override
    public Boolean deleteImage ( Long countryId )
    {
        return null;
    }

    @Override
    public ImageEntity getByName ( String countryName )
    {
        ImageEntity imageEntity = imageRepository.getByName ( countryName );
        if ( imageEntity == null )
        {
            throw new FileNotFoundException ( "Image not found!", HttpStatus.NOT_FOUND );
        }
        return ImageEntity.builder ()
                .imageName ( imageEntity.getImageName () )
                .imageUrl ( imageEntity.getImageUrl () )
                .build ();
    }

}

    @Override
    public List<ImageEntity> getAllImages ()
    {
        return imageRepository.findAll ();
    }
}
