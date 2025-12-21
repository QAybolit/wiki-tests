package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MenuComponent {

    private final SelenideElement contentsPageLink = $("#n-content");
    private final SelenideElement selectedArticlesPageLink = $("#n-featured");
    private final SelenideElement currentEventsPageLink = $("#n-currentevents");

    @Step("Нажать на кнопку 'Содержание'")
    public void goToContentsPage() {
        this.contentsPageLink.click();
    }

    @Step("Нажать на кнопку 'Избранные статьи'")
    public void goToSelectedArticlesPage() {
        this.selectedArticlesPageLink.click();
    }

    @Step("Нажать на кнопку 'Текущие события'")
    public void goToCurrentEventsPage() {
        this.currentEventsPageLink.click();
    }
}
