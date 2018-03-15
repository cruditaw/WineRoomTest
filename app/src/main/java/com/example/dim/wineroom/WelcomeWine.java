package com.example.dim.wineroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.dim.wineroom.entities.Cellar;
import com.example.dim.wineroom.entities.Grape;
import com.example.dim.wineroom.entities.Grower;
import com.example.dim.wineroom.entities.User;
import com.example.dim.wineroom.entities.Wine;

public class WelcomeWine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_wine);

        DbHelper database = DbHelper.getInstance(getApplicationContext());
        // load all lists as Model
        // make class model

        //populateDb(database);



        for (Grape grape : database.getAllGrapes()) {
            Log.i("WELCOME_WINE_TEST", "onCreate: "+grape.toString());
        }

       for (User user : database.getAllUsers()) {
            Log.i("WELCOME_WINE_TEST", "onCreate: "+user.toString());
        }

        for (Grower grower : database.getAllGrowers()) {
            Log.i("WELCOME_WINE_TEST", "onCreate: "+grower.toString());
        }

        for (Wine wine : database.getAllWines()) {
            Log.i("WELCOME_WINE_TEST", "onCreate: "+wine.toString());
        }

        for (Cellar cellar : database.getAllCellars()) {
            Log.i("WELCOME_WINE", "onCreate : "+cellar.toString());
        }

        database.closeDB();
    }


    private void populateDb(DbHelper database) {
        // adding dictionnaries data for grape/user/grower entities
        database.insertGrape(new Grape("toto"));
        database.insertGrape(new Grape("tata"));
        database.insertUser(new User("Prenom", "Nom", "mail@mail"));
        database.insertUser(new User("Samer", "Autre", "tzamer@mail"));
        database.insertGrower(new Grower("somGrower", "someAdrr","someAddr2", "someAddr3","maCity","zip","0000000000", "someMail"));
        database.insertGrower(new Grower("otherGrower", "someAdrr","someAddr2", "someAddr3","maCity","zip","0000000000", "someMail"));

        // adding wine referencing foreignKeys
        Grape g = database.getGrapeFromId(1);
        Grower gr = database.getGrowerFromId(2);
        database.insertWine(new Wine("bojolait", "domaine", "2012-01-12", g, gr));

        // adding wine with new Grower !
        Grape g1 = database.getGrapeFromId(1);
        Grower gr1 = new Grower("newOne", "addr", "addr2", "addr3", "cityAgain", "zipcode", "phonenumber", "email");
        Log.i("WELCOME_WINE", "populateDb: Grower without id new id : "+gr1.getId());
        database.insertWine(new Wine("bojolait", "domaine", "2012-01-12", g1, gr1));

        // adding cellar referencing foreignKeys
        Wine w = database.getWineFromId(1);
        User u = database.getUserFromId(1);
        Cellar c = new Cellar(w, u, 10);
        database.insertCellar(c);

        // adding cellar with new User
        Wine w1 = database.getWineFromId(1);
        User u1 = new User("user", "othernam", "maillllllllllllll");
        Cellar c1 = new Cellar(w1, u1, 5);
        database.insertCellar(c1);

    }
}
