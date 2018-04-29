package com.yang;

public class TextEditor {
    private SpellChecker spellChecker;

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Inside Texteditor constructor");
        this.spellChecker = spellChecker;
    }
    public SpellChecker getSpellChecker(){
        return spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
