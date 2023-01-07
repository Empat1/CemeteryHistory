package com.example.cemeteryhistory

public const val PERSON_USER = "user"
public const val PERSON_GAME = "голос из вне"
public const val PERSON_ZHENYA = "женя"

class History {
    var part = 102
    var labGame = 0;


    public fun menu(anwser:String): List<Message> {
        when(part){
            0-> if(anwser == "старт") return startHistory()
            1-> if(anwser == "да") return  collMe()
                else if(anwser == "нет" || anwser == "продолжим"||anwser == "продолжить") return  next().plus(meeting())
            2-> if(anwser == "налево"){labGame=labGame*10+1;return nextStep()}
                else if(anwser == "направо") {labGame=labGame*10+3;return nextStep()}
                else if(anwser == "прямо"){
                    labGame=labGame*10+2
                    if(labGame==2223132)
                         return meeting2()
                    else if(labGame < 0) {
                        labGame =0;
                        part = 2
                        //TODO GG
                        return meeting()
                    }else
                        return nextStep()
                }
            3-> return meeting3(anwser);
            102->return  meeting2()

        }

        return defoult()
    }

    public fun defoult(): ArrayList<Message>{
        val message = ArrayList<Message>()

        message.add(Message("Милая моя) Ты опять ломаешь мои планы)" , PERSON_GAME))
        return message;
    }

    public fun hi() : ArrayList<Message>{
        val message = ArrayList<Message>()

        message.add(Message(treeImage() , IMAGE))
        message.add(Message("Для запуска введите - старт" , PERSON_GAME))
        return message
    }

    public fun startHistory() : ArrayList<Message>{
        part = 1;

        val message = ArrayList<Message>()
        message.add(Message("Добро пожаловать" , PERSON_GAME))
        message.add(Message("Я дал волю своим внутреним чувствам" , PERSON_GAME))
        message.add(Message("И это вылилость в нечто прекрасное " , PERSON_GAME))
        message.add(Message("Я дал волю своим чувствам еще 6 лет назад" , PERSON_GAME))
        message.add(Message("И не жалею об этом ни капли" , PERSON_GAME))

        message.add(Message("Эта небольшая текстовая адвенчура посвещена очень дорогому для меня человеку" , PERSON_GAME))
        message.add(Message("Хоть она пока, что больше похожа на монолог. Но тут также нужно будет влиять на повествование" , PERSON_GAME))

        message.add(Message("Прежде чем начнем играть. Есть вопросы ?" , PERSON_GAME))


        return message
    }

    fun meeting(): ArrayList<Message>{
        part = 2
        val message = ArrayList<Message>()
        message.add(Message("Part 2 " , PERSON_GAME))
        message.add(Message("Я думаю историю стоит начать с самого начала" , PERSON_GAME))
        message.add(Message("С огромного и красивого скилета.... Ой кладбища... С огромного красивого зимнего кладбища" , PERSON_GAME))
        message.add(Message("Я буду ждать тебя там... Надеюсь я правильно помню дорогу до него", PERSON_GAME))
        message.add(Message("Она вроде что-то вроде прямо прямо прямо право лево право прямо" , PERSON_GAME))
        message.add(Message("Жду недождусь тебя)", PERSON_GAME))

        message.add(Message("И вот ты выходишь из дома. В неба падает ярко белый снег, который хрустит под твоими неторопливыми шагами." , PERSON_GAME))
        message.add(Message("Но ты вспоминаешь что тебя ждет красавчик на кладбище и мчишться к нему" , PERSON_GAME))

        message.add(Message("Перед тобой встают огромные ворота с не менее огромным лабиринтом. Куда ты пойдешь ?" , PERSON_GAME))

        return message
    }

    fun meeting2(): ArrayList<Message>{
        part = 3
        val message = ArrayList<Message>()
        message.add(Message("И вот в переди ты видишь едва заметный силует" , PERSON_GAME))
        return message
    }

    fun meeting3(anwser: String):ArrayList<Message>{
        val message = ArrayList<Message>()
        if(anwser == "подойти") {
            message.add(Message("Перед собой ты видишь юношу в кудрях которого запутались хлопья снега", PERSON_GAME))
            message.add(
                Message("Юноша смотрит на тебя счастливым счастливым выражением лица с легка заметной грустью в глазах. Он не счастен в своем странном мире. Может ты сделашь его счастливым?",
                    PERSON_GAME))
        }else if(anwser == "осмотреться") {
            message.add(Message("Романтичные гробики, милые деревья и красивый снег играет светом" , PERSON_GAME))
        }else if(anwser == "поцеловать" || anwser == "сделать счастливым"){
            message.add(Message("Мур)" , PERSON_GAME))
        }else if(anwser == "обнять"){
            message.add(Message("Ты чувсвуешь тепло" , PERSON_GAME))
            message.add(Message("Люблю обьятия" , PERSON_ZHENYA))
        }else if(anwser == "привет"){
            message.add(Message("привет)" , PERSON_ZHENYA))
        }else{
            return defoult()
        }

        return message;
    }

    fun collMe(): ArrayList<Message>{
        val message = ArrayList<Message>()
        message.add(Message("Тогда звони мне)" , PERSON_GAME))
        message.add(Message("Все еще остались вопросы ?" , PERSON_GAME))
        return message;
    }

