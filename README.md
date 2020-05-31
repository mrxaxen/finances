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

	    user

	    admin

	jelszó

	    password

	    password

	szerepek

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

**Frontend dokumentáció:**

Fejlesztői nyelv

	typescript

Framework

	Angular v6.14.4
		Angular CLI 9.1.7
	Node js v12.17.0
	
Könyvtárszerkezet
	
	client
		e2e
		src
			app
				login-form
				routing
				transaction-detail
				transaction-form
				transaction-list
				transaction-statistics
			assets
			environments

Frontend futtatása

	**npm install** parancs futtatásával a modulok feltelepülnek
	
	**ng serve** parancs futtatásával elindul a compile
	
	Ezek után a http://localhost:4200/ címen indul a program helyi hálózaton

Kliensoldali szolgáltatások

	tranzkiók megekintése - bejlenkezés utána  kezdőképernyőn jelennek meg az eddig lezajlott tranzakciók
	
	statisztika - megmutatja, hogy eddig hány tranzakció zajlott le, és azt is, hogy a jeleleg mennyi pénzünk van
	
	tranzakciók módosítása - lehetőség van egyszerre egy tranzakciónak a nevének és/vagy az összegének a módosítására
	
	tranzakciók hozzáadása - új tranzakció felvétele az eddigiek közé
	
	részletek megtekintése - egy tranzakció címére kattintva, megtekinthető a részletes leírása
	
Tranzakció törlésének leírása:

	A tranzakciók közül az egyiknek a jobb oldalán lévő "delete" gombra rákattintva, a "transaction-list" komponens "onDeleteClick"
	függvénye meghívódik, majd ez triggel egy http hívást, ami hatására a backend jelet kap, hogy az adott tranzakciót törölnie kell 
	a belső (h2) adatbázisából.
	
Felhasználói use-case diagram:
	
	https://github.com/mrxaxen/finances/blob/develop/allapot_diagram.jpg

### TransactionController search endpoint lefutása:
 - Az endpoint kap egy GET utasítást egy Transaction példánnyal ami jelen esetben egy blueprintként szolgál, tartalmazza a keresett entitás paramétereit
 - Ebből készül egy Specification, melynek a toPredicate függvényét felüldefiniáltuk.
 - A függvényben aszerint hogy milyen paraméterek szerint szeretnénk szűrni(mely paraméterek nem null értékkel szerepelnek a kapott Transaction típusban) Predicate-eket hozunk létre amelyeket egy tömbben tárolunk, majd a függvény végén összefűzzük
 - A kapott predikátum átadásra kerül a repositorynak ami felhúz az adatbázisból minden olyan Transaction entitást amelyekre teljesülnek a Predicateben előírt feltételek
