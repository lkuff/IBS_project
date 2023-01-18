package tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static tests.TestData.*;


public class IBSTests extends TestBase{

    @BeforeEach
    void setUp() {
        open("https://ibs.ru/");
    }

    @DisplayName("Check contacts button on main page")
    @Test
    void checkContactsButton() {
        step("Click on contacts button and check that contact page open", () -> {
            mainPage.clickContactsButton(contacts);
        });
    }

    @DisplayName("Check accept cookies")
    @Test
    void checkAcceptingCookies() {
        step("Click on accept cookies button and check it disappear", () -> {
            mainPage.cookiesButtonShouldBeVisible();
            mainPage.clickOnCookiesButton();
            mainPage.cookiesButtonShouldBeHidden();
        });
    }

    @DisplayName("Check input field on main page")
    @Test
    void checkInputInSearchPage() {
        step("Click on input field and enter 'QA Engineer'", () -> {
            mainPage.clickOnInputField();
            mainPage.enterInField();
        });
        step("Check search page", () -> {
            mainPage.checkResultsPage();
        });
    }

    @DisplayName("Check testing page")
    @Test
    void checkTestingPage() {
        step("Click on 'burger' button and check page has 'Управление программами' text", () -> {
            mainPage.clickOnBurgerButton();
            mainPage.checkMenuPageOpen();
        });
        step("Click on 'Тестирование' button and check page has 'https://ibs-qa.ru/' url",() -> {
            mainPage.clickOnTestButton(testAddress);
        });
    }

    @DisplayName("Check vacancies page")
    @Test
    void checkVacanciesInMoscow() {
        step("Click on 'burger' button", () -> {
            mainPage.clickOnBurgerButton();
        });
        step("Click on 'Карьера' button and check it became active", () -> {
            mainPage.clickOnCareerButton(career);
        });
        step("Click on 'Вакансии' button and check page with vacancies open", () -> {
            mainPage.clickOnVacanciesButton(vacancies);
        });
        step("Click on city button", () -> {
            mainPage.clickOnCityButton();
        });
        step("Select Moscow checkbox", () -> {
            mainPage.selectCheckbox();
        });
        step("click on the checkbox with burning vacancies", () -> {
            mainPage.selectCheckboxWithBurnVacancies();
        });
    }

    @DisplayName("Check internships button in the footer")
    @Test
    void checkInternshipsButtonInFooter() {
        step("Scroll too footer an click on 'Стажировки' button", () -> {
            mainPage.clickOnInternshipsButton();
        });
        step("Check page has https://technodrom.ru/ url", () -> {
            mainPage.checkInternshipsAddress();
        });

    }

    @DisplayName("Check opening VK page when click on VK icon")
    @Test
    void checkVKButton() {
        step("Click on 'burger' button and check page has 'Управление программами' text", () -> {
            mainPage.clickOnBurgerButton();
            mainPage.checkMenuPageOpen();
        });
        step("Switch to new page and check URL", () -> {
            mainPage.checkVKAddress(VKAddress);
        });
    }
}
