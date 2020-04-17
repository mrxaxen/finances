**Használhatóság:**

-A felhasználó költségvetésének a fokozatos nyílántartására alkalmas alkalmazás.

**Funckciók:**

-Bevételek és költségek megjelenítése speciális szűrőkkel mint pl 
    jelenlegi hét, hónap, év, összes, legnagyobb összeg, legkisebb összeg, 
    kiadások, bevételek
    
-Kiadás és bevétel hozzáadása

-Havi vagy rendszeres bevétel hozzáadása, ami autómatikusan kerül felszámolásra

-Statisztika készítésére is alkalmas, megtekinthetjük, hogy az adott hónapban
    mennyi pénzünk maradt, és mennyi idő van hétra a következő bevételig, 
    valamint arra is lehetőség van, hogy megtudjuk hogy az adott héten mennyit
    költhetünk átlagosan a hónapon belül, és jelez ha túl sokat költöttünk
    
-Felhasználók közötti költségmegosztás

Belépés és autentikáció:

-Az oldalra lehet regisztrálni, és regisztráció után, a megadott jelszóval és 
    felhasználónévvel lehet bejelentkezni. Ezek után a felhasználó elérheti a 
    saját adatait


**Backend dokumentáció:**

Fejlesztői nyelv

	java

Framework

	spring boot

Használt dependenciák

	JPA

  	DevTools

    H2

    Lombok
   
    Web

    Security


Adatbázis

    H2

Adatbázis név
   
   mydb

Adatbázis elérése

	http://localhost:8080/h2

Websecurity beállítása

    web.ignoring().antMatchers("/h2/");

Autentikáció

	felhasználónevek

	    user1

	    user2

	    admin

	jelszó

	    user1Pass

	    user2Pass

	    adminPass

	szerepek

	    USER

	    USER

	    ADMIN

Könyvtárszerkezetek:

Kontrollerek

	hu.elte.finances.controllers

Entitások

    hu.elte.finances.entities

Repository-k

	hu.elte.finances.repositories

Biztonsági beállítások

    hu.elte.finances.security

Adatbázis UML diagram

https://github.com/mrxaxen/finances/blob/develop/finances_diagram3.jpg

### TransactionController search endpoint lefutása:
 - Az endpoint kap egy GET utasítást egy Transaction példánnyal ami jelen esetben egy blueprintként szolgál, tartalmazza a keresett entitás paramétereit
 - Ebből készül egy Specification, melynek a toPredicate függvényét felüldefiniáltuk.
 - A függvényben aszerint hogy milyen paraméterek szerint szeretnénk szűrni(mely paraméterek nem null értékkel szerepelnek a kapott Transaction típusban) Predicate-eket hozunk létre amelyeket egy tömbben tárolunk, majd a függvény végén összefűzzük
 - A kapott predikátum átadásra kerül a repositorynak ami felhúz az adatbázisból minden olyan Transaction entitást amelyekre teljesülnek a Predicateben előírt feltételek