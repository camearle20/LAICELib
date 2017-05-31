package edu.vt.ece.laice.laicelib


/**
 * Created by cameronearle on 5/31/17.
 */

fun main(args: Array<String>) {
    val data = LAICEParser.fromFile("vtPowerUpData.bin")
    println(data.map)
}