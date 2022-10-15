package pet.by.ishangulyev.userservice.util.impl;

import org.springframework.stereotype.Component;
import pet.by.ishangulyev.userservice.entity.ContactInfo;
import pet.by.ishangulyev.userservice.model.ContactInfoModel;
import pet.by.ishangulyev.userservice.util.ModelMapper;

import java.util.List;

@Component
public class ContactInfoMapper implements ModelMapper<ContactInfo, ContactInfoModel> {

    @Override
    public ContactInfo toEntity(ContactInfoModel model) {
        return model == null ? null : ContactInfo.builder()
                .email(model.getEmail())
                .phone(model.getPhone())
                .build();
    }

    @Override
    public ContactInfoModel toModel(ContactInfo entity) {
        return entity == null ? null : ContactInfoModel.builder()
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .build();
    }

    @Override
    public List<ContactInfo> toEntityList(List<ContactInfoModel> modelList) {
        return modelList == null ?
                null
                :
                modelList.stream()
                        .map(this::toEntity)
                        .toList();
    }

    @Override
    public List<ContactInfoModel> toModelList(List<ContactInfo> entityList) {
        return entityList == null ?
                null
                :
                entityList.stream()
                        .map(this::toModel)
                        .toList();
    }
}
