package com.braincells.solitaire
import org.junit.Test

/**
 * Created by jaldhar on 6/3/17.
 */

class GameTest {
    @Test
    fun kingInFirstFoundationPile() {
        // arrange
        var numGames = 0
        val maxGames = 10000

        // act
        for (i in 1 .. maxGames) {
            numGames++
            GameModel.resetGame()
            for (j in 2 .. 100) {
                GamePresenter.onDeckTap()
                GamePresenter.onWasteTap()
                GameModel.tableauPiles.forEachIndexed {
                    index, tableauPile -> GamePresenter.onTableauTap(index, tableauPile.cards.lastIndex)
                }
            }
            if (GameModel.foundationPiles[0].cards.size == 13) {
                break
            }
        }

        // assert
        GameModel.debugPrint()
        println("# games: $numGames")
        assert(numGames < maxGames)
    }
}