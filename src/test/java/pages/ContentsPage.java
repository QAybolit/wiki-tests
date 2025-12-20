package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContentsPage {

    private final SelenideElement pageTitle = $("h1#firstHeading");
    private final SelenideElement pageMenu = $("#toc");

    @Step("Проверить, что страница открылась")
    public ContentsPage checkContentsPageIsOpen() {
        this.pageTitle.shouldBe(visible).shouldHave(text("Википедия:Содержание"));
        this.pageMenu.shouldBe(visible);
        return this;
    }
}
