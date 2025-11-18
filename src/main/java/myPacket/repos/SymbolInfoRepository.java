package myPacket.repos;

import myPacket.entity.SymbolInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolInfoRepository extends JpaRepository<SymbolInfo, Integer> {

    int countBySymbol(String symbol);

    SymbolInfo findBySymbol(String symbol);
}