package kg.itacademy.exam6.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "images")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageEntity extends BaseEntity {

    @Column(name = "image_name", nullable = false)
    String imageName;

    @Column(name = "image_url", nullable = false, unique = true)
    String imageUrl;
}