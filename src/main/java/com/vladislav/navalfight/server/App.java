package com.vladislav.navalfight.server;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        var field = FieldGenerator.generate(
                new SettingsData(10, 100, 4, 3, 2, 1)
        );
        FieldGenerator.printField(field);
    }
}
