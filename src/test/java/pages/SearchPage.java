package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    private final SelenideElement pageTitle = $("h1#firstHeading");
    private final SelenideElement searchInput = $("[type='search']");
    private final SelenideElement searchButton = $("[type='submit']");

    private final ElementsCollection searchItemsLink = $$(".mw-search-results-container li a");
    private final ElementsCollection searchItems = $$(".mw-search-results-container li");

    @Step("Проверить, что страница с результатами поиска открылась")
    public SearchPage checkSearchResultsPageIsOpen() {
        this.pageTitle.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что отображаются результаты поиска")
    public SearchPage checkSearchResultsAreNotEmpty() {
        this.searchItems.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Проверить, что результаты поиска пустые")
    public SearchPage checkSearchResultsAreEmpty() {
        this.searchItems.shouldHave(size(0));
        return this;
    }

    @Step("Выбрать первую статью в результатах поиска")
    public ArticlePage selectFirstArticle() {
        this.searchItemsLink.first().hover().click();
        return new ArticlePage();
    }

    @Step("Ввести '{term}' в поле поиска и нажать 'Найти'")
    public SearchPage searchArticleBySearchField(String term) {
        this.searchInput.setValue(term);
        this.searchButton.click();
        return this;
    }

    @Step("Проверить, что первая найденая статья содержит '{info}'")
    public SearchPage checkFirstResultContainsInfo(String info) {
        this.searchItems.first().shouldHave(text(info));
        return this;
    }
}
