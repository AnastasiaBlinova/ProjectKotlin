package com.example.m5_quiz_resources

object QuizStorage {
    fun getQuiz(locale: Locale): Quiz = when (locale) {
        Locale.Ru -> quizRu
        Locale.En -> quizEn
    }

    fun answer(quiz: Quiz, answers: List<Int>): String = quiz
        .questions
        .zip(answers) { question, index -> question.feedback[index] }
        .joinToString(separator = " ")

    enum class Locale {
        Ru, En
    }

    private val quizRu = object : Quiz {
        override val questions: List<Question> = listOf(
            Question(
                question = "Как ты себя чувствуешь?",
                answers = listOf(
                    "Плохо",
                    "Нормально",
                    "Хорошо",
                    "Отлично",
                ),
                feedback = listOf(
                    "Ты сегодня как выжатый лимон.",
                    "Тебе неочень, но бывало и хуже.",
                    "Ты сегодня в хорошем настроении.",
                    "Ты в прекрасном расположении духа.",
                ),
            ),
            Question(
                question = "Что тебя беспокоит?",
                answers = listOf(
                    "Политическая ситуация",
                    "Личные события в жизни",
                    "Проблемы близких",
                    "Все выше перечисленное",
                ),
                feedback = listOf(
                    "Ты обеспокоен политической ситуацией.",
                    "У тебя сейчас сложности в твоей жизни.",
                    "Ты переживаешь о своих близких.",
                    "У тебя сейчас очень непростой этап в жизни.",
                ),
            ),
            Question(
                question = "Как планируешь справиться?",
                answers = listOf(
                    "При помощи активного вида деятельности",
                    "Пообщаться с живым человеком",
                    "Разобраться самостоятельно",
                    "Верю, что время лечит",
                ),
                feedback = listOf(
                    "Ты большой молодец! Я верю, что активный вид деятельности понизит твою" +
                            " тревожность!",
                    "Здорово! Общение с людьми пойдет на пользу!",
                    "Я верю, что ты самостоятельно справишься со своей тревожностью!",
                    "Да, ты прав - время поможет уменьшить тревожность.",
                ),
            ),
        )
    }


    private val quizEn = object : Quiz {
        override val questions: List<Question> = listOf(
            Question(
                question = "How are you feeling?",
                answers = listOf(
                    "Bad",
                    "Normal",
                    "Good",
                    "Wonderful",
                ),
                feedback = listOf(
                    "You are like a squeezed lemon today.",
                    "You are not much, but it is been worse.",
                    "You are in a good mood today.",
                    "You are in a great mood.",
                ),
            ),
            Question(
                question = "What is bothering you?",
                answers = listOf(
                    "Political situation",
                    "Personal life events",
                    "Problems of loved ones",
                    "All of the above",
                ),
                feedback = listOf(
                    "You are concerned about the political situation.",
                    "You are having difficulties in your life right now.",
                    "You are worried about your loved ones.",
                    "You are having a difficult stage in your life right now.",
                ),
            ),
            Question(
                question = "How do you plan to cope?",
                answers = listOf(
                    "With the help of an active type of activity",
                    "Communicate with a living person",
                    "Figure it out on your own",
                    "I believe that time heals",
                ),
                feedback = listOf(
                    "You are a great fellow! I believe that an active type of activity will lower " +
                            "your anxiety!",
                    "Great! Communication with people will benefit!",
                    "I believe that you will cope with your anxiety on your own!",
                    "Yes, you are right - time will help reduce anxiety.",
                ),
            ),
        )
    }
}