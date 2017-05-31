package edu.vt.ece.laice.laicelib

import org.python.core.PyFloat
import org.python.core.PyString

/**
 * Created by cameronearle on 5/31/17.
 */
class LAICEData(val map: Map<String, Any>) {
    companion object {
        private const val SAMPLES_MAX = 64 //The maximum number of samples in a data set
    }

    /// General access methods
    /**
     * Gets a value in raw Python form from the parser
     *
     * @param key The name of the value to grab
     * @return The raw Python value
     */
    fun get(key: String) = map[key]

    /**
     * Gets a value as a Java string
     *
     * @param key The name of the value to grab and convert to string
     * @return The value as a string
     */
    fun getString(key: String) = (map[key] as PyString).string

    /**
     * Gets a value as a Java double
     *
     * @param key The name of the value to grab and convert to double
     * @return The value as a double
     */
    fun getDecimal(key: String) = (map[key] as PyFloat).value

    /// Specialized access methods
    /**
     * Gets a current sample in amps from the RPA at the specified point
     *
     * @param sample The sample number to grab
     * @return The sample avlue in amps
     */
    fun getRPACurrentSample(sample: Int) = getDecimal("RPA_currentSample${sample}_Amps")

    /**
     * Gets a voltage sample in volts from the RPA at the specified point
     *
     * @param sample The sample number to grab
     * @return The sample value in volts
     */
    fun getRPAVoltageSample(sample: Int) = getDecimal("RPA_voltageSample${sample}_Volts")

    /**
     * Gets the entire set of current samples from the RPA in amps
     *
     * @return The ordered set of values in amps
     */
    fun getRPACurrentSamples() = (1..SAMPLES_MAX).map { getRPACurrentSample(it) }

    /**
     * Gets the entire set of voltage samples from the RPA in volts
     *
     * @return The ordered set of values in volts
     */
    fun getRPAVoltageSamples() = (1..SAMPLES_MAX).map { getRPACurrentSample(it) }

}