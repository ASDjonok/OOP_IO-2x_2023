package OOP.Java.lab_6

import kotlin.time.Duration

class SynthPop(numberInAlbum: Int, trackName: String, feature: String?, duration: Duration): Track(numberInAlbum, trackName, feature, duration) {
    override val style = "Synth-pop"
}