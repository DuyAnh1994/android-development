package com.dev.anhnd.mybase.utils.media

import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.Extractor
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.extractor.amr.AmrExtractor
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor
import java.util.*

/**
 * Exoplayer can not seek aac file, for seek acc file, create this
 */
class SeekAbleExtractorsFactory : ExtractorsFactory {

    private var defaultExtractorClasses: List<Class<out Extractor?>>? = null

     init{
        synchronized(DefaultExtractorsFactory::class.java) {
            if (defaultExtractorClasses == null) {
                // Lazily initialize defaultExtractorClasses.
                val extractorClasses: MutableList<Class<out Extractor?>> = ArrayList()
                // We reference extractors using reflection so that they can be deleted cleanly.
                // Class.forName is used so that automated tools like proguard can detect the use of
                // reflection (see http://proguard.sourceforge.net/FAQ.html#forname).
                // We reference extractors using reflection so that they can be deleted cleanly.
                // Class.forName is used so that automated tools like proguard can detect the use of
                // reflection (see http://proguard.sourceforge.net/FAQ.html#forname).
                try {
                    extractorClasses.add(
                        Class.forName("com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.mp4.Mp4Extractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.mp3.Mp3Extractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.ts.AdtsExtractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.ts.Ac3Extractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.ts.TsExtractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.flv.FlvExtractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.ogg.OggExtractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.ts.PsExtractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.extractor.wav.WavExtractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                try {
                    extractorClasses.add(Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor::class.java))
                } catch (e: ClassNotFoundException) {
                    // Extractor not found.
                }
                defaultExtractorClasses = extractorClasses
            }
        }
    }

    override fun createExtractors(): Array<Extractor> {
        return arrayOf(
            AdtsExtractor(AdtsExtractor.FLAG_ENABLE_CONSTANT_BITRATE_SEEKING),
            AmrExtractor(AmrExtractor.FLAG_ENABLE_CONSTANT_BITRATE_SEEKING)
        )
    }
}
