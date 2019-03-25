Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на кнопку 'Close popup' если она видима
    When навести курсор на 'Who We Serve'
    When выполнено нажатие на элемент выпадающего списка 'Droplist Who We Serve' с текстом 'Students'
    When выполнено нажатие на кнопку 'Close popup' если она видима
    When ссылка 'Students header' отображается на странице
    When ссылка 'Be Your Best' отображается на странице
    When ссылка 'Be Inquisitive' отображается на странице
    When ссылка 'Be Smart' отображается на странице
    When ссылка 'Be Your Best' содержит аттрибут 'href' со значением 'http://www.wileyplus.com/nextgen/'
    When ссылка 'Be Inquisitive' содержит аттрибут 'href' со значением 'https://www.wileyplus.com/success-programs/'
    When ссылка 'Be Smart' содержит аттрибут 'href' со значением 'https://www.wileyplus.com/'