require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Здравствуйте. Я бот-советник. Могу помочь вам и ответить на многие вопросы. Выберите тему обращения или напишите свой вопрос
        buttons:
            "авиа возврат" -> /авиа возврат
            "багаж" -> /Багаж
            "трипкоины" -> /Трипкоины
        intent: /Авиа возврат || toState = "/авиа возврат"
        intent: /привет || toState = "/Привет"
        intent: /Багаж || toState = "/Багаж"
        intent: /Трипкоины || toState = "/Трипкоины"
        event: noMatch || toState = "/Start"

    state: Bye
        intent!: /Прощание
        a: Пока пока

    state: KnowledgeBase
        intentGroup!: /KnowledgeBase
        a: Нашёл ответ в базе знаний!
        script: $faq.pushReplies();

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: авиа возврат
        intent!: /Авиа возврат
        a: Здравствуйте! Для создания заявки на расчет суммы к возврату перейдите в раздел Мой заказ. Выберите опцию ""Оформить возврат"". Далее укажите перелет, пассажира и причину возврата. Обратите внимание, что если вы не уверены в том, что точно не воспользуетесь перелетом, выберите причину ""Хочу узнать сумму к возврату. Возможно, я не полечу"", это сохранит билет в целости, если вы решите не продолжать процесс возврата.
            Расчет будет произведен согласно условиям тарифа. На телефон и email из заказа будут поступать важные уведомления по заявке.
            Важно! Заявку на возврат необходимо подать заранее до вылета рейса (минимум за 2 часа).
            Если возникнут вопросы, будем рады ответить. || htmlEnabled = true, html = "Здравствуйте! Для создания заявки на расчет суммы к возврату перейдите в раздел Мой заказ. Выберите опцию ""Оформить возврат"". Далее укажите перелет, пассажира и причину возврата. Обратите внимание, что если вы не уверены в том, что точно не воспользуетесь перелетом, выберите причину ""Хочу узнать сумму к возврату. Возможно, я не полечу"", это сохранит билет в целости, если вы решите не продолжать процесс возврата. <br>Расчет будет произведен согласно условиям тарифа. На телефон и email из заказа будут поступать важные уведомления по заявке. <br>Важно! Заявку на возврат необходимо подать заранее до вылета рейса (минимум за 2 часа).<br>Если возникнут вопросы, будем рады ответить.<br>"
        event: noMatch || toState = "/Start"

    state: Багаж
        intent!: /Багаж
        a: Здравствуйте! Перейдите в ваш заказ через раздел ""Заказы"" на главном экране.
            Выберите услугу ""Багаж"", нажав на кнопку ""+"". Укажите необходимые параметры сверхнормативного багажа по каждому сегменту перелета. Затем нажмите ""Купить"", откроется окно для ввода данных карты.
            После оплаты багаж будет добавлен, и вам поступит подтверждение на электронный адрес. || htmlEnabled = true, html = "Здравствуйте! Перейдите в ваш заказ через раздел ""Заказы"" на главном экране.<br>Выберите услугу ""Багаж"", нажав на кнопку ""+"". Укажите необходимые параметры сверхнормативного багажа по каждому сегменту перелета. Затем нажмите ""Купить"", откроется окно для ввода данных карты.<br>После оплаты багаж будет добавлен, и вам поступит подтверждение на электронный адрес.<br><br><br><br><br><br><br>"
        event: noMatch || toState = "/Start"

    state: Трипкоины
        intent: /Трипкоины
        a: Здравствуйте! Трипкоины начисляются на бонусный счет в течение суток после фактического использования билета.
            Вам поступит уведомление о начислении трипкоинов на электронную почту, а также информация о начислении будет доступна в мобильном приложении OneTwoTrip, в разделе ""Уведомления"". || htmlEnabled = true, html = "Здравствуйте! Трипкоины начисляются на бонусный счет в течение суток после фактического использования билета. <br>Вам поступит уведомление о начислении трипкоинов на электронную почту, а также информация о начислении будет доступна в мобильном приложении OneTwoTrip, в разделе ""Уведомления"".<br><br><br><br><br><br>"
        event: noMatch || toState = "/Start"

    state: Привет
        image: https://248305.selcdn.ru/zfl_prod/1000046033/264559909/UnEmzQJoe10bCiAr.jpg
        audio: https://248305.selcdn.ru/zfl_prod/1000046033/264559909/audio/zlS3H3kYVfbBeE0K.mp3?channels={"incompatible":["ALEXA","GOOGLE_ASSISTANCE","OUTGOING_CALLS"],"compatible":["ALISA","AIMYBOX","FACEBOOK","WHATSAPP","TELEGRAM","VK"]} || name = "videoplayback.mp3"
        go: /Start

    state: На оператора
        intent!: /Перевод на оператора
        intent!: /sys/aimylogic/ru/switch
        TransferToOperator: 
            titleOfCloseButton = 
            messageBeforeTransfer = Перевожу на оператора
            messageBeforeTransferHtml = 
            prechatAttributes = {}
            ignoreOffline = false
            messageForWaitingOperator = 
            messageForWaitingOperatorHtml = 
            sendMessageHistoryAmount = 
            sendMessagesToOperator = true
            actions = {}
            htmlEnabled = false
            destination = 
        event: noMatch || toState = "./"