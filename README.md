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
o	java
Framework
o	spring boot
Használt dependenciák
o	JPA
o	DevTools
o	H2
o	Lombok
o	Web
o	Security
Adatbázis
o	H2
Adatbázis név
o	mydb
Adatbázis elérése
o	http://localhost:8080/h2
Websecurity beállítása
o	web.ignoring().antMatchers("/h2/");
Autentikáció
o	felhasználónevek
	    user1
	    user2
	    admin
o	jelszó
	    user1Pass
	    user2Pass
	    adminPass
o	szerepek
	    USER
	    USER
	    ADMIN

Könyvtárszerkezetek:
Kontrollerek
o	hu.elte.finances.controllers
Entitások
o	hu.elte.finances.entities
Repository-k
o	hu.elte.finances.repositories
Biztonsági beállítások
o	hu.elte.finances.security

