package app.repositories;

import app.model.Donkey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonkeyRepository extends CrudRepository<Donkey, Long> {

    List<Donkey> findByName(String name);
    List<Donkey> findByAge(int age);
    List<Donkey> findByTemper(String temper);
    @Query("select donkey from Donkey donkey where donkey.name = :name and donkey.age = :age and donkey.temper = :temper")
    List<Donkey> findByTheNameTheAgeAndTheTemper(@Param("name") String name, @Param("age") int age, @Param("temper") String temper);
    List<Donkey> findByNameAndAgeAndTemper(String name, int age, String temper);
}
