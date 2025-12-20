package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticlePage {

    private final SelenideElement articleTitle = $("h1#firstHeading");
    private final SelenideElement articleContent = $(".mw-content-ltr p");

    @Step("Проверить, что статья открылась")
    public ArticlePage checkArticlePageIsOpen() {
        this.articleTitle.shouldBe(visible);
        this.articleContent.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что статья соответствует поисковому запросу")
    public ArticlePage checkArticleIsCorrect(String title, String content) {
        this.articleTitle.shouldHave(text(title));
        this.articleContent.shouldHave(text(content));
        return this;
    }

    @Step("Проверить, что URL статьи соответствует поисковому запросу")
    public ArticlePage checkArticleURLIsCorrect(String url) {
        assertEquals(url, WebDriverRunner.url(), "URL [ " + url + " ] не соответствует текущему URL");
        return this;
    }

}
