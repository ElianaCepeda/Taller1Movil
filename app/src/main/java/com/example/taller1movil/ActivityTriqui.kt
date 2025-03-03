package com.example.taller1movil

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller1movil.databinding.ActivityTriquiBinding

class ActivityTriqui : AppCompatActivity() {
    private lateinit var binding: ActivityTriquiBinding
    private var currentPlayer = "X"
    private val board = Array(3) { arrayOfNulls<String>(3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTriquiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setButtonListeners()
        binding.btnNewGame.setOnClickListener { resetGame() }
    }

    private fun setButtonListeners() {
        val buttons = arrayOf(
            binding.btn0, binding.btn1, binding.btn2,
            binding.btn3, binding.btn4, binding.btn5,
            binding.btn6, binding.btn7, binding.btn8
        )

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener { onCellClick(button, index) }
        }
    }

    private fun onCellClick(button: Button, index: Int) {
        val row = index / 3
        val col = index % 3

        if (board[row][col] == null) {  // Only allow moves on empty cells
            board[row][col] = currentPlayer
            button.text = currentPlayer

            if (checkWin()) {
                val message = "Jugador $currentPlayer gano!"
                binding.playerTurn.text = message
                showToast(message)
                disableBoard()
            } else {
                currentPlayer = if (currentPlayer == "X") "O" else "X"
                binding.playerTurn.text = "Turno: Jugador $currentPlayer"
            }
        }
    }

    private fun checkWin(): Boolean {
        for (i in 0..2) {
            if (board[i][0] != null && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true
            if (board[0][i] != null && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true
        }
        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true
        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true
        return false
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun disableBoard() {
        val buttons = arrayOf(
            binding.btn0, binding.btn1, binding.btn2,
            binding.btn3, binding.btn4, binding.btn5,
            binding.btn6, binding.btn7, binding.btn8
        )
        buttons.forEach { it.isEnabled = false }
    }

    private fun resetGame() {
        board.forEach { row -> row.fill(null) }
        currentPlayer = "X"
        binding.playerTurn.text = "Turno: Jugador X"

        val buttons = arrayOf(
            binding.btn0, binding.btn1, binding.btn2,
            binding.btn3, binding.btn4, binding.btn5,
            binding.btn6, binding.btn7, binding.btn8
        )
        buttons.forEach {
            it.text = ""
            it.isEnabled = true
        }
    }
}
