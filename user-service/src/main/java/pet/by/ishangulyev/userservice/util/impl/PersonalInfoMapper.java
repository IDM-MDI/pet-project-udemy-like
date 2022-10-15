package pet.by.ishangulyev.userservice.util.impl;

import pet.by.ishangulyev.userservice.entity.PersonalInfo;
import pet.by.ishangulyev.userservice.model.PersonalInfoModel;
import pet.by.ishangulyev.userservice.util.ModelMapper;

import java.util.List;


public class PersonalInfoMapper implements ModelMapper<PersonalInfo, PersonalInfoModel> {

    @Override
    public PersonalInfo toEntity(PersonalInfoModel model) {
        return model == null ?
                null
                :
                PersonalInfo.builder()
                        .name(model.getName())
                        .surname(model.getSurname())
                        .lastname(model.getLastname())
                        .date(model.getDate())
                        .build();
    }

    @Override
    public PersonalInfoModel toModel(PersonalInfo entity) {
        return entity == null ?
                null
                :
                PersonalInfoModel.builder()
                        .name(entity.getName())
                        .surname(entity.getSurname())
                        .lastname(entity.getLastname())
                        .date(entity.getDate())
                        .build();
    }

    @Override
    public List<PersonalInfo> toEntityList(List<PersonalInfoModel> modelList) {
        return modelList == null ?
                null
                :
                modelList.stream()
                        .map(this::toEntity)
                        .toList();
    }

    @Override
    public List<PersonalInfoModel> toModelList(List<PersonalInfo> entityList) {
        return entityList == null ?
                null
                :
                entityList.stream()
                        .map(this::toModel)
                        .toList();
    }
}
