package com.example.moodbyte.components.chatbotcomponents

import java.util.Random

class ChatBot {
    private val rnd = Random(System.currentTimeMillis())

    // Respuestas básicas por emoción
    private val frases = mapOf(

        "Feliz" to listOf(
            "Me alegra verte feliz 😊",
            "Sigue con esa energía positiva",
            "Tu felicidad es contagiosa",
            "Ese ánimo es increíble",
            "Estás en un gran momento",
            "Aprovecha este buen estado",
            "Se nota que estás bien",
            "Todo parece ir genial",
            "Tu sonrisa lo dice todo",
            "Sigue disfrutando este momento"
        ),

        "Triste" to listOf(
            "Todo mejorará, ánimo 💙",
            "Es normal sentirse triste a veces",
            "Estoy contigo, no estás solo",
            "Respira profundo, pasará",
            "Las emociones cambian",
            "Mañana será mejor",
            "Tómate tu tiempo",
            "Es válido sentirse así",
            "Eres más fuerte de lo que crees",
            "Esto es temporal"
        ),

        "Enfadado" to listOf(
            "Respira antes de actuar",
            "La calma es tu mejor aliada",
            "Cuenta hasta 10",
            "No dejes que el enfado te controle",
            "Relájate un momento",
            "Todo puede solucionarse",
            "Tu tranquilidad es importante",
            "Controla la emoción",
            "Respira profundo",
            "Puedes manejar esto"
        ),

        "Neutral" to listOf(
            "Todo está tranquilo",
            "Estado equilibrado",
            "Sigues estable",
            "Nada fuera de lo normal",
            "Buen control emocional",
            "Todo fluye normal",
            "Sin cambios importantes",
            "Estado relajado",
            "Mantén el equilibrio",
            "Todo está en calma"
        ),

        "Sorpresa" to listOf(
            "Eso fue inesperado 😮",
            "Algo llamó tu atención",
            "Interesante reacción",
            "Eso te sorprendió",
            "Tu curiosidad se activó",
            "Algo nuevo apareció",
            "Momento inesperado",
            "Eso fue diferente",
            "Reacción interesante",
            "Algo captó tu atención"
        ),

        "Miedo" to listOf(
            "Todo está bien",
            "No hay peligro real",
            "Respira, estás seguro",
            "Es solo una emoción",
            "Puedes controlarlo",
            "Mantén la calma",
            "Nada malo está pasando",
            "Tu mente se calmará",
            "Confía en ti",
            "Estás a salvo"
        ),

        "Asco" to listOf(
            "Eso no te agradó",
            "Reacción natural",
            "Tu mente rechazó eso",
            "Es una emoción válida",
            "Normal sentir rechazo",
            "Tu reacción es clara",
            "Eso te incomodó",
            "Tu cerebro reaccionó rápido",
            "Reacción automática",
            "Nada fuera de lo común"
        )
    )


    // URLs de ayuda por emoción
    private val urlsAyuda = mapOf(

        "Triste" to listOf(
            "https://www.youtube.com/watch?v=ZToicYcHIOU",
            "https://www.youtube.com/watch?v=inpok4MKVLM",
            "https://www.headspace.com/meditation/sleep",
            "https://www.calm.com/"
        ),

        "Miedo" to listOf(
            "https://www.youtube.com/watch?v=odADwWzHR24",
            "https://www.youtube.com/watch?v=MIr3RsUWrdo",
            "https://www.calm.com/breathe",
            "https://www.headspace.com/anxiety"
        ),

        "Enfadado" to listOf(
            "https://www.youtube.com/watch?v=lFcSrYw-ARY",
            "https://www.youtube.com/watch?v=6p_yaNFSYao",
            "https://www.calm.com/",
            "https://www.headspace.com/meditation/anger"
        ),

        "Ansiedad" to listOf(
            "https://www.youtube.com/watch?v=O-6f5wQXSu8",
            "https://www.youtube.com/watch?v=SEfs5TJZ6Nk",
            "https://www.headspace.com/anxiety",
            "https://www.calm.com/breathe"
        ),

        "Neutral" to listOf(
            "https://www.youtube.com/watch?v=2OEL4P1Rz04",
            "https://www.calm.com/",
            "https://www.headspace.com/"
        ),

        "Feliz" to listOf(
            "https://www.youtube.com/watch?v=9bZkp7q19f0",
            "https://www.youtube.com/watch?v=d-diB65scQU"
        )
    )

