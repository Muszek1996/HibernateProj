package DataManipulators.CrudRepo;

import Entity.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<GameEntity,Long> {
    List<GameEntity> findByNameContainingOrderByLastNameDesc(String toFind);
    List<GameEntity> findByNameContainingOrderByLastNameAsc(String toFind);
}
