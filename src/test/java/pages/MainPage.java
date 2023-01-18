package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {

    public void clickContactsButton(String contacts) {
        $(".header-links").$(byText(contacts)).click();
        $(".wrap h1").shouldHave(text(contacts));
    }

    public void cookiesButtonShouldBeVisible() {
        $(withText("Принять условия")).shouldBe(visible);
    }

    public void clickOnCookiesButton() {
        $(".js-cookies-close").click();
    }

    public void cookiesButtonShouldBeHidden() {
        $(withText("Принять условия")).shouldBe(hidden);
    }

    public void clickOnInputField() {
        $(".header-search").click();
    }

    public void enterInField() {
        $(".js-search-input").setValue("QA Engineer").pressEnter();
    }

    public void checkResultsPage() {
        $(".search-result").shouldHave(text("# Тестирование"));
    }

    public void clickOnBurgerButton() {
        $(".js-burger").click();
    }

    public void checkMenuPageOpen() {
        $(".navigation-columns").shouldHave(text("Управление программами"));
    }

    public void clickOnTestButton(String testAddress) {
        $$(".navigation-list a").findBy(href(testAddress)).click();
        switchTo().window(1);
        webdriver().shouldHave(url(testAddress));
    }

    public void clickOnCareerButton(String career) {
        $(".navigation-sections").$(byText(career)).click();
        $(".navigation-sections").$(byText(career)).shouldHave(cssClass("is-active"));
    }

    public void clickOnVacanciesButton(String vacancies) {
        $$(".navigation-list a").findBy(text(vacancies)).click();
        $(".wrap h1").shouldHave(text(vacancies));
    }

    public void clickOnCityButton() {
        $$(".jobs-filter-block-header").findBy(text("Город")).scrollTo().click();
    }

    public void selectCheckbox() {
        $$(".jobs-filter-block-content .checkbox").findBy(text("Москва")).scrollTo().click();
    }

    public void selectCheckboxWithBurnVacancies() {
        $(".switcher").click();
        webdriver().shouldHave(url("https://ibs.ru/career/jobs/filter/is_hot-is-y/city-is-moscow/apply/"));
    }

    public void clickOnInternshipsButton() {
        $(".footer-links").scrollTo();
        $(".footer-legal").shouldHave(text("Персональные данные и правовые аспекты"));
        $(".footer-menu").$(byText("Стажировки")).click();
    }

    public void checkInternshipsAddress() {
        switchTo().window(1);
        webdriver().shouldHave(url("https://technodrom.ru/"));
    }

    public void checkVKAddress(String VKAddress) {
        $$(".navigation-socials a").findBy(href(VKAddress)).click();
        switchTo().window(1);
        webdriver().shouldHave(url(VKAddress));
    }
}
