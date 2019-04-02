Feature: the version can be retrieved
  Scenario: client makes call to GET /version

    When открыта анкета
    When страница загружена
    When поле 'Срок кредита' содержит текст 'от 1 до 7 лет'
    When поле 'Сумма' содержит текст 'до 4 млн руб'
    When поле 'Решение по заявке' содержит текст 'за 2 минуты'
    When поле 'Процентная ставка' содержит текст 'от 11,99 %'
    When выполнено нажатие на элемент 'Продолжить'
    When элемент 'Фамилия ошибка' отображается на странице
    When элемент 'Имя ошибка' отображается на странице
    When элемент 'Отчество ошибка' отображается на странице
    When элемент 'Мобильный телефон ошибка' отображается на странице
    When элемент 'Электронная почта ошибка' отображается на странице
    When элемент 'Регион работы ошибка' отображается на странице
    When выполнено нажатие на элемент 'Условия направления заявления ссылка'
    When элемент 'Условия направления заявления блок' отображается на странице
    When выполнено нажатие на элемент 'Условия направления заявления закрыть'
    When ввести в поле 'Фамилия' текст 'Иванов'
    When ввести в поле 'Имя' текст 'Иван'
    When ввести в поле 'Отчество' текст 'Иванович'
    When ввести в поле 'Мобильный телефон' текст '9649646464'
    When ввести в поле 'Электронная почта' текст 'test@test.ru'
    When выполнено нажатие на элемент 'Регион работы поле'
    When выполнено нажатие на элемент списка 'Регион работы список' с текстом 'Москва'
    When выполнено нажатие на элемент 'Продолжить'

    When страница загружена
    When выполнено нажатие на элемент 'Продолжить'
    When элемент 'Серия номер ошибка' отображается на странице
    When элемент 'Дата выдачи паспорта ошибка' отображается на странице
    When элемент 'Код подразделения ошибка' отображается на странице
    When элемент 'Кем выдан паспорт ошибка' отображается на странице
    When элемент 'Дата рождения ошибка' отображается на странице
    When элемент 'Место рождения ошибка' отображается на странице
    When элемент 'Регион регистрации ошибка' отображается на странице
    When элемент 'Название организации ошибка' отображается на странице
    When элемент 'ИНН организации ошибка' отображается на странице
    When элемент 'Зарплата ошибка' отображается на странице
    When ввести в поле 'Серия паспорта' текст '4444'
    When ввести в поле 'Номер паспорта' текст '444444'
    When ввести в поле 'Дата выдачи паспорта' текст '11.11.2011'
    When ввести в поле 'Код подразделения' текст '111111'
    When ввести в поле 'Дата рождения' текст '10.10.1980'
    When ввести в поле 'Место рождения' текст 'Луна'
    When выполнено нажатие на элемент 'Регион регистрации поле'
    When выполнено нажатие на элемент списка 'Регион регистрации список' с текстом 'Москва'
    When ввести в поле 'Название организации' текст 'Рога и копыта'
    When ввести в поле 'ИНН организации' текст '7728168971'
    When ввести в поле 'Зарплата' текст '100000'
    When ввести в поле 'Кем выдан паспорт' текст 'ТП№ 77 ОТДЕЛА УФМС РОССИИ ПО САНКТ ПЕТЕРБУРГУ'
    When выполнено нажатие на элемент 'Продолжить'

    When страница загружена
    When выполнено нажатие на элемент 'Продолжить'
    When элемент 'Дата устройства ошибка' отображается на странице
    When элемент 'Должность ошибка' отображается на странице
    When элемент 'Рабочий телефон ошибка' отображается на странице
    When элемент 'Образование поле ошибка' отображается на странице
    When элемент 'Семейное положение ошибка' отображается на странице
    When элемент 'Кем приходится контактное лицо ошибка' отображается на странице
    When элемент 'Фамилия контакта ошибка' отображается на странице
    When элемент 'Имя контакта ошибка' отображается на странице
    When элемент 'Отчество контакта ошибка' отображается на странице
    When элемент 'Телефон контакта ошибка' отображается на странице
    When ввести в поле 'Дата устройства' текст '10.10.2018'
    When ввести в поле 'Рабочий телефон' текст '9651241414'
    When ввести в поле 'Должность' текст 'Рабочий'
    When выполнено нажатие на элемент списка 'Должность список' с текстом 'Рабочий'
    When выполнено нажатие на элемент 'Образование поле'
    When выполнено нажатие на элемент списка 'Образование список' с текстом 'Высшее'
    When выполнено нажатие на элемент 'Семейное положение поле'
    When выполнено нажатие на элемент списка 'Семейное положение список' с текстом 'Гражданский брак'
    When выполнено нажатие на элемент 'Кем приходится контактное лицо поле'
    When выполнено нажатие на элемент списка 'Кем приходится контактное лицо список' с текстом 'Сын'
    When ввести в поле 'Фамилия контакта' текст 'Иванов'
    When ввести в поле 'Имя контакта' текст 'Иван'
    When ввести в поле 'Отчество контакта' текст 'Иванович'
    When ввести в поле 'Телефон контакта' текст '9659656565'
    When выполнено нажатие на элемент 'Продолжить'

    When страница загружена
    When выполнено нажатие на элемент 'Есть ли кредиты да'
    When выполнено нажатие на элемент 'Рефинансирование да'
    When ввести в поле 'Название банка' текст 'сбер'
    When выполнено нажатие на элемент 'Тип кредита поле'
    When выполнено нажатие на элемент списка 'Тип кредита список' с текстом 'Ипотека'
    When ввести в поле 'Сумма долга' текст '50000'
    When ввести в поле 'Дата открытия' текст '01.01.2018'
    When выполнено нажатие на элемент 'Добавить'
    When ввести в поле 'Дополнительная сумма' текст '50000'
    When выполнено нажатие на элемент 'Дата платежа поле'
    When выполнено нажатие на '1' элемент списка 'Дата платежа список'
    When выполнено нажатие на элемент списка 'Срок кредита' с текстом '2 года'
    When выполнено нажатие на элемент 'Продолжить'

    When подождать '10' секунд
    When выполнено нажатие на элемент 'Отправить заявку'
    When выполнено нажатие на элемент 'Второй документ поле'
    When выполнено нажатие на элемент 'Второй документ поле'
    When выполнено нажатие на элемент списка 'Второй документ список' с текстом 'Водительское удостоверение'
    When выполнено нажатие на элемент 'Справка о доходах поле'
    When выполнено нажатие на элемент списка 'Справка о доходах список' с текстом 'Справка по форме 2НДФЛ'
    When выполнено нажатие на элемент 'Дополнительный доход да'
    When ввести в поле 'Размер доп дохода' текст '10000'
    When выполнено нажатие на элемент 'Источник доп дохода поле'
    When выполнено нажатие на элемент списка 'Источник доп дохода список' с текстом 'Алименты'
    When выполнено нажатие на элемент 'Вы получаете пенсию да'
    When ввести в поле 'Размер пенсии' текст '10000'
    When ввести в поле 'Кодовое слово' текст 'Автотест777'
    When выполнено нажатие на элемент 'Отправить заявку'
    When элемент 'Введите код из смс' отображается на странице


