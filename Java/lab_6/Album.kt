package OOP.Java.lab_6

import kotlin.time.Duration

class Album(val albumName: String, val artist: String, val tracks: Array<Track>) {

    fun tracksInDurationRange(durationRange: ClosedRange<Duration>): Array<Track> {
        return this.tracks.filter { it.duration in durationRange }.toTypedArray()
    }

    fun totalDuration(): Duration {
        var totalDuration: Duration = Duration.ZERO
        this.tracks.forEach { totalDuration += it.duration }
        return totalDuration
    }
    override fun toString(): String {
        return "${this.albumName} by ${this.artist}\nTotal duration: ${this.totalDuration()}\nTracks:\n${this.tracks.joinToString("\n")}"
    }
}