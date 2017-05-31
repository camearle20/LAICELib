package edu.vt.ece.laice.laicelib

import edu.vt.ece.laice.laicelib.python.PythonExecutor
import java.io.File

/**
 * Created by cameronearle on 5/31/17.
 */
object LAICEParser {
    fun fromFile(filePath: String): LAICEData {
        val file = File(filePath)
        val rawData = file.readBytes()
        val map = PythonExecutor.parse(rawData)
        return LAICEData(map)
    }

    fun fromRaw(rawData: ByteArray): LAICEData {
        val map = PythonExecutor.parse(rawData)
        return LAICEData(map)
    }
}