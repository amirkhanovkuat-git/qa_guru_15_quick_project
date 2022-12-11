package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Check search")
    void searchTest() {
        step("Open url 'https://hh.kz/'", () ->
                open("https://hh.kz/"));

        step("Set value to search", () ->
                $(".bloko-input-text").setValue("qa automation")).pressEnter();

        step("Texts should visible", () -> {
            $(byText("Вакансии")).should(visible);
            $(byText("Резюме")).should(visible);
            $(byText("Компании")).should(visible);
        });
    }

    @Test
    @DisplayName("Check Header text")
    void headerTest() {
        step("Open url 'https://hh.kz/'", () ->
                open("https://hh.kz/"));

        step("Click link I want to work for you", () ->
                $(".supernova-link.supernova-link_dimmed").click());

        step("Header should visible", () -> {
            $(".wtw__h1-title").should(visible);
        });
    }

    @Test
    @DisplayName("Check employer page")
    void employerTest() {
        step("Open url 'https://hh.kz/'", () ->
                open("https://hh.kz/"));

        step("Click link for employers", () ->
                $("[data-qa=mainmenu_priceRegional]").click());

        step("Check text", () -> {
            $("[data-qa=cart__tab_dbaccess]").shouldHave(text("Покупка услуг по подбору персонала в Казахстане"));
        });
    }

    @Test
    @DisplayName("Сheck help button")
    void helpButtonTest() {
        step("Open url 'https://hh.kz/'", () ->
                open("https://hh.kz/"));

        step("Click button Help", () ->
                $("[data-qa=mainmenu_help]").click());

        step("Сheck that the link with text appear", () -> {
            $(byText(
                    "Вопросы и ответы"))
                    .should(visible);
        });
    }

    @Test
    @DisplayName("Сheck Advanced Search")
    void advancedSearchTest() {
        step("Open url 'https://hh.kz/'", () ->
                open("https://hh.kz/"));

        step("Click to search element", () ->
                $("[data-qa=advanced-search]")).click();

        step("Сheck that the text appear", () -> {
            $(byText("Ключевые слова")).should(visible);
        });
    }
}