    fun next(): ArrayList<Message>{
        val message = ArrayList<Message>()
        message.add(Message("Тогда продолжим)" , PERSON_GAME))
        return message;
    }

    fun nextStep(): ArrayList<Message>{
        val message = ArrayList<Message>()
        message.add(Message("А куда будет твой сделующий шаг?" , PERSON_GAME))
        return message;
    }

    public fun treeImage():String {
       return """░░░░░░░░▌░░░░░░░▐
░░░░█░░▄▌░░░░▌░░░█░░░▄▄
░░░░▐▄░▌░░░░▐▄▌░░░▀▄█▄
░░░░░▐█░░░░░░░▌░▄█▀░░░▀█
░░░▌░░▐░░░░░▄▀▀▀░░░░░░░░
░░░▐░░░▀▄░█▀▄▄▄▄░░░░░░░░
▌░░█▄░░░▐▄█░░░░▌▀▄░░░░░░
█░░░▐░░░██░░░░░█░░▄░█▀░░
▐░░░█░░░▐█░░░░░░░░▌▀░░░░
░▌░░▌░░░▐█▄░░░░▄▄█▄▄▄░░░
▄▄▀▄█░░░░██░▄█▀░█▄▄░▐▄▄░
░░░░▀█▄░▄███░░░░░░░░░░░░
░░░░░░█████░░░░░░░░░░░░░
░░░░░░░▐███░░░░░░░░░░░░░
░░░░░░░▐███░░░░░░░░░░░░░
░░░░░░░▐████░░░░░░░░░░░░
░░▒▒▒▒▒█████▒▒░░░░░░░░░░
▒▒▒▒▒▒▄██████▒▒▒▒▒▒▒▒▒▒▒
▒▒▄▄▄█▀▒█▀▐▀▀██▄▄▄▒▒▒▒▒▒
█▀▐▒█▒▒▒▌▒▒▐▒▒▒▒▒▌▀▀▄▒▒▒
 """
    }

    fun lab():String{
        return """
        """.trimIndent()
    }

    fun s():String{
        return """__________________________________________________
__________________¶¶¶¶¶¶¶¶¶¶¶¶¶¶__________________
______________¶¶¶¶_____________¶¶¶¶¶______________
___________¶¶¶_____________________¶¶¶¶___________
________¶¶¶¶__________________________¶¶¶_________
_______¶¶_______________________________¶¶¶_______
______¶¶__________________________________¶¶______
____¶¶_____________________________________¶¶_____
____¶________________________________________¶____
___¶¶________________________________________¶¶___
__¶¶_____________¶¶¶__________________________¶___
___¶___________¶¶_____________________________¶¶__
___¶___________¶________________¶¶¶___________¶¶__
___¶_____¶¶_¶¶_¶¶¶¶¶_¶____________¶¶¶__________¶__
___¶_________¶___¶¶¶¶¶¶¶¶¶¶¶¶______¶¶¶_________¶__
___¶¶______¶¶¶¶___¶¶¶¶¶¶¶¶¶¶¶¶¶¶____¶¶¶_¶¶____¶¶¶_
___¶¶____¶¶¶¶¶¶___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶__¶¶__
___¶____¶¶¶¶¶¶¶____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶___
__¶¶___¶¶¶¶¶¶¶¶____¶¶¶¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶___
____¶¶¶¶¶¶¶¶¶¶______¶¶¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶____
______¶¶¶¶¶¶¶___¶¶_____¶¶¶¶¶¶¶¶¶____¶¶¶¶¶¶¶¶¶¶____
______¶__¶¶¶____¶¶¶___________________¶¶¶¶¶¶¶_____
_____¶¶________¶¶¶¶¶¶__¶________________¶¶¶_______
_____¶¶______¶¶¶____¶¶¶¶______________¶¶¶¶________
______¶¶______¶_______¶¶_________¶¶¶¶¶¶¶¶¶________
_______¶¶¶¶¶_______________¶_¶¶¶¶¶¶¶¶¶¶¶¶¶________
___________¶¶¶____¶¶¶¶_¶¶_¶¶¶___¶¶¶¶¶___¶¶________
____________¶¶¶¶¶_¶__¶¶_¶_¶_¶____¶¶_____¶_________
_____________¶_____________¶¶_____¶_____¶_________
______________¶¶¶¶¶_¶¶¶¶¶¶________¶¶____¶_________
____________________¶¶¶¶¶¶_________¶____¶_________
_____________________¶¶_¶¶_________¶¶___¶¶________
______________________¶¶¶¶¶_________¶____¶________
_______________________¶¶¶¶¶_______¶¶____¶¶_______
_______________________¶¶¶¶¶______¶_¶_____¶_______
_______________________¶_¶¶¶_____¶__¶¶____¶_______
_______________________¶¶¶¶¶____¶¶__¶¶___¶________
_______________________¶¶¶¶¶__¶¶¶__¶¶___¶_________
________________________¶¶¶¶¶¶¶__¶¶¶___¶¶_________
_________________________¶¶_____¶¶¶____¶__________
____________________________¶¶¶¶______¶___________
______________________________¶¶_____¶¶___________
_______________________________¶¶¶¶¶¶¶____________
__________________________________________________
"""
    }
}