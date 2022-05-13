package kg.itacademy.exam6.controller;

import kg.itacademy.exam6.entity.RoleEntity;
import kg.itacademy.exam6.model.RoleModel;
import kg.itacademy.exam6.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleController {
    final RoleRepository roleRepository;

    @PostMapping("/create")
    public String createRole ( @RequestBody RoleModel roleModel )
    {
        RoleEntity role = new RoleEntity ();
        role.setNameRole ( roleModel.getName () );
        return roleRepository.save ( role ).getNameRole ();
    }

}