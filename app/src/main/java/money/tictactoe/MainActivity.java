package money.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int count = 1;
    private int score1 = 0;
    private int score2 = 0;
    private TextView player1, player2;
    private MyButton b1, b2, b3, b4, b5, b6, b7, b8, b9, newGameButton, newTournamnetButton;
    private List<MyButton> buttonList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = (TextView) findViewById(R.id.player1_score);
        player2 = (TextView) findViewById(R.id.player2_score);
        b1 = (MyButton) findViewById(R.id.b1);
        b2 = (MyButton) findViewById(R.id.b2);
        b3 = (MyButton) findViewById(R.id.b3);
        b4 = (MyButton) findViewById(R.id.b4);
        b5 = (MyButton) findViewById(R.id.b5);
        b6 = (MyButton) findViewById(R.id.b6);
        b7 = (MyButton) findViewById(R.id.b7);
        b8 = (MyButton) findViewById(R.id.b8);
        b9 = (MyButton) findViewById(R.id.b9);
        newGameButton = (MyButton) findViewById(R.id.new_game);
        newTournamnetButton = (MyButton) findViewById(R.id.new_tournament);


        buttonList.add(b1);
        buttonList.add(b2);
        buttonList.add(b3);
        buttonList.add(b4);
        buttonList.add(b5);
        buttonList.add(b6);
        buttonList.add(b7);
        buttonList.add(b8);
        buttonList.add(b9);

        for (int i = 0; i < buttonList.size(); i++)
            buttonList.get(i).setOnClickListener(this);

        newGameButton.setOnClickListener(this);
        newTournamnetButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View view) {
        if (!view.equals(newGameButton) && !(view.equals(newTournamnetButton))) {
            for (int i = 0; i < buttonList.size(); i++)
                if (view.equals(buttonList.get(i)) && buttonList.get(i).wrok) {
                    create(buttonList.get(i));
                    endGame();
                }


        } else if (view.equals(newGameButton))
            reset();
        else if (view.equals(newTournamnetButton)) {
            reset();
            score1 = 0;
            score2 = 0;
            player1.setText("PLAYER A : " + score1);
            player2.setText("PLAYER B : " + score2);
        }
    }

    private void create(MyButton b) {

        b.wrok = false;
        if (count == 1) {
            b.setTextColor(Color.BLUE);
            b.setText("O");
            count = 2;
        } else {
            b.setTextColor(Color.RED);
            b.setText("X");
            count = 1;
        }
    }

    private void endGame() {
        checkEndGame(b1, b2, b3);
        checkEndGame(b4, b5, b6);
        checkEndGame(b7, b8, b9);
        checkEndGame(b1, b4, b7);
        checkEndGame(b2, b5, b8);
        checkEndGame(b3, b6, b9);
        checkEndGame(b1, b5, b9);
        checkEndGame(b3, b5, b7);

    }

    private void checkEndGame(MyButton b1, MyButton b2, MyButton b3) {
        if (b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText())) {
            if (b1.getText().equals("X") && b2.getText().equals("X") && b3.getText().equals("X")) {
                Toast.makeText(MainActivity.this, "PLAYER B WINS !", Toast.LENGTH_SHORT).show();
                score2++;
                player1.setText("PLAYER A : " + score1);
                player2.setText("PLAYER B : " + score2);
                for (int i = 0; i < buttonList.size(); i++)
                    buttonList.get(i).wrok = false;

            } else if (b1.getText().equals("O") && b2.getText().equals("O") && b3.getText().equals("O")) {
                Toast.makeText(MainActivity.this, "PLAYER A WINS ! ", Toast.LENGTH_SHORT).show();
                score1++;
                player1.setText("PLAYER A : " + score1);
                player2.setText("PLAYER B : " + score2);
                for (int i = 0; i < buttonList.size(); i++)
                    buttonList.get(i).wrok = false;
            }
        }


    }

    private void reset() {
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.get(i).wrok = true;
            buttonList.get(i).setText("");
        }
        count = 1;
    }
}
