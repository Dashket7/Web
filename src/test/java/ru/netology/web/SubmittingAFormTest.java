package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SubmittingAFormTest {
    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $("[action]");
        form.$("[data-test-id=name]input").setValue("Мария-Антуанетта Иванова");
        form.$("[data-test-id=phone]input").setValue("+784596412548");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
