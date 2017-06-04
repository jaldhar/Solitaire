package com.braincells.solitaire

/**
 * Created by jaldhar on 6/2/17.
 */
fun main(args: Array<String>) {
    GameModel.resetGame()
    GamePresenter.onDeckTap()
    GameModel.debugPrint()
}