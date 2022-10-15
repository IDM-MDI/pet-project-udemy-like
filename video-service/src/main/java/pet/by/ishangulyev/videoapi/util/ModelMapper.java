package pet.by.ishangulyev.videoapi.util;

import java.util.List;

public interface ModelMapper<E,D> {
    E toEntity(D model);
    D toModel(E entity);
    List<E> toEntityList(List<D> modelList);
    List<D> toModelList(List<E> entityList);
}
