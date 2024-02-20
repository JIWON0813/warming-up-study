package com.group.libraryapp.homework5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiceController {

    @GetMapping("/api/dice")
    public String dice(@RequestParam int tryCount, @RequestParam int diceCount) {
        int[] diceArray = rollByCount(tryCount, diceCount);

        String result = writeResult(diceArray);

        return result;
    }

    private int[] rollByCount(int tryCount, int diceCount) {
        int[] diceArray = new int[diceCount];

        for (int i = 0; i < tryCount; i++) {
            int index = (int) (Math.random() * diceCount);
            diceArray[index]++;
        }

        return diceArray;
    }

    private String writeResult(int[] diceArray) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < diceArray.length; i++) {
            String line = String.format("%d는 %d번 나왔습니다.\n", i + 1, diceArray[i]);
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }
}
