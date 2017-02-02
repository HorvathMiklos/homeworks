# WebShop Java EE implementation
Original homework description (Hungarian):
>Ebben a háziban rest felületet kell biztosítani a mobil webshopnak, melyben lehetõség lesz többek között bejelentkezésre, mobilok kosárhoz adására, felhasználók kezelésére. A feladat megoldásához hozz létre egy új (mavenes) EE projektet, melybe a korábban megírt webshop részeket kell majd úgy átemelni, hogy azok mûködjenek továbbra is. Hozz létre REST service-eket a következõ mûveletekre:

## user:
- [ ] hozzáadás (csak admin tehesse meg, session-ben tárolt UserEntity alapján legyen eldöntve, admin e aki be van lépve)
- [ ] törlés (csak admin tehesse meg, session-ben tárolt UserEntity alapján legyen eldöntve, admin e aki be van lépve)
- [ ] lekérés username alapján (bárki megteheti)
- [x] összes lekérdezése (bárki megteheti)
- [x] bejelentkezés (sikeres bejelentkezés után kerüljön be a sessionbe a UserEntity)

## device:
- [ ] hozzáadás (csak admin tehesse meg, session-ben tárolt UserEntity alapján legyen eldöntve, admin e aki be van lépve)
- [ ] törlés (csak admin tehesse meg, session-ben tárolt UserEntity alapján legyen eldöntve, admin e aki be van lépve)
- [ ] lekérés id alapján (bárki megteheti)
- [x] összes lekérdezése (bárki megteheti)

## cart:
- [ ] device kosárhoz adás (bejelentkezést követõen tehetõ csak meg)
- [ ] device kosárból elvétel (bejelentkezést követõen tehetõ csak meg)
- [ ] kosár tartalmának megvásárlása vásárlás (bejelentkezést követõen tehetõ csak meg)

## Továbbá:
- [x] Hozz létre egy Singleton beant, ami az alkalmazás elindulásakor feltölti a UserDB-t és a DeviceDB-t. Itt az elõzõ projekt main metódusa által json fájlból való felolvasást kell átmozgatni/beilleszteni. A Main.java osztályra nincs szükség! (Ez egy külön singleton legyen, a UserDB és a DeviceDB osztályokon felül)
- [x] A DeviceDB és a UserDB legyen átalakítva Singleton beanné a korábbi háziból.
- [x] A Cart osztály (a korábbi háziból) legyen átalakítva Stateful beanné.
- [x] Az interceptorok, validáláshoz kapcsolódó osztályok, saját (eddigi) excpetion-ök, singletonok, stateful beanek kerüljenek az EJB modulba, továbbra is mûködjön az interceptor
- [x] A REST service-ek kerüljenek a WEB modulba
- [x] A REST service-ek minden saját exception-re json választ adjanak vissza
- [x] Legyen exception kezelés általánosan is, minden lehetséges exceptionre, melyre a szerver json választ adjon
- [x] az eddig megírt teszt osztályok is legyenek áttéve az új projektbe, és fusson le az összes korábbi teszt
- [ ] Az alkalmazás tesztelést manuálisan végezzétek el, minden rest endpointot teszteljetek. A teszteléshez használt json példákat tegyétek a repository-ba egy scripts mappába. Minden kéréshez tartozzon egy külön sh fájl (pl test-login.sh), ami curl-el végrehajtja a logint. (ez szintén a scripts mappába kerüljön). Így könnyen ti is újra tudjátok tesztelni az alkalmazást a fejlesztés során, és mások által is könnyen demonstrálható, tesztelhetõ lesz.

## Tesztelés:
A webshop rest interfésze legyen letesztelve, egy külön mappában (pl scripts) legyenek sorszámozott sh scriptek, amik a következõket teszik:
- [ ] bejelentkezés adminnal
- [ ] új felhasználó létrehozása adminnal
- [ ] kijelentkezés adminnal
- [ ] bejelentkezés új felhasználóval
- [ ] 1 Device kosárhoz adása
- [ ] 1 másik Device kosárhoz adása
- [ ] Elsõ kosárhoz adott device-ból még egyet adjon a kosárhoz
- [ ] kosár tartalmának megvásárlása
- [ ] kijelentkezés

## Backlog / TODO 
- [ ] 