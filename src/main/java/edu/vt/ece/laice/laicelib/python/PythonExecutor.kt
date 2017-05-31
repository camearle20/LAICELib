package edu.vt.ece.laice.laicelib.python

import edu.vt.ece.laice.laicelib.exception.ParseException
import org.python.core.PyByteArray
import org.python.core.PyFunction
import org.python.core.PyStringMap
import org.python.util.PythonInterpreter

/**
 * Created by cameronearle on 5/31/17.
 */
object PythonExecutor {
    private val interpreter = PythonInterpreter()
    private val parseFunction: PyFunction

    init {
        interpreter.execfile("LAICEParser_v2.py")
        parseFunction = interpreter.get("parse") as PyFunction
    }

    fun parse(input: ByteArray): Map<String, Any> {
        try {
            return (parseFunction.__call__(PyByteArray(input)) as PyStringMap).map as Map<String, Any>
        } catch (e: Exception) {
            throw ParseException("Error parsing input data $input", e)
        }
    }
}