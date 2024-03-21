package org.example.RepositoryLayer;

import org.example.Entites.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositoryImp extends MongoRepository<UserEntity, String> {
    @Override
    List<UserEntity> findAll();

    @Override
    Optional<UserEntity> findById(String s);

    @Override
    void delete(UserEntity entity);
    @Override
    void deleteAllById(Iterable<? extends String> strings);
    //    @Query(value="{'id' : $0}", delete = true)
//    void deleteById (String id);


}
