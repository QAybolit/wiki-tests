package tests;

import data.Subject;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.StepikMainPage;


@Owner("Dina")
@Feature("Поиск информации на сайте Stepik")
public class StepikTests extends BaseTest {

    StepikMainPage stepikMainPage = new StepikMainPage();

    @ParameterizedTest(name = ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @EnumSource(Subject.class)
    @DisplayName("Поиск курсов через каталог по предмету: ")
    @Story("Поиск информации о курсах")
    @Tags({@Tag("smoke"), @Tag("regress")})
    public void findCoursesBySubjectNameInCatalogTest(Subject subject) {
        stepikMainPage.openPage()
                .openCatalogDropdown()
                .selectItRubricInCatalog()
                .selectSubjectInRubric(subject.name())
                .checkHeader(subject.name())
                .checkSearchItemsArePresent();
    }

    @ParameterizedTest(name = ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @CsvSource(value = {
            "Python, 100000, 3",
            "Java, 80000, 1",
            "C#, 50000, 10"
    })
    @DisplayName("Поиск количества курсов по предмету по цене, большей переданной: ")
    @Story("Поиск информации о курсах")
    @Tags({@Tag("smoke"), @Tag("regress")})
    public void findCoursesBySubjectNameAndPriceTest(String subject, String price, int searchItemCount) {
        stepikMainPage.openPage()
                .searchSubjectBySearchField(subject)
                .setPriceFrom(price)
                .checkSearchItemsArePresent()
                .checkSearchItemsCount(searchItemCount);
    }

    @ParameterizedTest(name = ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @ValueSource(strings = {"Go", "Linux", "C#"})
    @DisplayName("Просмотр самых полпулярных курсов по: ")
    @Story("Просмотр популярных курсов")
    @Tags({@Tag("smoke"), @Tag("regress")})
    public void findPopularCoursesBySubjectNameTest(String subject) {
        stepikMainPage.openPage()
                .searchPopularCoursesByName(subject)
                .checkHeader(subject)
                .checkSearchItemsArePresent()
                .checkSearchItemsContainsSubject(subject);
    }

    @ParameterizedTest(name = ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @CsvFileSource(resources = "/testdata/organizationInfo.csv")
    @DisplayName("Просмотр информации о компании, размещающей курсы на Stepik: ")
    @Story("Просмотр информации об авторах курсов")
    @Tags({@Tag("smoke"), @Tag("regress")})
    public void viewInfoAboutOrganizationThatOfferCoursesTest(String organizationName, String url, String pageTitle) {
        stepikMainPage.openPage()
                .selectOrganizationByName(organizationName)
                .checkPageUrl(url)
                .checkHeader(pageTitle);
    }

    @ParameterizedTest(name = ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @MethodSource("data.DataProvider#viewInfoAboutCoursesAuthors")
    @DisplayName("Просмотр информации об авторе курсов: ")
    @Story("Просмотр информации об авторах курсов")
    @Tags({@Tag("smoke"), @Tag("regress")})
    public void viewInfoAboutCourseAuthorTest(String authorName, String url, String authorInfo) {
        stepikMainPage.openPage()
                .selectPopularAuthorByName(authorName)
                .checkHeader(authorName)
                .checkPageUrl(url)
                .checkInfoAboutAuthor(authorInfo);
    }
}
