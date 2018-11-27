package com.example.dhirajchhabraeng.calculatorlatest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

public class NoKeyBoardEditText extends android.support.v7.widget.AppCompatEditText {
    public NoKeyBoardEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onCheckIsTextEditor() {
        return false;
    }
}