    // Respuestas especiales por palabras clave
    private val respuestasEspeciales = mapOf(

        // SALUDOS
        "hola" to "Hola, estoy aquí contigo 😊",
        "buenas" to "Buenas, puedes contar conmigo",
        "hey" to "Hola, ¿cómo te sientes ahora?",
        "hi" to "Hola, estoy aquí para escucharte",
        "holi" to "Hola 😊 estoy aquí contigo",
        "que tal" to "Estoy aquí contigo. Puedes contarme cómo te sientes",

        // DESPEDIDAS
        "adios" to "Hasta luego. Recuerda que no estás solo 💙",
        "chao" to "Cuídate mucho 💙",
        "hasta luego" to "Aquí estaré cuando lo necesites",
        "me voy" to "Está bien. Estoy aquí cuando quieras volver",

        // AGRADECIMIENTO
        "gracias" to "No hay de qué. Estoy aquí para ayudarte",
        "muchas gracias" to "Me alegra poder ayudarte",
        "te lo agradezco" to "Siempre puedes contar conmigo",

        // AYUDA
        "ayuda" to "Estoy aquí contigo. Puedes contarme qué te pasa",
        "necesito ayuda" to "Gracias por decirlo. Hablar es importante",
        "puedes ayudarme" to "Sí, estoy aquí para escucharte",
        "no estoy bien" to "Lo siento. Estoy aquí contigo 💙",
        "me siento mal" to "Gracias por compartirlo. Estoy contigo",

        // TRISTEZA
        "triste" to "Lo siento. Tus emociones son importantes 💙",
        "muy triste" to "Estoy contigo. Este sentimiento pasará",
        "deprimido" to "Lo siento. No estás solo en esto",
        "depresion" to "La depresión es dura, pero no estás solo",
        "quiero llorar" to "Llorar puede ayudar a liberar emociones",
        "llorar" to "Está bien llorar. Es parte del proceso",
        "me duele" to "Lo siento. Estoy aquí contigo",

        // ANSIEDAD
        "ansiedad" to "Respira profundo. Estoy contigo",
        "ansioso" to "Todo pasará. Respira lentamente",
        "estres" to "El estrés puede ser duro. Tómate un momento",
        "estresado" to "Respira. Este momento pasará",
        "agobiado" to "Es normal sentirse así. Estoy contigo",
        "no puedo respirar" to "Respira lento. Estás a salvo",
        "panico" to "Estoy contigo. Respira despacio",

        // SOLEDAD
        "solo" to "No estás solo. Estoy aquí contigo 💙",
        "solitario" to "Tu presencia importa",
        "me siento solo" to "Estoy aquí contigo. No estás solo",
        "nadie me quiere" to "Tu vida tiene valor. Estoy contigo",
        "nadie me entiende" to "Lo siento. Estoy aquí para escucharte",
        "estoy solo" to "Estoy contigo en este momento",

        // AUTOESTIMA
        "no valgo nada" to "Sí tienes valor. Tu vida importa 💙",
        "soy inutil" to "No eres inútil. Eres importante",
        "soy un fracaso" to "Un fracaso no define quién eres",
        "me odio" to "Lo siento. Mereces apoyo y comprensión",
        "odio mi vida" to "Tu vida es importante 💙",
        "soy basura" to "No lo eres. Tu vida tiene valor",
        "no sirvo para nada" to "Sí importas. Estoy contigo",

        // MIEDO
        "tengo miedo" to "Estoy contigo. Estás a salvo",
        "asustado" to "Respira. Todo está bien ahora",
        "tengo miedo de todo" to "Estoy aquí contigo",
        "no me siento seguro" to "Estoy contigo. Respira despacio",

        // CRISIS
        "no puedo mas" to "Lo siento. Respira. Este momento pasará 💙",
        "no aguanto mas" to "Estoy contigo. Respira profundo",
        "estoy cansado de todo" to "Es válido sentirse así. Estoy contigo",
        "quiero desaparecer" to "Tu vida importa. Estoy contigo 💙",
        "todo es inutil" to "Aunque ahora duela, tu vida importa",
        "me siento vacio" to "Ese sentimiento es duro. Estoy contigo",

        // SUICIDIO
        "quiero morir" to "Tu vida es importante. No estás solo 💙",
        "morir" to "Tu vida tiene valor. Estoy contigo",
        "suicidio" to "Hablar con alguien puede ayudarte mucho 💙",
        "matarme" to "Estoy contigo. Este sentimiento pasará",
        "no quiero vivir" to "Lo siento. Tu vida importa 💙"
    )

    fun responder(pregunta: String, emocion: String): Respuesta {
        val preguntaLower = pregunta.lowercase().trim()

        // Primero revisamos si hay palabra clave
        respuestasEspeciales.forEach { (key, value) ->
            if (preguntaLower.contains(key)) {
                val url = urlsAyuda[emocion]?.random()
                return Respuesta(value, url)
            }
        }

        // Si no hay palabra clave, usamos emoción
        val lista = frases[emocion] ?: frases["Neutral"]!!
        val texto = lista.random()
        val url = urlsAyuda[emocion]?.random()

        return Respuesta(texto, url)
    }
}