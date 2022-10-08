package pet.by.ishangulyev.videoapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pet.by.ishangulyev.videoapi.entity.Video;

@Repository
public interface VideoRepository extends MongoRepository<Video,String> {
}
