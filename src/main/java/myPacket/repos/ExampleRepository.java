package myPacket.repos;

import myPacket.entity.Example;
import myPacket.entity.ExampleSymbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<Example, Integer> {


    Example findByExampleSymbol(ExampleSymbol exampleSymbol);
}
