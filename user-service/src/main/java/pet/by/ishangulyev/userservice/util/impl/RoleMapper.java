package pet.by.ishangulyev.userservice.util.impl;

import org.springframework.stereotype.Component;
import pet.by.ishangulyev.userservice.entity.Role;
import pet.by.ishangulyev.userservice.model.RoleModel;
import pet.by.ishangulyev.userservice.util.ModelMapper;

import java.util.List;

@Component
public class RoleMapper implements ModelMapper<Role, RoleModel> {
    @Override
    public Role toEntity(RoleModel model) {
        return model == null ?
                null
                :
                Role.builder()
                        .name(model.getName())
                        .build();
    }

    @Override
    public RoleModel toModel(Role entity) {
        return entity == null ?
                null
                :
                RoleModel.builder()
                        .name(entity.getName())
                        .build();
    }

    @Override
    public List<Role> toEntityList(List<RoleModel> modelList) {
        return modelList == null ?
                null
                :
                modelList.stream()
                        .map(this::toEntity)
                        .toList();
    }

    @Override
    public List<RoleModel> toModelList(List<Role> entityList) {
        return entityList == null ?
                null
                :
                entityList.stream()
                        .map(this::toModel)
                        .toList();
    }
}
