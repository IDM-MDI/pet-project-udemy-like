package pet.by.ishangulyev.userservice.util.impl;

import pet.by.ishangulyev.userservice.entity.UserAuthentication;
import pet.by.ishangulyev.userservice.model.UserAuthenticationModel;
import pet.by.ishangulyev.userservice.util.ModelMapper;

import java.util.List;

public class AuthenticationMapper implements ModelMapper<UserAuthentication, UserAuthenticationModel> {
    @Override
    public UserAuthentication toEntity(UserAuthenticationModel model) {
        return model == null ?
                null :
                UserAuthentication.builder()
                        .login(model.getLogin())
                        .password(model.getPassword())
                        .build();
    }

    @Override
    public UserAuthenticationModel toModel(UserAuthentication entity) {
        return entity == null ?
                null :
                UserAuthenticationModel.builder()
                        .login(entity.getLogin())
                        .password(entity.getPassword())
                        .build();
    }

    @Override
    public List<UserAuthentication> toEntityList(List<UserAuthenticationModel> modelList) {
        return modelList == null ?
                null :
                modelList.stream()
                        .map(this::toEntity)
                        .toList();
    }

    @Override
    public List<UserAuthenticationModel> toModelList(List<UserAuthentication> entityList) {
        return entityList == null ?
                null :
                entityList.stream()
                        .map(this::toModel)
                        .toList();
    }
}
