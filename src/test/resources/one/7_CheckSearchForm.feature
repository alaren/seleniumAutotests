Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на кнопку 'Close popup' если она видима
    When подождать '3' секунд
    When ввести в поле 'Search field' текст 'java'
    When подождать '3' секунд
    When ссылка 'Suggestion block' отображается на странице
    When выпадающий список 'Suggestion list' содержит '4' элементов
    When выпадающий список 'Product list' содержит '4' элементов
    When названия всех элементов в списке 'Suggestion list' должны начинаться с 'java'
    When названия всех элементов в списке 'Product list' должны содержать 'java'

