package myPacket.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myPacket.builders.classes.CalcInfoBuilder;
import myPacket.entity.CalcInfo;
import myPacket.entity.SymbolInfo;
import myPacket.repos.CalcInfoRepository;
import myPacket.repos.SymbolInfoRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DbService {

    private final SymbolInfoRepository symInfoRepo;
    private final CalcInfoRepository calcInfoRepo;

    @Transactional
    public void createRecord(String res, String sym, int num1, int num2) {
        calcInfoRepo.save(
                new CalcInfo(num1, num2, res, symInfoRepo.save(new SymbolInfo(sym)))
        );
    }

    @Transactional
    public void updateRecord(String res, String sym, int num1, int num2) {
        SymbolInfo symInfo = symInfoRepo.findBySymbol(sym);
        CalcInfo calcInfo = calcInfoRepo.findBySymbolInfo(symInfo);
        calcInfoRepo.save(
                new CalcInfoBuilder(calcInfo)
                        .setNum1(num1)
                        .setNum2(num2)
                        .setResult(res)
                        .getCalcInfo()
        );
    }
}