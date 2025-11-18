package myPacket.repos;

import myPacket.entity.CalcInfo;
import myPacket.entity.SymbolInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcInfoRepository extends JpaRepository<CalcInfo, Integer> {

    CalcInfo findBySymbolInfo(SymbolInfo symbolInfo);
}
