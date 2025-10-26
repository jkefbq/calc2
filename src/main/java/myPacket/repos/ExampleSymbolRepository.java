package myPacket.repos;

import myPacket.entity.ExampleSymbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleSymbolRepository extends JpaRepository<ExampleSymbol, Integer> {

    int countBySymbol(String symbol);

    ExampleSymbol findBySymbol(String symbol);
}