Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на элемент 'Close popup' если он видим
    When элемент 'Who We Serve' отображается на странице
    When элемент 'Subjects' отображается на странице
    When элемент 'About' отображается на странице