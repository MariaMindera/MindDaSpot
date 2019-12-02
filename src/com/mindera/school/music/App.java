package com.mindera.school.music;

import com.mindera.school.music.actions.AddMusicAction;
import com.mindera.school.music.actions.ListMusicsAction;
import com.mindera.school.music.ui.Menu;
import com.mindera.school.music.ui.Option;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite uma data: ");
            String dataRecebida = s.nextLine();
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = df.parse(dataRecebida);
            System.out.println(dt);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        Menu menu = new Menu();
//        menu.add(new Option("Inserir Musica", new AddMusicAction()));
//        menu.add(new Option("Listar Musicas", new ListMusicsAction()));
//        menu.add(new Option("Sair", new NoAction()), true);
//        menu.render();
    }
}