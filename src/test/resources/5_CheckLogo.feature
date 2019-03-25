Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на кнопку 'Close popup' если она видима
    When подождать '3' секунд
    When выполнено нажатие на кнопку 'Subjects'
    When подождать '3' секунд
    When выполнено нажатие на кнопку 'Close popup' если она видима
    When подождать '3' секунд
    When выполнено нажатие на кнопку 'Logo'
    When текущий url равен 'https://www.wiley.com/en-us'

