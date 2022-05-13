package kg.itacademy.exam6.controller;

import kg.itacademy.exam6.entity.ImageEntity;
import kg.itacademy.exam6.service.ImageService;
import org.apache.http.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping
    public ImageEntity saveImage ( MultipartFile file )
    {
        return imageService.saveImage ( ( FileEntity ) file );
    }

    @GetMapping
    public List<ImageEntity> getAllImages ()
    {
        return imageService.getAllImages ();
    }
}