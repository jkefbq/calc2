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
public class RestController1 {

    private final SymbolInfoRepository repo1;
    private final CalculateService calcService;
    private final DbService dbService;

    @PostMapping("/processingRequest")
    public void calculateAndCreateOrUpdate(int a, int b, String sym) {
        String res = calcService.calculate(sym, a, b);
        if ((repo1.countBySymbol(sym) > 0) && (!res.equals("error"))) {
            dbService.updateRecord(res, sym, a, b);
            log.info("UPDATE");
        } else if (!res.equals("error")){
            dbService.createRecord(res, sym, a, b);
            log.info("CREATE");
        }
    }
}