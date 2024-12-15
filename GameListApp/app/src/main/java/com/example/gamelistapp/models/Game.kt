package com.example.gamelistapp.models

import com.example.gamelistapp.R

data class Game(
    val id: Int,  // ID único do jogo
    val name: String,  // Nome do jogo
    val imageUrl: String,  // URL da imagem da capa do jogo
    val trailerUrl: String?, // URL do trailer
    val description: String,  // Descrição do jogo
    val platforms: List<String>?,  // Plataformas do jogo
    val releaseDate: String,  // Ano de lançamento
    val screenshots: List<String>?,  // URLs de screenshots
    val isFavorite: Boolean = false  // Se o jogo é favorito

    /* val genres: List<Genre>,  // Gêneros do jogo

    val videoUrl: String?,  // URL do vídeo do jogo (opcional)

    val developers: List<Developer>?,  // Desenvolvedores do jogo
    val publishers: List<Publisher>?,  // Publishers do jogo
    val similar_games: List<Int>?, // Quantidade de jogos similarea
    val rating: Double?,  // Nota do jogo

     */
)


data class ReleaseDate(
    val date: Long  // Timestamp da data de lançamento
)

/*
data class Genre(
    val name: String  // Nome do gênero
)

data class Platform(
    val name: String  // Nome da plataforma
)

data class Developer(
    val name: String  // Nome do desenvolvedor
)

data class Publisher(
    val name: String  // Nome do publisher
)*/

val gameList = listOf(
    Game (
        id = 1,
        name = "Enigma do Medo",
        imageUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co93ft.webp",
        trailerUrl = "https://www.youtube.com/watch?v=Hjl6usm5WCo",
        description = "Become Mia, a paranormal detective searching for her missing father inside the Perimeter - a place that doesn't exist. Investigate clues like a real detective and unravel the mysteries behind the Enigma of Fear, defeating the terrible monsters who'll try to stop you.",
        platforms = listOf("PC"),
        releaseDate = "2024",
        screenshots = listOf("https://images.igdb.com/igdb/image/upload/t_720p/schjpq.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/schjpo.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/schjpt.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/schjpn.webp")
    ),
    Game (
        id = 2,
        name = "Stardew Valley",
        imageUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/xrpmydnu9rpxvxfjkiu7.webp",
        trailerUrl = "https://www.youtube.com/watch?v=8A7A1X1TVNc",
        description = "Stardew Valley is an open-ended country-life RPG! You’ve inherited your grandfather’s old farm plot in Stardew Valley. Armed with hand-me-down tools and a few coins, you set out to begin your new life. Can you learn to live off the land and turn these overgrown fields into a thriving home? It won’t be easy. Ever since Joja Corporation came to town, the old ways of life have all but disappeared. The community center, once the town’s most vibrant hub of activity, now lies in shambles. But the valley seems full of opportunity. With a little dedication, you might just be the one to restore Stardew Valley to greatness!",
        platforms = listOf("Android", "iOS", "Linux", "Mac", "Nintendo Switch", "PC (Microsoft Windows)", "PlayStation 4", "PlayStation Vita", "Wii U", "Xbox One"),
        releaseDate = "2016",
        screenshots = listOf("https://images.igdb.com/igdb/image/upload/t_720p/rhxs1x9w5hf5kde2osf5.webp"
                ,"https://images.igdb.com/igdb/image/upload/t_720p/iwswpvxa9ytrpk8yjcyx.webp"
                ,"https://images.igdb.com/igdb/image/upload/t_720p/sw7rtba7p1xs77klsime.webp"
                ,"https://images.igdb.com/igdb/image/upload/t_720p/g1aakqbkp2quq0krqeky.webp"
                ,"https://images.igdb.com/igdb/image/upload/t_720p/g1aakqbkp2quq0krqeky.webp"
        )
    ),
    Game (
        id = 3,
        name = "Disco Elysium",
        imageUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co1sfj.webp",
        trailerUrl = "https://www.youtube.com/watch?v=SEJOJ4AUBic",
        description = "A CRPG in which, waking up in a hotel room a total amnesiac with highly opinionated voices in his head, a middle-aged detective on a murder case inadvertently ends up playing a part in the political dispute between a local labour union and a larger international body, all while struggling to piece together his past, diagnose the nature of the reality around him and come to terms with said reality.",
        platforms = listOf("Mac", "PC (Microsoft Windows)"),
        releaseDate = "2019",
        screenshots = listOf("https://images.igdb.com/igdb/image/upload/t_720p/jgfwlctsfh8yljnjdeab.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/qfml0sjrmeiv5gf6tgg1.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/ar4m6.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/ar4m8.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/ar4m5.webp")
    ),
    Game (
        id = 4,
        name = "Deltarune",
        imageUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co3w7g.webp",
        trailerUrl = null,
        description = "UNDERTALE's parallel story, DELTARUNE. Meet new and old characters in a tale that steps closer to its end, chapter by chapter. Dodge bullets in nonviolent RPG battles as you listen to funky, funky music.",
        platforms = listOf("Mac", "Nintendo Switch", "PC (Microsoft Windows)", "PlayStation 4"),
        releaseDate = "TBD",
        screenshots = listOf("https://images.igdb.com/igdb/image/upload/t_720p/scdl5l.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/scdl5m.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/scdl5k.webp")
    ),
    Game (
        id = 5,
        name = "The Last Of Us Part I",
        imageUrl = "https://images.igdb.com/igdb/image/upload/t_cover_big/co5xex.webp",
        trailerUrl = "https://www.youtube.com/watch?v=LW5NwaUXgIA",
        description = "Experience the emotional storytelling and unforgettable characters of Joel and Ellie in The Last of Us, winner of over 200 Game of the Year awards and now rebuilt for PlayStation 5.\n" +
                "\n" +
                "Enjoy a total overhaul of the original experience, faithfully reproduced but incorporating modernized gameplay, improved controls and expanded accessibility options. Plus, feel immersed with improved effects and enhanced exploration and combat.\n" +
                "\n" +
                "It also includes the Left Behind story DLC.",
        platforms = listOf("PC (Microsoft Windows)", "Playstation 5"),
        releaseDate = "2022",
        screenshots = listOf("https://images.igdb.com/igdb/image/upload/t_720p/schcg6.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/schcg7.webp",
            "https://images.igdb.com/igdb/image/upload/t_720p/scq0k5.webp")
    )
)