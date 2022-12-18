package cloud.autotests.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;



public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Тест Поиска на главной странице")
    void searchTest() {
        step("Открыть сайт 'https://shop.beeline.kz/ru/almaty'", () ->
                open("https://shop.beeline.kz/ru/almaty"));

        step("Вставить текст на поиск", () ->
                $(".search-form__input").setValue("iphone").pressEnter());

        step("Текст 'Результаты поиска' должны быть видимым", () -> {
            $("main.main--search").shouldHave(text("Результаты поиска"));
        });
    }

    @Test
    @DisplayName("Тест Фильтра на странице Смартфоны")
    void filterTest() {
        step("Открыть сайт 'https://shop.beeline.kz/ru/almaty'", () ->
                open("https://shop.beeline.kz/ru/almaty"));

        step("Нажать на ссылку 'Смартфоны'", () ->
                $("#qa-nav-category-smartphones").click());

        step("Раскрыть пункт 'Операционная система'", () -> {
            $("#filter-collapse-spec_general_os").scrollIntoView(true);
            $("#filter-collapse-spec_general_os").click();
        });

        step("Выбрать Операционную систему Anroid", () ->
            $("[for=facet_spec_general_os_Android]").click());

        step("Выбрать смартфон", () ->
                $("#qa-smartphones-item-0").click());

        step("Проверить указано ли в характеристике Операционная система - Android", () -> {
                $(".table__row").scrollIntoView(true);
                $(".row").shouldHave(
                        text("Операционная система"),
                        text("Android"));
                });
    }

    @Test
    @DisplayName("Тест Сортировки на странице Смартфоны")
    void sortingTest() {
        step("Открыть сайт 'https://shop.beeline.kz/ru/almaty'", () ->
                open("https://shop.beeline.kz/ru/almaty"));

        step("Нажать на ссылку 'Смартфоны'", () ->
                $("#qa-nav-category-smartphones").click());

        step("Нажать кнопку 'Сортировать'", () ->
                $("[title=Сортировать]").click());

        step("Выбрать пункт 'По новизне'", () ->
                  $(".form-check-label").click());

        step("Проверить выбрано ли сортировка 'По новизне'", () ->
                $(".section__product__filters").shouldHave(text("По новизне")));

    }

    @Test
    @DisplayName("Проверить страницы Роутеры")
    void helpButtonTest() {
        step("Открыть сайт 'https://shop.beeline.kz/ru/almaty'", () ->
                open("https://shop.beeline.kz/ru/almaty"));

        step("Нажать на ссылку 'Роутеры'", () ->
                $("#qa-nav-category-routers").click());


        step("Проверить есть ли товар '4G Wi-Fi роутер Beeline MF927U'", () -> {
            $(".card-v2__title").shouldHave(text("4G Wi-Fi роутер Beeline MF927U"));
        });
    }

    @Test
    @DisplayName("Проверить страницу Оплата и Доставка")
    void advancedSearchTest() {
        step("Открыть сайт 'https://shop.beeline.kz/ru/almaty/content-page/shipping'", () ->
                open("https://shop.beeline.kz/ru/almaty/content-page/shipping"));

        step("Проверить в блоке Доставка", () -> {
            $(".content-page")
                    .shouldHave(text("Условия и стоимость доставки показана на странице оформления заказа."));
        });
    }
}