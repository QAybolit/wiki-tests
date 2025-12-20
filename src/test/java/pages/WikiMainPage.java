package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.MenuComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiMainPage {

    private MenuComponent menu = new MenuComponent();

    private final SelenideElement wikiLogo = $(".mw-wiki-logo");
    private final SelenideElement pageTitle = $("h1.main-top-header");
    private final SelenideElement searchInput = $(".vector-search-box-input");

    @Step("Открыть главную страницу")
    public WikiMainPage openPage() {
        open("");
        this.wikiLogo.shouldBe(visible);
        this.pageTitle.shouldBe(visible);
        return this;
    }

    @Step("Нажать Enter в поле поиска")
    public SearchPage goToSearchPage() {
        this.searchInput.pressEnter();
        return new SearchPage();
    }

    @Step("Ввести '{term}' в поле поиска и нажать Enter")
    public ArticlePage searchArticleBySearchField(String term) {
        this.searchInput.setValue(term).pressEnter();
        return new ArticlePage();
    }

    @Step("Ввести '{term}' в поле поиска и нажать Enter")
    public SearchPage searchArticlesBySearchField(String term) {
        this.searchInput.setValue(term).pressEnter();
        return new SearchPage();
    }

    @Step("Перейти на страницу 'Содержание'")
    public ContentsPage goToContentsPageByMenu() {
        this.menu.goToContentsPage();
        return new ContentsPage();
    }

    @Step("Перейти на страницу 'Избранные статьи'")
    public SelectedArticlesPage goToSelectedArticlesPageByMenu() {
        this.menu.goToSelectedArticlesPage();
        return new SelectedArticlesPage();
    }

    @Step("Перейти на страницу 'Текущие события'")
    public CurrentEventsPage goToCurrentEventsPageByMenu() {
        this.menu.goToCurrentEventsPage();
        return new CurrentEventsPage();
    }

}
