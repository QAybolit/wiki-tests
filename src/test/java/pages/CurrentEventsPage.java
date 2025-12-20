package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CurrentEventsPage {

    private final SelenideElement pageTitle = $("h1#firstHeading");

    @Step("Проверить, что страница открылась")
    public CurrentEventsPage checkCurrentEventsPageIsOpen() {
        this.pageTitle.shouldBe(visible).shouldHave(text("Портал:Текущие события"));
        return this;
    }
}
