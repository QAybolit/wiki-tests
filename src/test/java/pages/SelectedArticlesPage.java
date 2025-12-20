package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectedArticlesPage {

    private final SelenideElement pageTitle = $("h1#firstHeading");
    private final ElementsCollection rubricTitles = $$(".mw-heading h2");

    @Step("Проверить, что страница открылась")
    public SelectedArticlesPage checkSelectedArticlesPageIsOpen() {
        this.pageTitle.shouldBe(visible).shouldHave(text("Википедия:Избранные статьи"));
        this.rubricTitles.shouldBe(size(2));
        this.rubricTitles.first().shouldHave(text("Недавно избранные статьи"));
        this.rubricTitles.get(1).shouldHave(text("Все избранные статьи"));
        return this;
    }
}
