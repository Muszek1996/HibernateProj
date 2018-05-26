package DataManipulators.CrudRepo;

import Entity.PlayerEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity,Long> {
    @Query(value = "SELECT * FROM player where player.accountValue BETWEEN :value1 AND :value2", nativeQuery = true)
    List<PlayerEntity> findPlayerWithAccountValueInRange(@Param("value1") double value1, @Param("value2") double value2) ;
}

