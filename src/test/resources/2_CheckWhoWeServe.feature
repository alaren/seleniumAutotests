Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на кнопку 'Close popup' если она видима
    When подождать '3' секунд
    When навести курсор на 'Who We Serve'
    When подождать '3' секунд
    When выпадающий список 'Droplist Who We Serve' содержит '13' элементов
    When выпадающий список 'Droplist Who We Serve' содержит следующие значения:
    |Students|
    |Instructors|
    |Book Authors|
    |Professionals|
    |Researchers|
    |Institutions|
    |Librarians|
    |Corporations|
    |Societies|
    |Journal Editors|
    |Bookstores|
    |Journalists|
    |Government|