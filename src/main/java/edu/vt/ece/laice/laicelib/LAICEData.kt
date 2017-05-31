package edu.vt.ece.laice.laicelib

/**
 * Created by cameronearle on 5/31/17.
 */
class LAICEData(val map: Map<String, Any>) {
    fun get(key: String) = map[key]
}