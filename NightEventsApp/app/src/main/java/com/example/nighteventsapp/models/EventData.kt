package com.example.nighteventsapp.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class Event (
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val isFavorite: MutableState<Boolean>,
    val isSubscribed: MutableState<Boolean>,
    val imageUrl: String
)

val eventList = listOf(
    Event(
        id = 1,
        title = "Sana 2025",
        description = "A Superamostra Nacional de Animes (SANA) é um tradicional evento realizado anualmente pela Fundação Cultural Nipônica Brasileira que reúne fãs de anime, mangá, tokusatsu, videogames, cultura geek, em geral, bem como artistas e ícones do gênero em uma convenção realizada na cidade de Fortaleza, Ceará.",
        date = "24 - 01 - 2O25",
        location = "Centro de Eventos do Ceará",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageUrl = "https://images.sympla.com.br/66945a5acb453-lg.png"
    ),
    Event(
        id = 2,
        title = "Titãs - Encontro",
        description = "Último show da banda Titãs em Fortaleza",
        date = "9 - 11 - 2O24",
        location = "Arena Barong",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageUrl = "https://cdn.topmidianews.com.br/upload/dn_arquivo/2023/11/653bf26e22bea-capa.jpg"
    ),
    Event(
        id = 3,
        title = "100ª Corrida de São Silvestre",
        description = "A Corrida Internacional de São Silvestre chega à centésima edição em 2025, ano em que ela completa cem anos, isto é, trata-se também do centenário da mais tradicional prova pedestre do Brasil.",
        date = "31 - 12 - 2O24",
        location = "Avenida Paulista",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageUrl = "https://esportividade.com.br/wp-content/uploads/2023/12/saosilvestre2023_alto.jpg"
    ),
    Event(
        id = 4,
        title = "Oficina de Desenho",
        description = "A Oficina de Desenho tem como objetivo de ajudar os seus participantes a darem o primeiro passo no mundo do desenho",
        date = "23 - 4 - 2O25",
        location = "UFC Quixadá - Bloco 4 - Sala de Desenho",
        isFavorite = mutableStateOf(false),
        isSubscribed = mutableStateOf(false),
        imageUrl = "https://img.freepik.com/fotos-gratis/crianca-com-desenho-de-capacete-de-astronauta_53876-133700.jpg?t=st=1734406372~exp=1734409972~hmac=7c1d889c4a53ce462d4283cf8583ea8877b31f1f41b43c9e3822a1d55d82b796&w=900"
    ),
)