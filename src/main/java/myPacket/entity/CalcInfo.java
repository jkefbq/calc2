package myPacket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "calc_info")
@Getter
@Setter
@NoArgsConstructor
public class CalcInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "symbol_info_id")
    private SymbolInfo symbolInfo;

    @Column(name = "num_1")
    private int num1;
    @Column(name = "num_2")
    private int num2;
    private int result;

    public CalcInfo(int num1, int num2, int result, SymbolInfo symbolInfo) {
        this.num2 = num2;
        this.num1 = num1;
        this.result = result;
        this.symbolInfo = symbolInfo;
    }
}
