package com.fjln1920.smarclock.Models

import kotlin.properties.Delegates

class GameLevel {
    var title: String;
    var gameLevel: String
    var time: Int
    var example: String
    var gameName: String

    constructor(title: String, gameLavel: String, time: Int, example: String, gameName: String ) {
        this.title = title
        this.gameLevel = gameLavel
        this.time = time
        this.example = example
        this.gameName = gameName
    }
}