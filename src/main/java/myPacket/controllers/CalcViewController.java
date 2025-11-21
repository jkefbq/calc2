package myPacket.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myPacket.dto.RequestDto;
import myPacket.service.CalculateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@AllArgsConstructor
public class CalcViewController {

    private CalcRestController calcRestController;
    private CalculateService calcService;

    @PostMapping("/calc")
    public String calcResultPage(@ModelAttribute RequestDto requestDto, Model model) {
        log.info("Called .calcResultPage()");
        model.addAttribute("requestDto", requestDto);
        model.addAttribute("isDone", true);
        try {
            model.addAttribute("result",
                    String.valueOf(
                            calcService.calculate(requestDto.getSymbol(), requestDto.getA(), requestDto.getB())
                    )
            );
            calcRestController.calculateAndCreateOrUpdate(
                    requestDto.getA(), requestDto.getB(), requestDto.getSymbol());
        } catch (ArithmeticException | NullPointerException e) {
            log.error("error in .calcResultPage()", e);
            if (e.getClass().equals(NullPointerException.class)) {
                model.addAttribute("errorInfo",
                        "This is a server error, please try your request again later.");
            } else {
                model.addAttribute("errorInfo", e.getMessage());
            }
            model.addAttribute("isError", true);
            model.addAttribute("isDone", false);
            return "request-page";
        }
        return "request-page";
    }

    @GetMapping("/calc")
    public String calcEmptyPage(Model model) {
        if (!model.containsAttribute("requestDto")) {
            model.addAttribute("requestDto", new RequestDto());
        }
        model.addAttribute("isDone", false);
        return "request-page";
    }
}
