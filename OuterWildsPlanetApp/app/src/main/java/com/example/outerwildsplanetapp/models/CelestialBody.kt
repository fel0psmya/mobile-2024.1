package com.example.outerwildsplanetapp.models

import com.example.outerwildsplanetapp.R

data class CelestialBody(
    val id: Int,
    val name: String,
    val type: String,
    val location: String,
    val gravity: String?,
    val characteristics: String,
    val imageUrl: String,
    var isFavorite: Boolean = false
)

val celestialBodiesList = listOf(
    CelestialBody(
        id = 1,
        name = "The Sun",
        type = "Star",
        location = "Center of the Solar System",
        gravity = null,
        characteristics = "The Sun is the center of the Solar System and the celestial body which all other astronomical bodies orbit.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/7/78/Sun_1.png/revision/latest?cb=20190718232107"
    ),
    CelestialBody(
        id = 2,
        name = "Hourglass Twins",
        type = "Binary planets",
        location = "1st planet from Sun",
        gravity = "0.6 to 1.6 g",
        characteristics = "The Hourglass Twins are binary planets orbiting each other. Ember Twin is mostly desert rock divided into two halves by a wide equatorial canyon, and Ash Twin is almost entirely made of sand laid over a black, rocky core. Both planets orbit very closely to the Sun.\n" +
                "\n" +
                "The twin planets' gravitational pull on each other changes from time to time, resulting in a natural phenomenon where sand is passed from one to the other over the course of about twenty minutes, creating the \"hourglass\" effect.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/6/68/Hourglass_twins.png/revision/latest/scale-to-width-down/1000?cb=20211019125643"
    ),
    CelestialBody(
        id = 3,
        name = "Timber Hearth",
        type = "Terrestrial Planet",
        location = "2nd planet from Sun",
        gravity = "1.0g",
        characteristics = "Timber Hearth is the home planet of the Hearthians. It has a mainly rocky composition accented with forests, ridges, and waterfalls. Alongside the Hearthians, fireflies, crickets, and a few varieties of fish make up the fauna of the planet's ecosystem. The terrain has little variation outside of grassy plains, mountains, rivers, and large craters, one of which forms the area of the village.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/e/ec/Timberhearth_1.png/revision/latest?cb=20190718012215"
    ),
    CelestialBody(
        id = 4,
        name = "Brittle Hollow",
        type = "Planet",
        location = "3rd planet from Sun",
        gravity = "0.8 to 1.1 g",
        characteristics = "Brittle Hollow is a highly unstable planet that formed naturally around the black hole at its center. Its dry, rocky surface is fractured and prone to collapse, and in each 22-minute cycle of game time, the player can observe as most of the planet's crust breaks away and falls into the black hole. These pieces then emerge at the White Hole next to the White Hole Station. This collapse is precipitated by the balls of lava ejected from the planet's moon, which rain down steadily and crash into Brittle Hollow's surface.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/3/3f/Brittle_Hollow_BH.png/revision/latest/scale-to-width-down/1000?cb=20211019130345"
    ),
    CelestialBody(
        id = 5,
        name = "Giant's Deep",
        type = "Ocean Planet",
        location = "4th planet from Sun",
        gravity = "2.0 to 3.0 g",
        characteristics = "Giant's Deep is an ocean planet made of increasingly dense fluid layers, with five small islands on the surface. Filled with turbulent weather and a dense atmosphere, massive cyclones frequently form and travel along the surface of the water. The planet has a coral core surrounded by very dense fluid.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/7/77/Giant%27s_Deep.png/revision/latest?cb=20190718012339"
    ),
    CelestialBody(
        id = 6,
        name = "Dark Bramble",
        type = "Planetary Remnant (originally ice planet)",
        location = "5th planet from Sun",
        gravity = "0g (Interior) 0.4g (Exterior)",
        characteristics = "Dark Bramble is a large, confusing network of twisted vines and teleportation passages, the imploded remnants of a fifth planet that has long since been infected and overrun by space-bending plant growth. It is the only planet to feature hostile wildlife in the form of Anglerfish.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/8/83/Dark_Bramble.png/revision/latest?cb=20190718012112"
    ),
    CelestialBody(
        id = 7,
        name = "Attlerock",
        type = "Moon",
        location = "Orbiting Timber Hearth",
        gravity = "0.3g (equator) - 0.4g (poles)",
        characteristics = "The Attlerock is the only natural satellite of Timber Hearth. It is almost entirely barren, the terrain mostly level except where it is pocked with deep craters. There are a few large craters with pieces of information in them, along with being the first mention of the Eye of the Universe in Nomai texts.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/4/44/The_Attlerock.png/revision/latest?cb=20200418173429"
    ),
    CelestialBody(
        id = 8,
        name = "Hollow's Lantern",
        type = "Moon",
        location = "Orbiting Brittle Hollow",
        gravity = "0.5g",
        characteristics = "Hollow's Lantern is a relatively small but highly volcanic moon orbiting Brittle Hollow.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/8/8f/Hollow%27s_lantern.png/revision/latest/scale-to-width-down/1000?cb=20211019131323"
    ),
    CelestialBody(
        id = 9,
        name = "White Hole",
        type = "Singularity",
        location = "Outskirts of the Solar System",
        gravity = "0g",
        characteristics = "The White Hole is a singularity, and the paired opposite to Brittle Hollow's black hole, from which objects may exit from, but not return through. Objects that fall into Brittle Hollow's black hole disappear and exit from the White Hole. Being the opposite of the black hole, the White Hole's reverse gravity repels any attempts to land on its surface.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/d/d0/White_Hole_Brittle_Hollow.png/revision/latest/scale-to-width-down/1000?cb=20201026131621"
    ),
    CelestialBody(
        id = 10,
        name = "The Interloper",
        type = "Comet",
        location = "Elliptical orbit around Sun",
        gravity = "0g to 0.4g",
        characteristics = "Interloper is a comet on a highly elliptical orbit around the sun. It is relatively small, but is fairly easy to land on. Due to the Interloper's lack of gravity in its interior, it would be advised to explore this comet on the highest part of its orbit or it is possible to be pulled away into the Sun. It is the newest celestial object in the solar system and is the origin of all Ghost Matter in the solar system.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/7/7c/The_Interloper.png/revision/latest?cb=20190718011901"
    ),
    CelestialBody(
        id = 11,
        name = "Quantum Moon",
        type = "Moon",
        location = "Each Planet",
        gravity = "0.4g",
        characteristics = "The Quantum Moon is a planetary object in a state of constant quantum superposition in the Solar System. It exists in orbit around six different large astral bodies at once until it is observed by a conscious observer.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/5/5d/Quantum_moon.png/revision/latest?cb=20190722160001"
    ),
    CelestialBody(
        id = 12,
        name = "Orbital Probe Canon",
        type = "Satellite",
        location = "Giant's Deep orbit",
        gravity = "0g",
        characteristics = "The Orbital Probe Cannon is a large Nomai satellite found in orbit around Giant's Deep, designed to launch a probe from orbit at great speed. The Cannon fires at the beginning of every cycle in a random direction and breaks apart, but its ruins and most of its modules still remain in orbit around Giant Deep.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/b/b8/Orbital-probe-cannon.png/revision/latest/scale-to-width-down/1000?cb=20201017123119"
    ),
    CelestialBody(
        id = 13,
        name = "Eye of The Universe",
        type = "Planet",
        location = "Distant orbit from the Sun",
        gravity = "0.4g - 2.5g",
        characteristics = "The Eye of the Universe is a planetary object older than the Universe itself which is in a distant orbit around the Sun.",
        imageUrl = "https://static.wikia.nocookie.net/outerwilds_gamepedia/images/e/ef/Eye_Symbol.png/revision/latest?cb=20210716182004"
    )
)
