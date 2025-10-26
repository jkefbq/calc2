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
@Table(name = "two")
@Getter
@Setter
@NoArgsConstructor
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "symbol_id")
    private ExampleSymbol exampleSymbol;

    @Column(name = "num_1")
    private int num1;
    @Column(name = "num_2")
    private int num2;
    private String result;

    public Example(int num1, int num2, String result, ExampleSymbol exampleSymbol) {
        this.num2 = num2;
        this.num1 = num1;
        this.result = result;
        this.exampleSymbol = exampleSymbol;
    }

    public static void updateExample(Example example, String result, int num1, int num2) {
        example.setResult(result);
        example.setNum1(num1);
        example.setNum2(num2);
    }
}
