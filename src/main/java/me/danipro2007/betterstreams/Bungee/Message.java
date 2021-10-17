package me.danipro2007.betterstreams.Bungee;

import java.util.List;

public class Message
{
    private List<String> sentences;
    private String name;
    
    public Message(final String messageName, final List<String> lines) {
        this.name = messageName;
        this.sentences = lines;
    }
    
    public List<String> getSentences() {
        return this.sentences;
    }
    
    public String getName() {
        return this.name;
    }
}
