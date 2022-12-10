/**
 * Vera Wise & Elias De Hondt
 * 8/12/2022
 */
// =====================================================================================================================
// Canvas KdG   Link = https://canvas.kdg.be/courses/37158/pages/afspraken-en-deadlines?module_item_id=663060
// Github       Link = https://github.com/EliasDeHondt/Memo-Race
// Google Docs  Link = https://docs.google.com/spreadsheets/d/199y9TW0weDEmgGD8Iv0UWyqQnMW8zF_RrBZ8XB4lQBc/edit#gid=0
// =====================================================================================================================
// TODO: - Voorzie een startscherm waar je de namen van de spelers kan ingeven.
//       - Elke speler kan een avatar kiezen of zelf een foto toevoegen.
//       - Voorzie een lijst op het scherm met eerder aangemaakte spelers. Sla deze op in een bestand.
//       - Zorg voor een mooi grafische vormgeving.
//       - Tijdens het spelverloop moet volgende zichtbaar zijn:
//              - Een dobbelsteen.
//              - Het speelveld met in het midden de omgedraaide kaarten.
//              - Per speler zijn naam, de avatar en de gewonnen kaarten.
//              - Een pion die automatisch verplaatst na een worp.
//       - Kaarten moeten met de muis omgedraaid kunnen worden.
//       - Als een figuur gevonden is moet het overeenkomstige vak een alternatieve opmaak
//         (bv. donkerder) krijgen zodat duidelijk is dat de pion deze vakken mag overslaan.
//       - Maak visueel zichtbaar welke speler aan de beurt is.
// =====================================================================================================================
// SPELBESCHRIJVING
/**
 * MemoRace is een variant op memory, maar een dobbelsteen zorgt voor een extra dimensie. Het
 * spel leert kinderen dezelfde vaardigheden als Memory en de dobbelsteen bevorderd het tellen.
 * Een pion loopt op een pad met in elk vak een verschillende afbeelding rond een speelveld. In het
 * speelveld liggen omgedraaide kaarten met de verschillende afbeeldingen. De spelers moeten
 * zoveel mogelijk van de afbeeldingen op het pad terugvinden bij de omgedraaide kaarten in het
 * midden van het speelveld. De speler die op het einde de meeste kaarten gevonden heeft wint
 * het spel. Het kan gespeeld worden met 2 tot 6 spelers
 * Hieronder een overzicht van de belangrijkste spelonderdelen:
 * • een spelbord
 * • 16 kaarten die willekeurig in het midden van het spelbord gelegd worden
 * • 1 dobbelsteen
 * • 1 pion
 */
// =====================================================================================================================
// SPELVERLOOP
/**
 * Er wordt om de beurt gespeeld. Het spel beslist random in welke
 * volgorde de spelers mogen spelen. De pion start op “go”. De eerste
 * speler werpt de dobbelsteen en zet de pion evenveel vakken (groene
 * genummerd in de afbeelding) vooruit. Elk vak toont een afbeelding.
 * Het is de bedoeling dat de speler de kaart met dezelfde afbeelding
 * omdraait (kaarten zijn de witte vakjes in de afbeelding). Als dat lukt,
 * dan krijgt hij de kaart. In het andere geval wordt de kaart terug
 * omgedraaid. Hierna is de beurt van deze speler om en is het aan de
 * volgende speler. Hij gooit en verplaatst de pion. Ook hij moet proberen
 * die kaart om te draaien die overeenkomt met de afbeelding van het
 * vak waar de pion nu op staat. Het spel loopt zo verder tot alle kaarten van het veld verdwenen
 * zijn. De persoon met de meeste kaarten wint het spel. De pion slaat de vakken met reeds
 * gevonden figuren en de hoekvakken over.
 */
// =====================================================================================================================
//public class Start {
//    // Attributen
//    // Constructors
//    // Methode
//    public void menu() {
//        Scanner key = new Scanner(System.in);
//        System.out.print(
//                """
//                ╔════════════════════════════╗
//                ║    Welcome to Memo Race    ║
//                ╠════════════════════════════╝
//                ╠[1 Play new game⌛]
//                ╠[2 Settings🔧]
//                ╠[3 Exit❌]
//                ║
//                """);
//        System.out.print("╠➤ ");
//        switch (key.nextInt()) {
//            case 1 -> System.exit(0); // this.playNewGame();
//            case 2 -> System.exit(0); // this.settings();
//            case 3 -> System.exit(0); // this.exit(0)
//        }
//    }
//}
///**
// * Van Elias De Hondt
// * 8/12/2022
// */
//public class Board {
//    // Attributen
//    // Constructors
//    // Methode
//}
//║
//╠═════╦═════╦═════╦═════╗
//║  %s  ║  %s  ║  %s  ║  %s  ║
//╠═════╬═════╬═════╬═════╣
//║  %s  ║  %s  ║  %s  ║  %s  ║
//╠═════╬═════╬═════╬═════╣
//║  %s  ║  %s  ║  %s  ║  %s  ║
//╠═════╬═════╬═════╬═════╣
//║  %s  ║  %s  ║  %s  ║  %s  ║
//╠═════╩═════╩═════╩═════╝
