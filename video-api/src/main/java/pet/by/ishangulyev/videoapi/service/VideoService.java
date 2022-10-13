package pet.by.ishangulyev.videoapi.service;

import pet.by.ishangulyev.videoapi.exception.VideoException;

public interface VideoService<E,D> {
    E findByID(String id) throws VideoException;
    boolean isEntityExist(String id);
    void delete(String id) throws VideoException;
}
