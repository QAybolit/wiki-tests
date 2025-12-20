package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pages.WikiMainPage;


@Owner("Dina")
@Feature("Поиск информации на сайте Wikipwdia.org")
public class WikiTests extends BaseTest {

    WikiMainPage mainPage = new WikiMainPage();

    @ParameterizedTest(name = ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @CsvSource(value = {
            "Go, golang",
            "Java, Sun Microsystems",
            "C++, Embarcadero"
    })
    @DisplayName("Поиск статей по теме: ")
    @Story("Поиск статей на Wikipedia")
    @Tags({@Tag("local"), @Tag("remote"), @Tag("smoke"), @Tag("regress")})
    public void findArticlesBySubjectNameTest(String subject, String info) {
        mainPage.openPage()
                .goToSearchPage()
                .searchArticleBySearchField(subject)
                .checkSearchResultsAreNotEmpty()
                .checkFirstResultContainsInfo(info);
    }

    @ParameterizedTest(name = ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @MethodSource("data.DataProvider#viewInfoAboutAnimals")
    @DisplayName("Просмотр статей о животных: ")
    @Story("Поиск статей на Wikipedia")
    @Tags({@Tag("remote"), @Tag("smoke"), @Tag("regress")})
    public void viewInfoAboutAnimalsRemoteTest(String animal, String url, String articleName, String articleInfo) {
        mainPage.openPage()
                .searchArticleBySearchField(animal)
                .checkArticlePageIsOpen()
                .checkArticleURLIsCorrect(url)
                .checkArticleIsCorrect(articleName, articleInfo);
    }

    @ParameterizedTest(name = ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @MethodSource("data.DataProvider#viewInfoAboutAnimals")
    @DisplayName("Просмотр статей о животных: ")
    @Story("Поиск статей на Wikipedia")
    @Tags({@Tag("local"), @Tag("smoke"), @Tag("regress")})
    public void viewInfoAboutAnimalsLocalTest(String animal, String url, String articleName, String articleInfo) {
        mainPage.openPage()
                .searchArticlesBySearchField(animal)
                .checkSearchResultsPageIsOpen()
                .checkSearchResultsAreNotEmpty()
                .selectFirstArticle()
                .checkArticlePageIsOpen()
                .checkArticleURLIsCorrect(url)
                .checkArticleIsCorrect(articleName, articleInfo);
    }

    @Test
    @DisplayName("Просмотр страницы 'Содержание'")
    @Story("Боковое меню на Wikipedia")
    @Tags({@Tag("local"), @Tag("remote"), @Tag("smoke"), @Tag("regress")})
    public void viewContentPageTest() {
        mainPage.openPage()
                .goToContentsPageByMenu()
                .checkContentsPageIsOpen();
    }

    @Test
    @DisplayName("Просмотр страницы 'Избранные статьи'")
    @Story("Боковое меню на Wikipedia")
    @Tags({@Tag("local"), @Tag("remote"), @Tag("smoke"), @Tag("regress")})
    public void viewSelectedArticlesPageTest() {
        mainPage.openPage()
                .goToSelectedArticlesPageByMenu()
                .checkSelectedArticlesPageIsOpen();
    }

    @Test
    @DisplayName("Просмотр страницы 'Текущие события'")
    @Story("Боковое меню на Wikipedia")
    @Tags({@Tag("local"), @Tag("remote"), @Tag("smoke"), @Tag("regress")})
    public void viewCurrentEventsPageTest() {
        mainPage.openPage()
                .goToCurrentEventsPageByMenu()
                .checkCurrentEventsPageIsOpen();
    }
}
