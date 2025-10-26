package myPacket.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import myPacket.entity.ExampleSymbol;
import myPacket.entity.Example;
import myPacket.repos.ExampleSymbolRepository;
import myPacket.repos.ExampleRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DbService {

    private final ExampleSymbolRepository repo1;
    private final ExampleRepository repo2;

    @Transactional
    public void createRecord(String res, String sym, int a, int b) {
        repo2.save(new Example(a, b, res, repo1.save(new ExampleSymbol(sym))));
        System.out.println("CREATE");
    }

    @Transactional
    public void updateRecord(String res, String sym, int a, int b) {
        ExampleSymbol exSym = repo1.findBySymbol(sym);
        Example ex = repo2.findByExampleSymbol(exSym);
        Example.updateExample(ex, res, a, b);
        repo2.save(ex);
        System.out.println("UPDATE");
    }
}