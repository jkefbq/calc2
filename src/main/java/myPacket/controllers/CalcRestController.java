package myPacket.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myPacket.repos.SymbolInfoRepository;
import myPacket.service.CalculateService;
import myPacket.service.DbService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class CalcRestController {

    private final SymbolInfoRepository symInfoRepo;
    private final CalculateService calcService;
    private final DbService dbService;

    @PostMapping("/processingRequest")
    public void calculateAndCreateOrUpdate(int num1, int num2, String sym) {
        int res = calcService.calculate(sym, num1, num2);

        if (symInfoRepo.countBySymbol(sym) > 0) {
            log.warn("try update record");
            dbService.updateRecord(res, sym, num1, num2);
            log.info("Update record was successful");
        } else {
            log.warn("try create record");
            dbService.createRecord(res, sym, num1, num2);
            log.info("Create record was successful");
        }
    }
}