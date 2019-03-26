Feature: the version can be retrieved
  Scenario: client makes call to GET /version
    When открыта главная страница
    When выполнено нажатие на элемент 'Close popup' если он видим
    When навести курсор на 'Who We Serve'
    When выполнено нажатие на элемент списка 'Droplist Who We Serve' с текстом 'Students'
    When выполнено нажатие на элемент 'Close popup' если он видим
    When элемент 'Students header' отображается на странице
    When элемент 'Be Your Best' отображается на странице
    When элемент 'Be Inquisitive' отображается на странице
    When элемент 'Be Smart' отображается на странице
    When элемент 'Be Your Best' содержит аттрибут 'href' со значением 'http://www.wileyplus.com/nextgen/'
    When элемент 'Be Inquisitive' содержит аттрибут 'href' со значением 'https://www.wileyplus.com/success-programs/'
    When элемент 'Be Smart' содержит аттрибут 'href' со значением 'https://www.wileyplus.com/'