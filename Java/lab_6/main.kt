package OOP.Java.lab_6

import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

fun main() {
    val chromatica = Album(
        "Chromatica",
        "Lady Gaga",
        arrayOf(
            Interlude(1, "Chromatica I", null, 1.minutes),
            SynthPop(2, "Alice", null, 2.minutes + 57.seconds),
            DancePop(3, "Stupid Love", null, 3.minutes + 13.seconds),
            DancePop(4, "Rain On Me", "Ariana Grande", 3.minutes + 2.seconds),
            SynthPop(5, "Free Woman", null, 3.minutes + 11.seconds),
            ElectroPop(6, "Fun Tonight", null, 2.minutes + 53.seconds),
            Interlude(7, "Chromatica II", null, 41.seconds),
            SynthPop(8, "911", null, 2.minutes + 52.seconds),
            ElectroPop(9, "Plastic Doll", null, 3.minutes + 41.seconds),
            DancePop(10, "Sour Candy", "Blackpink", 2.minutes + 37.seconds),
            DancePop(11, "Enigma", null, 2.minutes + 59.seconds),
            SynthPop(12, "Replay", null, 3.minutes + 6.seconds),
            Interlude(13, "Chromatica III", null, 27.seconds),
            ElectroPop(14, "Sine From Above", "Elton John", 4.minutes + 4.seconds),
            SynthPop(15, "1000 Doves", null, 3.minutes + 35.seconds),
            DancePop(16, "Babylon", null, 2.minutes + 41.seconds)
        )
    )

    println("$chromatica\n")

    println("${chromatica.albumName} tracks sorted by musical style:\n${chromatica.tracks.sortedBy { it.style }.joinToString("\n")}\n")

    val durationRange = 1.minutes.. 3.minutes + 30.seconds

    println(
        "${chromatica.albumName} tracks in a duration range ($durationRange):\n${chromatica.tracksInDurationRange(durationRange).joinToString("\n")}"
    )
}


